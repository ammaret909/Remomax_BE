package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTO.MassageDTO;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import com.example.RemomaxBE.Repository.LoginRepository;
import com.example.RemomaxBE.Repository.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MassageService {
    @Autowired
    MassageRepository massageRepository;

    public List<MassageModel> getAllMassage() {
        return massageRepository.findAll();
    }

    public MassageModel getMassage(Long ID) {
        return massageRepository.findById(ID).orElse(null);
    }

    public MassageModel saveMassage(MassageDTO massageDTO) {
        MassageModel massageModel = new MassageModel();
        massageModel.setRCC(massageDTO.getRCC());
        massageModel.setMassage(massageDTO.getMassage());
        return massageRepository.save(massageModel);
    }


}
