package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTO.DecodeRCCDTO;
import com.example.RemomaxBE.DTO.RCCDTO;
import com.example.RemomaxBE.DTOout.TimeRCCDTOout;
import com.example.RemomaxBE.Model.RCCModel;
import com.example.RemomaxBE.Service.RCCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RCCController {
    @Autowired
    RCCService rccService;

    @GetMapping("/createRCC")
    public RCCModel createRCC() {
        return rccService.createRcc();
    }

    @PostMapping("/decodeRCC")
    public TimeRCCDTOout decodeRCC(@RequestBody DecodeRCCDTO decodeRCCDTO){
        return rccService.decodeRCC(decodeRCCDTO);
    }

}
