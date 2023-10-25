package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTO.EditMassageDTO;
import com.example.RemomaxBE.DTO.MassageDTO;
import com.example.RemomaxBE.DTO.SearchDTO;
import com.example.RemomaxBE.DTO.SearchPageDTO;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Repository.LoginRepository;
import com.example.RemomaxBE.Repository.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MassageService {
    @Autowired
    MassageRepository massageRepository;
    @Autowired
    RCCService rccService;

    public List<MassageModel> getAllMassage() {
        return massageRepository.findAll();
    }

    public List<MassageModel> getMassage(SearchDTO searchDTO) {
        List<MassageModel> massageModels;
        if(searchDTO.getSearch() == ""){
            massageModels = massageRepository.findAll();
            return massageModels;
        }
        massageModels = massageRepository.findAllByID(searchDTO.getSearch());
        return massageModels;
    }

    public MassageModel getMassageById(SearchDTO searchDTO) {
        MassageModel massageModel = massageRepository.findById(searchDTO.getSearch()).orElse(null);
        return massageModel;
    }

    public MassageModel saveMassage(MassageDTO massageDTO) {
        MassageModel massageModel = new MassageModel();
        massageModel.setRCC(rccService.createRcc().getCheck_rcc());
        massageModel.setID(runNumberMassage(massageRepository.countAlertMassage()));
        massageModel.setMassage(massageDTO.getMassage());
        massageModel.setDescription(massageDTO.getDescription());
        return massageRepository.save(massageModel);
    }

    public String runNumberMassage(Long countRunNumber){
        if(countRunNumber < 10){
            return "000" + countRunNumber;
        }
        else if(countRunNumber < 100){
            return "00" + countRunNumber;
        }
        else if(countRunNumber < 1000){
            return "0" + countRunNumber;
        }
        else {
            return countRunNumber.toString();
        }
    }

    public MassageModel editMassage(EditMassageDTO editMassageDTO) {
        MassageModel massageModel = massageRepository.findById(editMassageDTO.getRcc()).orElse(null);
        massageModel.setMassage(editMassageDTO.getMassage());
        massageModel.setDescription(editMassageDTO.getDescription());
        return massageRepository.save(massageModel);
    }
}
