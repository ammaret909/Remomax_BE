package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel,Long> {
    LoginModel findByUSERID(String USERID);
}
