package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.LosLoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LosLoginRepository extends JpaRepository<LosLoginModel,Long> {
    long countByUser(String user);
}
