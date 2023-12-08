package com.example.RemomaxBE.DemoAdmin.Service;

import com.example.RemomaxBE.DemoAdmin.DTO.LoginDTO;
import com.example.RemomaxBE.DemoAdmin.Model.AdminLoginModel;
import com.example.RemomaxBE.DemoAdmin.Repository.AdminLoginRepository;
import com.example.RemomaxBE.Model.LosLoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Repository.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {
    @Autowired
    AdminLoginRepository adminLoginRepository;
    @Autowired
    MassageRepository massageRepository;

    public ResponseEntity<MassageModel> adminCheckLogin(LoginDTO loginDTO) {
        AdminLoginModel adminLoginModel = adminLoginRepository.findByUSERIDAndDRAWSSAP(loginDTO.getEmail(),loginDTO.getPassword());
        if(adminLoginModel != null ){
            MassageModel massageModel = new MassageModel();
            return ResponseEntity.ok(massageModel);
        }else {
            MassageModel massageModel = massageRepository.findByID("0002");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(massageModel);
        }
    }
}
