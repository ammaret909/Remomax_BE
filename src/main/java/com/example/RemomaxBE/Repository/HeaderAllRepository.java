package com.example.RemomaxBE.Repository;

import com.example.RemomaxBE.DTOout.Header1DTOout;
import com.example.RemomaxBE.Model.HeaderAllModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaderAllRepository extends JpaRepository<HeaderAllModel,String> {
    @Query(value = "SELECT * FROM header_all WHERE page_rcc = :rcc AND header_number = :headerNumber",nativeQuery = true)
    List<HeaderAllModel> findHeader(String rcc,int headerNumber);

    @Query(value = "SELECT * FROM header_all WHERE page_rcc = :rcc",nativeQuery = true)
    List<HeaderAllModel> findH1(String rcc);
    @Query(value = "DELETE FROM header_all WHERE page_rcc = :rcch1",nativeQuery = true)
    void deleteHeaderByRccPage(String rcch1);

//    List<HeaderAllModel> findByRccAndHeaderNumber(String rcc,int headerNumber);
}
