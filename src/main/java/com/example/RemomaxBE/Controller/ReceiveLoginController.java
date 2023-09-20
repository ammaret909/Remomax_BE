package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTO.DecodeRCCDTO;
import com.example.RemomaxBE.DTO.RCCRactiveDTO;
import com.example.RemomaxBE.DTOout.LoginAndLogoutDashboardDTOout;
import com.example.RemomaxBE.DTOout.TimeRCCDTOout;
import com.example.RemomaxBE.Model.ReceiveLoginModel;
import com.example.RemomaxBE.Service.RCCService;
import com.example.RemomaxBE.Service.ReceiveLoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ReceiveLoginController {
    @Autowired
    ReceiveLoginService receiveLoginService;

    @PostMapping("receive/logout")
    public void receiveLogout(@RequestBody RCCRactiveDTO rccRactiveDTO, HttpServletRequest request){
        String clientIp = request.getRemoteAddr();
        receiveLoginService.receiveLogout(rccRactiveDTO,clientIp);
    }
    @GetMapping("dashboard/login_logout")
    public List<LoginAndLogoutDashboardDTOout> dashboardLoginAndLogout() throws IOException {
        return receiveLoginService.dashboardLoginAndLogout();
    }
//    @GetMapping("receive/test")
//    public ReceiveLoginModel testFindLoginLogout(){
//        return receiveLoginService.testFindLoginLogout();
//    }
}
