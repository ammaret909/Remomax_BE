package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.ConvertAspModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConvertAspRepository extends JpaRepository<ConvertAspModel,String> {
    ConvertAspModel findByNamePage(String pageName);

    List<ConvertAspModel> findAllByNamePage(String namePage);
}
