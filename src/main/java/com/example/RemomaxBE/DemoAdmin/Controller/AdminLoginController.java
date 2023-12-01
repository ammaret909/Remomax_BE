package com.example.RemomaxBE.DemoAdmin.Controller;

import com.example.RemomaxBE.DemoAdmin.DTO.LoginDTO;
import com.example.RemomaxBE.DemoAdmin.Model.AdminLoginModel;
import com.example.RemomaxBE.DemoAdmin.Service.AdminLoginService;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AdminLoginController {
    @Autowired
    AdminLoginService adminLoginService;

    @PostMapping("/admin/check/login")
    public ResponseEntity<MassageModel> adminCheckLogin(@RequestBody LoginDTO loginDTO){
        return adminLoginService.adminCheckLogin(loginDTO);
    }
}
