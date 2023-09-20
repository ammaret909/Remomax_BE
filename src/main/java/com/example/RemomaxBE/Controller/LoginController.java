package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTO.CheckLoginDTO;
import com.example.RemomaxBE.DTO.LoginDTO;
import com.example.RemomaxBE.DTO.RCCRactiveDTO;
import com.example.RemomaxBE.DTOout.LosloginDTOout;
import com.example.RemomaxBE.DTOout.UserDTOout;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.LosLoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Repository.LoginRepository;
import com.example.RemomaxBE.Service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("user/{RCC}")
    public LoginModel getUserByRCC(@PathVariable String RCC) {
        return loginService.getUserByRCC(RCC);
    }

    @GetMapping("user")
    public List<LoginModel> findAll() {
        return loginService.findAllUser();
    }

    @PostMapping("user")
    public LoginModel createUser(@RequestBody LoginDTO loginDTO) throws NoSuchAlgorithmException {
        return loginService.saveUser(loginDTO);
    }

    @PutMapping("user")
    public LoginModel putUser(@RequestBody UserDTOout userDTOout) throws NoSuchAlgorithmException {
        return loginService.putUser(userDTOout);
    }

    @PostMapping("user/delete")
    public void DeleteUser(@RequestBody List<RCCRactiveDTO> rccRactiveDTOS){
        loginService.deleteUser(rccRactiveDTOS);
    }

    @PostMapping("check/login")
    public ResponseEntity<MassageModel> CheckLogin(@RequestBody CheckLoginDTO checkLoginDTO,HttpServletRequest request) throws NoSuchAlgorithmException {
        String clientIp = request.getRemoteAddr();
        return loginService.CheckLogin(checkLoginDTO,clientIp);
    }

    @GetMapping("loslogin")
    public List<LosloginDTOout> FindLosloginByRactive(){
        return loginService.FindLosloginByRactive();
    }

    @PostMapping("loslogin/delete")
    public void DeleteLoslogin(@RequestBody List<RCCRactiveDTO> rccRactiveDTOS){
        loginService.deleteLoslogin(rccRactiveDTOS);
    }

    @GetMapping("level")
    public List<LoginModel> sortByRole(){

        return loginService.sortByLevle();
    }

}
