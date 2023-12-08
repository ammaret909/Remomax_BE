package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.LosLoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LosLoginRepository extends JpaRepository<LosLoginModel,String> {
    long countByUser(String user);
    LosLoginModel findByUserAndCheckLogin(String user,int checkLogin);

    int countByRccStartingWithAndUserAndRactive(String rccDay,String user,String ractive);

    List<LosLoginModel> findAllByRactive(String ractive);
}
