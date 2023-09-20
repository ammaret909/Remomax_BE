package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTO.DecodeRCCDTO;
import com.example.RemomaxBE.DTO.RCCDTO;
import com.example.RemomaxBE.DTOout.TimeRCCDTOout;
import com.example.RemomaxBE.Model.RCCModel;
import com.example.RemomaxBE.Repository.RCCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RCCService {

    @Autowired
    RCCRepository rccRepository;

    public RCCModel createRcc() {

        RCCModel rccModel = new RCCModel();
        LocalDateTime timeDate = LocalDateTime.now();

        String year = Integer.toHexString(timeDate.getYear()).toUpperCase();
        String month = Integer.toHexString(timeDate.getMonthValue());
        String day = encodeDay(timeDate.getDayOfMonth());
        String hour = encodeHour(timeDate.getHour());
        String minute = checkMinute(timeDate.getMinute());
        String second = checkSecond(timeDate.getSecond());
        String preRcc = year + month + day + hour + minute + second;

        RCCModel rccModelCheck = rccRepository.findById(1L).orElse(null);
        if(rccModelCheck == null || !preRcc.equals(rccModelCheck.getCheck_rcc())) {
            rccModel.setId(1L);
            String special = "AA";
            String finalRcc = preRcc + special;
            rccModel.setCheck_rcc(finalRcc);
            rccRepository.save(rccModel);
            return rccModel;
        }
        rccModel.setId(1L);
        String special = CreateSpecial(rccModelCheck.getCheck_rcc());
        String finalRcc = preRcc + special;
        rccModel.setCheck_rcc(finalRcc);
        rccRepository.save(rccModel);
        return rccModel;
    }

    public String encodeDay(int Day){
        int checkDay = Day - 9;
        if(checkDay >= 1){
            StringBuilder result = new StringBuilder();
            while (checkDay > 0) {
                int remainder = (checkDay - 1) % 26;
                char letter = (char) ('A' + remainder);
                result.insert(0, letter);
                checkDay = (checkDay - 1) / 26;
            }
            return String.valueOf(result);
        }
        return String.valueOf(Day);
    }

    public String encodeHour(int hour){
        StringBuilder result = new StringBuilder();
        while (hour > 0) {
            int remainder = (hour - 1) % 26;
            char letter = (char) ('A' + remainder);
            result.insert(0, letter);
            hour = (hour - 1) / 26;
        }
        return String.valueOf(result);
    }

    public String checkMinute(int minute){
        if(minute <= 9){
            String finalMinute = "0" + minute;
            return finalMinute;
        }
        return String.valueOf(minute);
    }

    public String checkSecond(int second){
        if(second <= 9){
            String finalSecond = "0" + second;
            return finalSecond;
        }
        return String.valueOf(second);
    }

    public String CreateSpecial(String checkRcc){

        String specail = checkRcc.substring(10);

        int resultSpecail = 0;
        int base = 1;
        for (int i = specail.length() - 1; i >= 0; i--) {
            char c = specail.charAt(i);
            resultSpecail += (c - 'A' + 1) * base;
            base *= 26;
        }

        StringBuilder result = new StringBuilder();
        int newResultSpecail = resultSpecail + 1;
        while (newResultSpecail > 0) {
            int remainder = (newResultSpecail - 1) % 26;
            char letter = (char) ('A' + remainder);
            result.insert(0, letter);
            newResultSpecail = (newResultSpecail - 1) / 26;
        }
        return result.toString();

    }

    public TimeRCCDTOout decodeRCC(DecodeRCCDTO decodeRCCDTO) {
        String rcc = decodeRCCDTO.getRCC();
        String year = String.valueOf(Integer.parseInt(rcc.substring(0,3),16));
        String month = String.valueOf(decodeMonth(Integer.parseInt(rcc.substring(3,4),16)));
        String day = String.valueOf(decodeDay(rcc.substring(4,5)));
        String hour = String.valueOf(decodeHour(rcc.substring(5,6)));
        String minute = rcc.substring(6,8);
        String second = rcc.substring(8,10);
        String time = day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second;
        TimeRCCDTOout timeRCCDTOout = new TimeRCCDTOout();
        timeRCCDTOout.setTime(time);
        return timeRCCDTOout;
    }

    public String decodeRCCGetString(String rcc) {
        String year = String.valueOf(Integer.parseInt(rcc.substring(0,3),16));
        String month = String.valueOf(decodeMonth(Integer.parseInt(rcc.substring(3,4),16)));
        String day = String.valueOf(decodeDay(rcc.substring(4,5)));
        String hour = String.valueOf(decodeHour(rcc.substring(5,6)));
        String minute = rcc.substring(6,8);
        String second = rcc.substring(8,10);
        String time = day + "/" + month + "/" + year + " " + hour + ":" + minute + ":" + second;
        return time;
    }

    public String decodeMonth(int month){
        if(month <= 9){
            return "0" + month;
        }
        return String.valueOf(month);
    }

    public String decodeDay(String day) {
        if (Character.isLetter(day.charAt(0))) {
            char convertToChar = day.charAt(0) ;
            int number = convertToChar - 'A' + 1;
            int finalNumber = number + 9;
            return String.valueOf(finalNumber);
        } else {
            return "0" + day;
        }
    }

    public String decodeHour(String hour) {
            char convertToChar = hour.charAt(0) ;
            int hourTime = convertToChar - 'A' + 1;
            if(hourTime <= 9) {
                return "0" + hourTime;
            }
            return String.valueOf(hourTime);
    }

}
