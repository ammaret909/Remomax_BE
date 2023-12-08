package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTO.MenuDTO;
import com.example.RemomaxBE.DTO.SearchDTO;
import com.example.RemomaxBE.DTO.UsermenuDTO;
import com.example.RemomaxBE.Model.HeaderAllModel;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.UserMenuModel;
import com.example.RemomaxBE.Repository.LoginRepository;
import com.example.RemomaxBE.Repository.UserMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserMenuService {
    @Autowired
    RCCService rccService;
    @Autowired
    UserMenuRepository userMenuRepository;
    @Autowired
    LoginRepository loginRepository;

    public void manageUsermenu(UsermenuDTO UsermenuDTO) {
        List<UserMenuModel> userMenuModels = userMenuRepository.findAllMenuByUrcc(UsermenuDTO.getRcc());
        for(UserMenuModel userMenuModel : userMenuModels){
            userMenuRepository.deleteById((userMenuModel.getRcc()));
        }
        LoginModel loginModel = loginRepository.findByRCC(UsermenuDTO.getRcc());
        int sequence = 0;
        for (MenuDTO menuData : UsermenuDTO.getMenu()) {
            if((menuData.getMenutext() == "" || menuData.getMenutext() == null) && (menuData.getLinkurl() == "" || menuData.getLinkurl() == null) ){

            }
            else if((menuData.getMenutext() != "" || menuData.getMenutext() != null) && (menuData.getLinkurl() != "" || menuData.getLinkurl() != null) && menuData.getRcc() != ""){
                UserMenuModel userMenuModel = new UserMenuModel();
                userMenuModel.setRcc(menuData.getRcc());
                userMenuModel.setMenutext(menuData.getMenutext());
                userMenuModel.setLinkurl(menuData.getLinkurl());
                userMenuModel.setRemark(menuData.getRemark());
                userMenuModel.setUrcc(loginModel);
                userMenuModel.setSeq(sequence = sequence + 1);
                userMenuModel.setRactive("0");
                userMenuModel.setRistory(rccService.createRcc().getCheck_rcc());
                userMenuRepository.save(userMenuModel);
            }
            else {
                UserMenuModel userMenuModel = new UserMenuModel();
                userMenuModel.setRcc(rccService.createRcc().getCheck_rcc());
                userMenuModel.setMenutext(menuData.getMenutext());
                userMenuModel.setLinkurl(menuData.getLinkurl());
                userMenuModel.setRemark(menuData.getRemark());
                userMenuModel.setUrcc(loginModel);
                userMenuModel.setSeq(sequence = sequence + 1);
                userMenuModel.setRactive("0");
                userMenuModel.setRistory(rccService.createRcc().getCheck_rcc());
                userMenuRepository.save(userMenuModel);
            }
        }
    }

    public List<UserMenuModel> menuData(SearchDTO searchDTO) {
        List<UserMenuModel> userMenuModels = userMenuRepository.findAllMenuByUrcc(searchDTO.getSearch());
        return userMenuModels;
    }


    public List<LoginModel> menuLevel(SearchDTO searchDTO) {
        LoginModel loginModel = loginRepository.findByRCC(searchDTO.getSearch());
        return loginRepository.findByLevelStartingWith(loginModel.getLevel());
    }
}
