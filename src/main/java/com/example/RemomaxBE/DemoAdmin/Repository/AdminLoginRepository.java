package com.example.RemomaxBE.DemoAdmin.Repository;

import com.example.RemomaxBE.DemoAdmin.Model.AdminLoginModel;
import com.example.RemomaxBE.Model.UserMenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLoginRepository extends JpaRepository<AdminLoginModel,String> {
    AdminLoginModel findByUSERIDAndDRAWSSAP(String email, String password);
}
