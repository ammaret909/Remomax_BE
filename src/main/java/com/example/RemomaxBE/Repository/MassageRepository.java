package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.MassageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MassageRepository extends JpaRepository<MassageModel,String> {
    MassageModel findByID(String ID);
    List<MassageModel> findAllByID(String search);
    @Query(value = "SELECT count(rcc) FROM alert_massage",nativeQuery = true)
    Long countAlertMassage();
}
