package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTO.RCCRactiveDTO;
import com.example.RemomaxBE.DTOout.LoginAndLogoutDashboardDTOout;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.LosLoginModel;
import com.example.RemomaxBE.Model.ReceiveLoginModel;
import com.example.RemomaxBE.Repository.LoginRepository;
import com.example.RemomaxBE.Repository.ReceiveLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiveLoginService {
    @Autowired
    ReceiveLoginRepository receiveLoginRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    RCCService rccService;

    public void receivelLogin(LoginModel loginModel,String clientIp) {
        ReceiveLoginModel receiveLoginModel = new ReceiveLoginModel();
        receiveLoginModel.setRCC(rccService.createRcc().getCheck_rcc());
        receiveLoginModel.setRCCU(loginModel.getRCC());
        receiveLoginModel.setInOrOut("0");
        receiveLoginModel.setIP(clientIp);
        receiveLoginRepository.save(receiveLoginModel);
    }

    public void receiveLogout(RCCRactiveDTO rccRactiveDTO, String clientIp) {
        ReceiveLoginModel receiveLoginModel = new ReceiveLoginModel();
        receiveLoginModel.setRCC(rccService.createRcc().getCheck_rcc());
        receiveLoginModel.setRCCU(rccRactiveDTO.getRCC());
        receiveLoginModel.setIP(clientIp);
        receiveLoginModel.setInOrOut("1");
        receiveLoginRepository.save(receiveLoginModel);
    }

    public List<LoginAndLogoutDashboardDTOout> dashboardLoginAndLogout() throws IOException {
        List<LoginModel> loginModels = loginRepository.findAll();
        List<LoginAndLogoutDashboardDTOout> loginAndLogoutDashboardDTOouts = new ArrayList<>();

        for (LoginModel loginModel : loginModels) {
            LoginAndLogoutDashboardDTOout loginDataOfList = new LoginAndLogoutDashboardDTOout();
            loginDataOfList.setUSERID(loginModel.getUSERID());
            try {
                loginDataOfList.setLoginRCC(rccService.decodeRCCGetString(receiveLoginRepository.findFirstLogin(loginModel.getRCC()).getRCC()));
                loginDataOfList.setLogoutRCC(rccService.decodeRCCGetString(receiveLoginRepository.findFirstLogout(loginModel.getRCC()).getRCC()));
                loginDataOfList.setCountLogin(receiveLoginRepository.findCountLogin(loginModel.getRCC()));
                loginDataOfList.setCountLogout(receiveLoginRepository.findCountLogout(loginModel.getRCC()));
            }catch (Exception e){
                loginDataOfList.setLoginRCC("-");
                loginDataOfList.setLogoutRCC("-");
                loginDataOfList.setCountLogin("-");
                loginDataOfList.setCountLogout("-");
            }
            loginAndLogoutDashboardDTOouts.add(loginDataOfList);
        }
        return loginAndLogoutDashboardDTOouts;
    }

//    public ReceiveLoginModel testFindLoginLogout(){
//        ReceiveLoginModel receiveLoginModel = new ReceiveLoginModel();
//        receiveLoginModel.setIP(receiveLoginRepository.findFirstRccuAndIn_or_out("7E791I1218AA").getRCC());
//        return receiveLoginModel;
//    }
}
