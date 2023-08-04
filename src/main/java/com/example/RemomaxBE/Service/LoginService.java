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
            MassageModel massageModel = massageRepository.findByID(13L);
            return ResponseEntity.ok(massageModel);
        }
        else if(loginModel != null && !loginModel.getDRAWSSAP().equals(checkLoginDTO.getDRAWSSAP())) {
            LosLoginModel losLoginModel = new LosLoginModel();
            losLoginModel.setRCC("7E782K2423JG4");
            losLoginModel.setUser(checkLoginDTO.getUSERID());
            losLoginModel.setPassword(checkLoginDTO.getDRAWSSAP());
            losLoginModel.setIP(clientIp);
            losLoginModel.setChecked("1");
            losLoginModel.setCheckLogin(countLoginFail(checkLoginDTO));
            losLoginModel.setAlert("");
            losLoginModel.setApproveby("");
            losLoginModel.setApprovedate("");
            losLoginModel.setRactive("");
            losLoginModel.setRemark("");
            losLoginModel.setRistory("");
            losLoginRepository.save(losLoginModel);

            MassageModel massageModel = massageRepository.findByID(11L);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);
        }
        else {
            MassageModel massageModel = massageRepository.findByID(12L);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);
        }
    }

    public String countLoginFail(CheckLoginDTO checkLoginDTO){
        Long countLogin = losLoginRepository.countByUser(checkLoginDTO.getUSERID());
        Long loginNumber = countLogin + 1;
        return String.valueOf(loginNumber);
    }

}
