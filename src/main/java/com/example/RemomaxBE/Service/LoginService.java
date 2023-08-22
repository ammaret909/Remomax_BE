package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTO.CheckLoginDTO;
import com.example.RemomaxBE.DTO.LoginDTO;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.LosLoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Repository.LoginRepository;
import com.example.RemomaxBE.Repository.LosLoginRepository;
import com.example.RemomaxBE.Repository.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<LoginModel> getAllUsers() {
        return loginRepository.findAll();
    }

    public LoginModel saveUser(LoginDTO loginDTO) {
        LoginModel loginModel = new LoginModel();
        loginModel.setRCC(loginDTO.getRCC());
        loginModel.setUSERID(loginDTO.getUSERID());
        loginModel.setDRAWSSAP(loginDTO.getDRAWSSAP());
        return loginRepository.save(loginModel);
    }

    public LoginModel getUserById(Long ID) {
        return loginRepository.findById(ID).orElse(null);
    }

    public void deleteUser(Long ID) {
        loginRepository.deleteById(ID);
    }

    public ResponseEntity<MassageModel> CheckLogin(CheckLoginDTO checkLoginDTO,String clientIp) {
        LoginModel loginModel = loginRepository.findByUSERID(checkLoginDTO.getUSERID());
        if(loginModel != null && loginModel.getDRAWSSAP().equals(checkLoginDTO.getDRAWSSAP())) {
            MassageModel massageModel = new MassageModel();
            return ResponseEntity.ok(massageModel);
        }
//        else if(loginModel != null && !loginModel.getDRAWSSAP().equals(checkLoginDTO.getDRAWSSAP())) {
//            LosLoginModel losLoginModel = new LosLoginModel();
//            losLoginModel.setRcc(rccService.createRcc().getCheck_rcc());
//            losLoginModel.setUser(checkLoginDTO.getUSERID());
//            losLoginModel.setPassword(checkLoginDTO.getDRAWSSAP());
//            losLoginModel.setIP(clientIp);
//            losLoginModel.setCheckLogin(countLoginFail(checkLoginDTO));
//            losLoginModel.setAlert(checkLoginFalse(losLoginModel.getCheckLogin()));
//            losLoginModel.setApproveby("");
//            losLoginModel.setApprovedate("");
//            losLoginModel.setRactive("");
//            losLoginModel.setRemark("");
//            losLoginModel.setRistory("");
//            losLoginRepository.save(losLoginModel);
//
//            MassageModel massageModel = massageRepository.findByID(11L);
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);

//        MassageModel massageModel = massageRepository.findByID(12L);
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);
//        }
        else {
            LosLoginModel losLoginModel = new LosLoginModel();
            losLoginModel.setRcc(rccService.createRcc().getCheck_rcc());
            losLoginModel.setUser(checkLoginDTO.getUSERID());
            losLoginModel.setPassword(checkLoginDTO.getDRAWSSAP());
            losLoginModel.setIP(clientIp);
            losLoginModel.setCheckLogin(countLoginFail(checkLoginDTO));
            losLoginModel.setAlert(checkLoginFalse(losLoginModel.getCheckLogin()));
            losLoginModel.setApproveby("");
            losLoginModel.setApprovedate("");
            losLoginModel.setRactive("");
            losLoginModel.setRemark("");
            losLoginModel.setRistory("");
            losLoginRepository.save(losLoginModel);

            MassageModel massageModel = massageRepository.findByID(14L);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);
        }
    }

    public int countLoginFail(CheckLoginDTO checkLoginDTO){
        int countLogin = (int) losLoginRepository.countByUser(checkLoginDTO.getUSERID());
        int loginNumber = countLogin + 1;
        return loginNumber;
    }

    private String checkLoginFalse(int checkLogin) {
        if(checkLogin == 5){
            return rccService.createRcc().getCheck_rcc();
        }
        return "";
    }

}
