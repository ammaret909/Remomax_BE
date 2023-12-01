package com.example.RemomaxBE.Repository;


import com.example.RemomaxBE.Model.ReceiveLoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiveLoginRepository extends JpaRepository<ReceiveLoginModel,String> {

    @Query(value = "SELECT  * FROM ulogio WHERE rccu = :rcc AND in_or_out = '0'  order by rcc desc limit 1",nativeQuery = true)
    ReceiveLoginModel findFirstLogin(String rcc);
    @Query(value = "SELECT  * FROM ulogio WHERE rccu = :rcc AND in_or_out = '1'  order by rcc desc limit 1",nativeQuery = true)
    ReceiveLoginModel findFirstLogout(String rcc);
    @Query(value = "SELECT count(rcc) as rcc1 FROM ulogio WHERE rccu = :rcc AND in_or_out = '0'  group by rccu",nativeQuery = true)
    String findCountLogin(String rcc);
    @Query(value = "SELECT count(rcc) as rcc1 FROM ulogio WHERE rccu = :rcc AND in_or_out = '1'  group by rccu",nativeQuery = true)
    String findCountLogout(String rcc);

    @Query(value = "SELECT  * FROM ulogio WHERE rccu = :rcc AND in_or_out = '0' AND rcc < (SELECT MAX(rcc) FROM ulogio WHERE rccu = :rcc AND in_or_out = '0' AND ip = :ip) order by rcc desc limit 1",nativeQuery = true)
    ReceiveLoginModel findLoginByLogout(String rcc,String ip);
//    @Query(value = "SELECT  * FROM ulogio WHERE rccu = :rcc AND in_or_out = '1' AND rcc < (SELECT MAX(rcc) FROM ulogio WHERE rccu = :rcc AND in_or_out = '0') order by rcc desc limit 1",nativeQuery = true)
//    ReceiveLoginModel findSecondLogout(String rcc);
}
