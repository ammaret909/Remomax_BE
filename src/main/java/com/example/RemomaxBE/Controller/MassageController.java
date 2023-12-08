package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTO.*;
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

    @PostMapping("/massage/search")
    public List<MassageModel> getMassageSearch(@RequestBody SearchDTO searchDTO) {
        return massageService.getMassage(searchDTO);
    }
    @PostMapping("/massage/data")
    public MassageModel getMassageById(@RequestBody SearchDTO searchDTO) {
        return massageService.getMassageById(searchDTO);
    }
    @PostMapping("/massage")
    public MassageModel createMassage(@RequestBody MassageDTO massageDTO) {
        return massageService.saveMassage(massageDTO);
    }
    @PutMapping("/massage/edit")
    public MassageModel editMassage(@RequestBody EditMassageDTO editMassageDTO) {
        return massageService.editMassage(editMassageDTO);
    }
}
