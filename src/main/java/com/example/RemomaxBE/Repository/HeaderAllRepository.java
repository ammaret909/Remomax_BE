package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.HeaderAllModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderAllRepository extends JpaRepository<HeaderAllModel,String> {

}
