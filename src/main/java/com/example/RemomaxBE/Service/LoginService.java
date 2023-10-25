package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTO.CheckLoginDTO;
import com.example.RemomaxBE.DTO.DecodeRCCDTO;
import com.example.RemomaxBE.DTO.LoginDTO;
import com.example.RemomaxBE.DTO.RCCRactiveDTO;
import com.example.RemomaxBE.DTOout.LosloginDTOout;
import com.example.RemomaxBE.DTOout.UserDTOout;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.LosLoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Repository.LoginRepository;
import com.example.RemomaxBE.Repository.LosLoginRepository;
import com.example.RemomaxBE.Repository.MassageRepository;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    MassageRepository massageRepository;
    @Autowired
    LosLoginRepository losLoginRepository;
    @Autowired
    RCCService rccService;
    @Autowired
    ReceiveLoginService receiveLoginService;

    public LoginModel saveUser(LoginDTO loginDTO) throws NoSuchAlgorithmException {
        LoginModel loginModel = new LoginModel();
        loginModel.setRCC(rccService.createRcc().getCheck_rcc());
        loginModel.setUSERID(loginDTO.getUSERID());
        loginModel.setDRAWSSAP(hashDRAWSSAP(loginDTO.getDRAWSSAP()));
        loginModel.setFullname(loginDTO.getFullname());
        loginModel.setLevel(loginDTO.getLevel());
        loginModel.setRistory(rccService.createRcc().getCheck_rcc());
        loginModel.setRactive("0");
        loginModel.setSecret(loginDTO.getDRAWSSAP());
        return loginRepository.save(loginModel);
    }

    public String hashDRAWSSAP(String DRAWSSAP) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(DRAWSSAP.getBytes());
        String md5Password = MD5Encoder.encode(messageDigest);
        return md5Password.toString();
    }

    public LoginModel getUserByRCC(String RCC) {
        LoginModel loginModel = loginRepository.findByRCC(RCC);
        return loginModel;
    }

    public LoginModel putUser(UserDTOout userDTOout) throws NoSuchAlgorithmException {
        LoginModel loginModel = loginRepository.findByRCC(userDTOout.getRCC());
        loginModel.setUSERID(userDTOout.getUSERID());
        loginModel.setDRAWSSAP(hashDRAWSSAP(userDTOout.getDRAWSSAP()));
        loginModel.setSecret(userDTOout.getDRAWSSAP());
        loginModel.setFullname(userDTOout.getFullname());
        loginModel.setLevel(userDTOout.getLevel());
        loginModel.setRistory(rccService.createRcc().getCheck_rcc());
        return loginRepository.save(loginModel);
    }

    public ResponseEntity<MassageModel> CheckLogin(CheckLoginDTO checkLoginDTO,String clientIp) throws NoSuchAlgorithmException {
        LoginModel loginModel = loginRepository.findByUSERID(checkLoginDTO.getUSERID());
        if(loginModel == null){
            LosLoginModel losLoginModel = new LosLoginModel();
            losLoginModel.setRcc(rccService.createRcc().getCheck_rcc());
            losLoginModel.setUser(checkLoginDTO.getUSERID());
            losLoginModel.setPassword(hashDRAWSSAP(checkLoginDTO.getDRAWSSAP()));
            losLoginModel.setIP(clientIp);
            losLoginModel.setCheckLogin(countLoginFail(checkLoginDTO));
            losLoginModel.setAlert(checkLoginFalse(losLoginModel.getCheckLogin()));
            losLoginModel.setApproveby("");
            losLoginModel.setApprovedate("");
            losLoginModel.setRactive("0");
            losLoginModel.setRemark("");
            losLoginModel.setRistory("");
            losLoginRepository.save(losLoginModel);

            MassageModel massageModel = massageRepository.findByID("0002");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);
        }

        Optional<LosLoginModel> CheckLosLoginModel = Optional.ofNullable(losLoginRepository.findByUserAndCheckLogin(loginModel.getUSERID(),5));
        String MD5DRAWSSAPInput = hashDRAWSSAP(checkLoginDTO.getDRAWSSAP());

        if(loginModel != null && loginModel.getDRAWSSAP().equals(MD5DRAWSSAPInput) && CheckLosLoginModel.isPresent()){
            LosLoginModel CheckRactiveLosLoginModel = losLoginRepository.findByUserAndCheckLogin(loginModel.getUSERID(),5);
            if(!CheckRactiveLosLoginModel.getRactive().equals("0")){
                MassageModel massageModel = new MassageModel();
                return ResponseEntity.ok(massageModel);
            }
            MassageModel massageModel = massageRepository.findByID("0001");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);
        }
        else if(loginModel != null && loginModel.getDRAWSSAP().equals(MD5DRAWSSAPInput)  && !loginModel.getRactive().equals("1")) {
            MassageModel massageModel = new MassageModel();
            massageModel.setRCC(loginModel.getRCC());
            receiveLoginService.receivelLogin(loginModel,clientIp);
            return ResponseEntity.ok(massageModel);
        }
        else {
            LosLoginModel losLoginModel = new LosLoginModel();
            losLoginModel.setRcc(rccService.createRcc().getCheck_rcc());
            losLoginModel.setUser(checkLoginDTO.getUSERID());
            losLoginModel.setPassword(hashDRAWSSAP(checkLoginDTO.getDRAWSSAP()));
            losLoginModel.setIP(clientIp);
            losLoginModel.setCheckLogin(countLoginFail(checkLoginDTO));
            losLoginModel.setAlert(checkLoginFalse(losLoginModel.getCheckLogin()));
            losLoginModel.setApproveby("");
            losLoginModel.setApprovedate("");
            losLoginModel.setRactive("0");
            losLoginModel.setRemark("");
            losLoginModel.setRistory("");
            losLoginRepository.save(losLoginModel);

            MassageModel massageModel = massageRepository.findByID("0002");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);
        }
    }

    public int countLoginFail(CheckLoginDTO checkLoginDTO){
        String rccNow = rccService.createRcc().getCheck_rcc();
        String rccDay = rccNow.substring(0,5);

        int countLoginByDay = losLoginRepository.countByRccStartingWithAndUserAndRactive(rccDay,checkLoginDTO.getUSERID(),"0");
        int loginNumber = countLoginByDay + 1;
        return loginNumber;
    }

    private String checkLoginFalse(int checkLogin) {
        if(checkLogin == 5){
            return rccService.createRcc().getCheck_rcc();
        }
        return "";
    }

    public List<LosloginDTOout> FindLosloginByRactive() {
        List<LosLoginModel> losLoginModels = losLoginRepository.findAllByRactive("0");
        List<LosloginDTOout> losloginDTOouts = new ArrayList<>();

        for (LosLoginModel losLoginModel : losLoginModels) {
            LosloginDTOout losloginDTOout = convertToLosloginDTOouts(losLoginModel);
            losloginDTOouts.add(losloginDTOout);
        }
        return losloginDTOouts;
    }

    public LosloginDTOout convertToLosloginDTOouts(LosLoginModel losLoginModel){
        LosloginDTOout losloginDTOout = new LosloginDTOout();
        DecodeRCCDTO decodeRCCDTO = new DecodeRCCDTO();
        decodeRCCDTO.setRCC(losLoginModel.getRcc());

        losloginDTOout.setRcc(losLoginModel.getRcc());
        losloginDTOout.setTime(rccService.decodeRCC(decodeRCCDTO).getTime());
        losloginDTOout.setLosname(losLoginModel.getUser());
        losloginDTOout.setLospassw(losLoginModel.getPassword());
        losloginDTOout.setIPin(losLoginModel.getIP());
        losloginDTOout.setSeqlose(losLoginModel.getCheckLogin());
        losloginDTOout.setAlert(losLoginModel.getAlert());
        return losloginDTOout;
    }

    public void deleteLoslogin(List<RCCRactiveDTO> rccRactiveDTOS){
        for (RCCRactiveDTO dto : rccRactiveDTOS) {
            LosLoginModel losLoginModel = losLoginRepository.findById(dto.getRCC()).orElse(null);
            losLoginModel.setRactive("1");
            losLoginRepository.save(losLoginModel);
        }
    }

    public List<LoginModel> findAllUser() {
        List<LoginModel> loginModelList = loginRepository.findAllByRactive("0");
        return loginModelList;
    }

    public List<LoginModel> sortByLevle() {
        List<LoginModel> loginModelList = loginRepository.findAllByRactive("0");
        List<LoginModel> sortedItems = loginModelList.stream().sorted(Comparator.comparing(LoginModel::getLevel))
                .collect(Collectors.toList());
        return sortedItems;
    }

    public void deleteUser(List<RCCRactiveDTO> rccRactiveDTOS) {
        for (RCCRactiveDTO dto : rccRactiveDTOS) {
            LoginModel loginModel = loginRepository.findById(dto.getRCC()).orElse(null);
            loginModel.setRactive("1");
            loginRepository.save(loginModel);
        }
    }
}
