package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.HeaderAllModel;
import com.example.RemomaxBE.Model.LoginModel;
import com.example.RemomaxBE.Model.UserMenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMenuRepository extends JpaRepository<UserMenuModel,String> {
    @Query(value = "SELECT * FROM user_menu WHERE urcc = :urcc",nativeQuery = true)
    List<UserMenuModel> findAllMenuByUrcc(String urcc);

}

