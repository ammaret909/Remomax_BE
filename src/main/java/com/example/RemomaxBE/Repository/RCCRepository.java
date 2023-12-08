package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.Model.RCCModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCCRepository extends JpaRepository<RCCModel,Long> {

}
