package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel,String> {
    LoginModel findByUSERID(String USERID);
    LoginModel findByRCC(String RCC);

    List<LoginModel> findAllByRactive(String ractive);
}
