package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTO.LoginDTO;
import com.example.RemomaxBE.DTO.MassageDTO;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Service.LoginService;
import com.example.RemomaxBE.Service.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MassageController {
    @Autowired
    MassageService massageService;

    @GetMapping("/massage")
    public List<MassageModel> getAllMassage() {
        return massageService.getAllMassage();
    }
    @GetMapping("/massage/{ID}")
    public MassageModel getMassageById(@PathVariable Long ID) {
        return massageService.getMassage(ID);
    }

    @PostMapping("/massage")
    public MassageModel createMassage(@RequestBody MassageDTO massageDTO) {
        return massageService.saveMassage(massageDTO);
    }
}
