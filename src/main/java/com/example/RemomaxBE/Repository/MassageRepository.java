package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MassageRepository extends JpaRepository<MassageModel,Long> {
    MassageModel findByID(Long ID);
}
