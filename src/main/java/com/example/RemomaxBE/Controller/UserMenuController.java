package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTO.MenuDTO;
import com.example.RemomaxBE.DTO.RCCRactiveDTO;
import com.example.RemomaxBE.DTO.SearchDTO;
import com.example.RemomaxBE.DTO.UsermenuDTO;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.UserMenuModel;
import com.example.RemomaxBE.Service.ReceiveLoginService;
import com.example.RemomaxBE.Service.UserMenuService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserMenuController {
    @Autowired
    UserMenuService userMenuService;

    @PostMapping("/menu/search")
    public void manageCreate(@RequestBody UsermenuDTO UsermenuDTO){
        userMenuService.manageUsermenu(UsermenuDTO);
    }

    @PostMapping("/menu")
    public List<UserMenuModel> menuData(@RequestBody SearchDTO searchDTO){
        return userMenuService.menuData(searchDTO);
    }

    @PostMapping("/menu/level")
    public List<LoginModel> menuLevel(@RequestBody SearchDTO searchDTO){
        return userMenuService.menuLevel(searchDTO);
    }
}
