package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTO.CheckLoginDTO;
import com.example.RemomaxBE.DTO.LoginDTO;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Repository.LoginRepository;
import com.example.RemomaxBE.Service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/user")
    public List<LoginModel> getAllUsers() {
        return loginService.getAllUsers();
    }

    @GetMapping("/user/{ID}")
    public LoginModel getUserById(@PathVariable Long ID) {
        return loginService.getUserById(ID);
    }

    @PostMapping("/user")
    public LoginModel createUser(@RequestBody LoginDTO loginDTO) {
        return loginService.saveUser(loginDTO);
    }

    @DeleteMapping("user/{ID}")
    public void deleteUser(@PathVariable Long ID) {
        loginService.deleteUser(ID);
    }

    @PostMapping("/check/login")
    public ResponseEntity<MassageModel> CheckLogin(@RequestBody CheckLoginDTO checkLoginDTO,HttpServletRequest request){
        String clientIp = request.getRemoteAddr();
        return loginService.CheckLogin(checkLoginDTO,clientIp);
    }
}
