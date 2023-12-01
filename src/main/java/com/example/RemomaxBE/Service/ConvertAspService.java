package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTO.CreatePageDTO;
import com.example.RemomaxBE.DTO.RCCRactiveDTO;
import com.example.RemomaxBE.DTO.SearchPageDTO;
import com.example.RemomaxBE.DTOout.*;
import com.example.RemomaxBE.Model.ConvertAspModel;
import com.example.RemomaxBE.Model.HeaderAllModel;
import com.example.RemomaxBE.Model.LosLoginModel;
import com.example.RemomaxBE.Repository.ConvertAspRepository;
import com.example.RemomaxBE.Repository.HeaderAllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class ConvertAspService {
    @Autowired
    ConvertAspRepository convertAspRepository;
    @Autowired
    HeaderAllRepository headerAllRepository;
    @Autowired
    RCCService rccService;

    public ConvertAspModel convertAsp(MultipartFile file) throws IOException {
        ConvertAspModel convertAspModel = new ConvertAspModel();
        int sequence = 0;

        Resource resource = file.getResource();
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        String content = new String(bytes, "tis-620" );

        String H3patternFileName = "<%'\\*\\*\\*\\*\\* LINK3 \\*\\*\\*\\*\\*%>(.*?)\r\n\">";
//        String H3patternFileName = "<%'\\*\\*\\*\\*\\* LINK3 \\*\\*\\*\\*\\*%>(.*?).asp";
        Pattern H3regexFileName = Pattern.compile(H3patternFileName);
        Matcher H3matcherFileName = H3regexFileName.matcher(content);

        String H3patternName = "<%'\\*\\*\\*\\*\\* ITEM3 \\*\\*\\*\\*\\*%>(.*?)\r\n<%";
        Pattern H3regexName = Pattern.compile(H3patternName, Pattern.DOTALL);
        Matcher H3matcherName = H3regexName.matcher(content);

        String H3popu = "<%'\\*\\*\\*\\*\\* POPU3 \\*\\*\\*\\*\\*(.*?)?%>";
        Pattern H3regexPopu = Pattern.compile(H3popu);
        Matcher H3matcherPopu = H3regexPopu.matcher(content);

        String H1patternFileName = "<%'\\*\\*\\*\\*\\* LINK1 \\*\\*\\*\\*\\*%>(.*?)\">";
//        String H1patternFileName = "<%'\\*\\*\\*\\*\\* LINK1 \\*\\*\\*\\*\\*%>(.*?).asp";
        Pattern H1regexFileName = Pattern.compile(H1patternFileName, Pattern.DOTALL);
        Matcher H1matcherFileName = H1regexFileName.matcher(content);

        String H1patternName = "<%'\\*\\*\\*\\*\\* ITEM1 \\*\\*\\*\\*\\*%>(.*?)\r\n<%";
        Pattern H1regexName = Pattern.compile(H1patternName, Pattern.DOTALL);
        Matcher H1matcherName = H1regexName.matcher(content);

        String H1popu = "<%'\\*\\*\\*\\*\\* POPU1 \\*\\*\\*\\*\\*(.*?)?%>";
        Pattern H1regexPopu = Pattern.compile(H1popu);
        Matcher H1matcherPopu = H1regexPopu.matcher(content);

        String H2patternFileName = "<%'\\*\\*\\*\\*\\* LINK2 \\*\\*\\*\\*\\*%>(.*?)\r\n\">";
//        String H2patternFileName = "<%'\\*\\*\\*\\*\\* LINK2 \\*\\*\\*\\*\\*%>(.*?).asp";
        Pattern H2regexFileName = Pattern.compile(H2patternFileName);
        Matcher H2matcherFileName = H2regexFileName.matcher(content);

        String H2patternName = "<%'\\*\\*\\*\\*\\* ITEM2 \\*\\*\\*\\*\\*%>(.*?)\r\n<%";
        Pattern H2regexName = Pattern.compile(H2patternName, Pattern.DOTALL);
        Matcher H2matcherName = H2regexName.matcher(content);

        String H2popu = "<%'\\*\\*\\*\\*\\* POPU2 \\*\\*\\*\\*\\*(.*?)?%>";
        Pattern H2regexPopu = Pattern.compile(H2popu);
        Matcher H2matcherPopu = H2regexPopu.matcher(content);

        String Header3 = "<%'\\*\\*\\*\\*\\* Sub Header3 \\*\\*\\*\\*\\*%>(.*?)\r\n</span>";
        Pattern H3regexHeader = Pattern.compile(Header3, Pattern.DOTALL);
        Matcher H3matcherHeader = H3regexHeader.matcher(content);

        String Header1 = "<%'\\*\\*\\*\\*\\* Sub Header1 \\*\\*\\*\\*\\*%>(.*?)\r\n</p>";
        Pattern H1regexHeader = Pattern.compile(Header1, Pattern.DOTALL);
        Matcher H1matcherHeader = H1regexHeader.matcher(content);

        String Header2 = "<%'\\*\\*\\*\\*\\* Sub Header2 \\*\\*\\*\\*\\*%>(.*?)\r\n</p>";
        Pattern H2regexHeader = Pattern.compile(Header2, Pattern.DOTALL);
        Matcher H2matcherHeader = H2regexHeader.matcher(content);

        String Header = "<%'\\*\\*\\*\\*\\* Header \\*\\*\\*\\*\\*%>(.*?)\r\n</span>";
        Pattern regexHeader = Pattern.compile(Header, Pattern.DOTALL);
        Matcher matcherHeader = regexHeader.matcher(content);

        convertAspModel.setRcc(rccService.createRcc().getCheck_rcc());
        String fileName = file.getOriginalFilename().substring(0,file.getOriginalFilename().length() - 4);
        convertAspModel.setNamePage(fileName);

        if(H3matcherHeader.find()){
            String H3subTitle = H3matcherHeader.group(1);
            convertAspModel.setSubTitleH3(H3subTitle);
        }

        if(H1matcherHeader.find()){
            String H1subTitle = H1matcherHeader.group(1);
            convertAspModel.setSubTitleH1(H1subTitle);
        }

        if(H2matcherHeader.find()){
            String H2subTitle = H2matcherHeader.group(1);
            convertAspModel.setSubTitleH2(H2subTitle);
        }

        if(matcherHeader.find()){
            String Title = matcherHeader.group(1);
            convertAspModel.setTitle(Title);
        }

        convertAspRepository.save(convertAspModel);

        while (H3matcherFileName.find() && H3matcherName.find() && H3matcherPopu.find()) {
            HeaderAllModel headerAllModel = new HeaderAllModel();

            String H3fileName = H3matcherFileName.group(1);
            String H3Name = H3matcherName.group(1);
            String H3Popu = H3matcherPopu.group(1);

            if(H3fileName.length() >= 6) {
                String cutAsp = H3fileName.substring(0,H3fileName.length() - 4);
                String lastTwoCharacters = cutAsp.substring(cutAsp.length() - 2);
                if(lastTwoCharacters.equals(".a")){
                    cutAsp = H3fileName.substring(0,H3fileName.length() - 8);
                }
                headerAllModel.setFile_name(cutAsp);
            }
            else {
                headerAllModel.setFile_name(H3fileName);
            }

            sequence = sequence + 1;

            headerAllModel.setSequence(sequence);
            headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
            headerAllModel.setHeader_name(H3Name);
            headerAllModel.setPopup(H3Popu);
            headerAllModel.setHeaderNumber(3);
            headerAllModel.setConvertAspModel(convertAspRepository.findById(convertAspModel.getRcc()).orElse(null));
            headerAllRepository.save(headerAllModel);
        }

        sequence = 0;
        while (H1matcherFileName.find() && H1matcherName.find() && H1matcherPopu.find()) {
            HeaderAllModel headerAllModel = new HeaderAllModel();

            String H1fileName = H1matcherFileName.group(1);
            String H1Name = H1matcherName.group(1);
            String H1Popu = H1matcherPopu.group(1);

            if(H1fileName.length() >= 6) {
                String cutAsp = H1fileName.substring(0,H1fileName.length() - 6);
                String lastTwoCharacters = cutAsp.substring(cutAsp.length() - 2);
                if(lastTwoCharacters.equals(".a")){
                    cutAsp = H1fileName.substring(0,H1fileName.length() - 8);
                }
                headerAllModel.setFile_name(cutAsp);
            }
            else {
                headerAllModel.setFile_name(H1fileName);
            }

            sequence = sequence + 1;

            headerAllModel.setSequence(sequence);
            headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
            headerAllModel.setHeader_name(H1Name);
            headerAllModel.setPopup(H1Popu);
            headerAllModel.setHeaderNumber(1);
            headerAllModel.setConvertAspModel(convertAspRepository.findById(convertAspModel.getRcc()).orElse(null));
            headerAllRepository.save(headerAllModel);
            System.out.println(headerAllModel.getPopup());
        }

        sequence = 0;
        while (H2matcherFileName.find() && H2matcherName.find() && H2matcherPopu.find()) {
            HeaderAllModel headerAllModel = new HeaderAllModel();

            String H2fileName = H2matcherFileName.group(1);
            String H2Name = H2matcherName.group(1);
            String H2Popu = H2matcherPopu.group(1);

            if(H2fileName.length() >= 6) {
                String cutAsp = H2fileName.substring(0,H2fileName.length() - 4);
                String lastTwoCharacters = cutAsp.substring(cutAsp.length() - 2);
                if(lastTwoCharacters.equals(".a")){
                    cutAsp = H2fileName.substring(0,H2fileName.length() - 8);
                }
                headerAllModel.setFile_name(cutAsp);
            }
            else {
                headerAllModel.setFile_name(H2fileName);
            }
            sequence = sequence + 1;

            headerAllModel.setSequence(sequence);
            headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
            headerAllModel.setHeader_name(H2Name);
            headerAllModel.setPopup(H2Popu);
            headerAllModel.setHeaderNumber(2);
            headerAllModel.setConvertAspModel(convertAspRepository.findById(convertAspModel.getRcc()).orElse(null));
            headerAllRepository.save(headerAllModel);
        }
        return convertAspModel;
    }

    public ConvertAspModel convertAspRPL(MultipartFile file) throws IOException {
        ConvertAspModel convertAspModel = new ConvertAspModel();
        int sequence = 0;

        Resource resource = file.getResource();
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        String content = new String(bytes, "tis-620" );

        String H3patternFileName = "<%'\\*\\*\\*\\*\\* LINK3 \\*\\*\\*\\*\\*%>(.*?)\r\n\">";
//        String H3patternFileName = "<%'\\*\\*\\*\\*\\* LINK3 \\*\\*\\*\\*\\*%>(.*?).asp";
        Pattern H3regexFileName = Pattern.compile(H3patternFileName);
        Matcher H3matcherFileName = H3regexFileName.matcher(content);

        String H3patternName = "<%'\\*\\*\\*\\*\\* ITEM3 \\*\\*\\*\\*\\*%>(.*?)\r\n<%";
        Pattern H3regexName = Pattern.compile(H3patternName, Pattern.DOTALL);
        Matcher H3matcherName = H3regexName.matcher(content);

        String H1patternFileName = "<%'\\*\\*\\*\\*\\* LINK1 \\*\\*\\*\\*\\*%>(.*?)\">";
//        String H1patternFileName = "<%'\\*\\*\\*\\*\\* LINK1 \\*\\*\\*\\*\\*%>(.*?).asp";
        Pattern H1regexFileName = Pattern.compile(H1patternFileName, Pattern.DOTALL);
        Matcher H1matcherFileName = H1regexFileName.matcher(content);

        String H1patternName = "<%'\\*\\*\\*\\*\\* ITEM1 \\*\\*\\*\\*\\*%>(.*?)\r\n<%";
        Pattern H1regexName = Pattern.compile(H1patternName, Pattern.DOTALL);
        Matcher H1matcherName = H1regexName.matcher(content);

        String H2patternFileName = "<%'\\*\\*\\*\\*\\* LINK2 \\*\\*\\*\\*\\*%>(.*?)\r\n\">";
//        String H2patternFileName = "<%'\\*\\*\\*\\*\\* LINK2 \\*\\*\\*\\*\\*%>(.*?).asp";
        Pattern H2regexFileName = Pattern.compile(H2patternFileName);
        Matcher H2matcherFileName = H2regexFileName.matcher(content);

        String H2patternName = "<%'\\*\\*\\*\\*\\* ITEM2 \\*\\*\\*\\*\\*%>(.*?)\r\n<%";
        Pattern H2regexName = Pattern.compile(H2patternName, Pattern.DOTALL);
        Matcher H2matcherName = H2regexName.matcher(content);

        String Header3 = "<%'\\*\\*\\*\\*\\* Sub Header3 \\*\\*\\*\\*\\*%>(.*?)\r\n</span>";
        Pattern H3regexHeader = Pattern.compile(Header3, Pattern.DOTALL);
        Matcher H3matcherHeader = H3regexHeader.matcher(content);

        String Header1 = "<%'\\*\\*\\*\\*\\* Sub Header1 \\*\\*\\*\\*\\*%>(.*?)\r\n</p>";
        Pattern H1regexHeader = Pattern.compile(Header1, Pattern.DOTALL);
        Matcher H1matcherHeader = H1regexHeader.matcher(content);

        String Header2 = "<%'\\*\\*\\*\\*\\* Sub Header2 \\*\\*\\*\\*\\*%>(.*?)\r\n</p>";
        Pattern H2regexHeader = Pattern.compile(Header2, Pattern.DOTALL);
        Matcher H2matcherHeader = H2regexHeader.matcher(content);

        String Header = "<%'\\*\\*\\*\\*\\* Header \\*\\*\\*\\*\\*%>(.*?)\r\n</span>";
        Pattern regexHeader = Pattern.compile(Header, Pattern.DOTALL);
        Matcher matcherHeader = regexHeader.matcher(content);

        convertAspModel.setRcc(rccService.createRcc().getCheck_rcc());
        String fileName = file.getOriginalFilename().substring(0,file.getOriginalFilename().length() - 4);
        convertAspModel.setNamePage(fileName);

        if(H3matcherHeader.find()){
            String H3subTitle = H3matcherHeader.group(1);
            convertAspModel.setSubTitleH3(H3subTitle);
        }

        if(H1matcherHeader.find()){
            String H1subTitle = H1matcherHeader.group(1);
            convertAspModel.setSubTitleH1(H1subTitle);
        }

        if(H2matcherHeader.find()){
            String H2subTitle = H2matcherHeader.group(1);
            convertAspModel.setSubTitleH2(H2subTitle);
        }

        if(matcherHeader.find()){
            String Title = matcherHeader.group(1);
            convertAspModel.setTitle(Title);
        }

        convertAspRepository.save(convertAspModel);

        while (H3matcherFileName.find() && H3matcherName.find()) {
            HeaderAllModel headerAllModel = new HeaderAllModel();

            String H3fileName = H3matcherFileName.group(1);
            String H3Name = H3matcherName.group(1);


            if(H3fileName.length() >= 6) {
                String cutAsp = H3fileName.substring(0,H3fileName.length() - 4);
                String lastTwoCharacters = cutAsp.substring(cutAsp.length() - 2);
                if(lastTwoCharacters.equals(".a")){
                    cutAsp = H3fileName.substring(0,H3fileName.length() - 8);
                }
                headerAllModel.setFile_name(cutAsp);
            }
            else {
                headerAllModel.setFile_name(H3fileName);
            }

            sequence = sequence + 1;

            headerAllModel.setSequence(sequence);
            headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
            headerAllModel.setHeader_name(H3Name);
            headerAllModel.setPopup("");
            headerAllModel.setHeaderNumber(3);
            headerAllModel.setConvertAspModel(convertAspRepository.findById(convertAspModel.getRcc()).orElse(null));
            headerAllRepository.save(headerAllModel);
        }

        sequence = 0;
        while (H1matcherFileName.find() && H1matcherName.find()) {
            HeaderAllModel headerAllModel = new HeaderAllModel();

            String H1fileName = H1matcherFileName.group(1);
            String H1Name = H1matcherName.group(1);

            if(H1fileName.length() >= 6) {
                String cutAsp = H1fileName.substring(0,H1fileName.length() - 6);
                String lastTwoCharacters = cutAsp.substring(cutAsp.length() - 2);
                if(lastTwoCharacters.equals(".a")){
                    cutAsp = H1fileName.substring(0,H1fileName.length() - 8);
                }
                headerAllModel.setFile_name(cutAsp);
            }
            else {
                headerAllModel.setFile_name(H1fileName);
            }

            sequence = sequence + 1;

            headerAllModel.setSequence(sequence);
            headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
            headerAllModel.setHeader_name(H1Name);
            headerAllModel.setPopup("");
            headerAllModel.setHeaderNumber(1);
            headerAllModel.setConvertAspModel(convertAspRepository.findById(convertAspModel.getRcc()).orElse(null));
            headerAllRepository.save(headerAllModel);
            System.out.println(headerAllModel.getPopup());
        }

        sequence = 0;
        while (H2matcherFileName.find() && H2matcherName.find() ) {
            HeaderAllModel headerAllModel = new HeaderAllModel();

            String H2fileName = H2matcherFileName.group(1);
            String H2Name = H2matcherName.group(1);

            if(H2fileName.length() >= 6) {
                String cutAsp = H2fileName.substring(0,H2fileName.length() - 4);
                String lastTwoCharacters = cutAsp.substring(cutAsp.length() - 2);
                if(lastTwoCharacters.equals(".a")){
                    cutAsp = H2fileName.substring(0,H2fileName.length() - 8);
                }
                headerAllModel.setFile_name(cutAsp);
            }
            else {
                headerAllModel.setFile_name(H2fileName);
            }
            sequence = sequence + 1;

            headerAllModel.setSequence(sequence);
            headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
            headerAllModel.setHeader_name(H2Name);
            headerAllModel.setPopup("");
            headerAllModel.setHeaderNumber(2);
            headerAllModel.setConvertAspModel(convertAspRepository.findById(convertAspModel.getRcc()).orElse(null));
            headerAllRepository.save(headerAllModel);
        }
        return convertAspModel;
    }

    public RedirectPageDTOout showPage(String pageName) {
        RedirectPageDTOout convertAspDTOout = new RedirectPageDTOout();
        ConvertAspModel page = convertAspRepository.findByNamePage(pageName);

        convertAspDTOout.setRcc(page.getRcc());
        convertAspDTOout.setNamePage(page.getNamePage());
        convertAspDTOout.setTitle(page.getTitle());
        convertAspDTOout.setSubTitleH1(page.getSubTitleH1());
        convertAspDTOout.setSubTitleH2(page.getSubTitleH2());
        convertAspDTOout.setSubTitleH3(page.getSubTitleH3());
        convertAspDTOout.setHeader1DTOoutList(headerAllRepository.findHeader(page.getRcc(),1));
        convertAspDTOout.setHeader2DTOoutList(headerAllRepository.findHeader(page.getRcc(),2));
        convertAspDTOout.setHeader3DTOoutList(headerAllRepository.findHeader(page.getRcc(),3));

        return convertAspDTOout;
    }



    public RedirectPageDTOout editPage(String rcc){
        RedirectPageDTOout redirectPageDTOout = new RedirectPageDTOout();
        ConvertAspModel convertAspModel = convertAspRepository.findById(rcc).orElse(null);
        redirectPageDTOout.setRcc(convertAspModel.getRcc());
        redirectPageDTOout.setTitle(convertAspModel.getTitle());
        redirectPageDTOout.setSubTitleH1(convertAspModel.getSubTitleH1());
        redirectPageDTOout.setSubTitleH2(convertAspModel.getSubTitleH2());
        redirectPageDTOout.setSubTitleH3(convertAspModel.getSubTitleH3());
        redirectPageDTOout.setHeader1DTOoutList(headerAllRepository.findHeader(convertAspModel.getRcc(),1));
        redirectPageDTOout.setHeader2DTOoutList(headerAllRepository.findHeader(convertAspModel.getRcc(),2));
        redirectPageDTOout.setHeader3DTOoutList(headerAllRepository.findHeader(convertAspModel.getRcc(),3));
        redirectPageDTOout.setNamePage(convertAspModel.getNamePage());

        return redirectPageDTOout;
    }

    public List<ConvertAspModel> searchPage(SearchPageDTO searchPageDTO) {
        List<ConvertAspModel> convertAspModels = convertAspRepository.findAllByNamePage(searchPageDTO.getNamePage());
        return convertAspModels;
    }

    public void editData(RedirectPageDTOout redirectPageDTOout) {
        //page
        ConvertAspModel convertAspModel = convertAspRepository.findById(redirectPageDTOout.getRcc()).orElse(null);
        convertAspModel.setNamePage(redirectPageDTOout.getNamePage());
        convertAspModel.setTitle(redirectPageDTOout.getTitle());
        convertAspRepository.save(convertAspModel);

        //header
        List<HeaderAllModel> headerAllModels = headerAllRepository.findH1(redirectPageDTOout.getRcc());
        for(HeaderAllModel dto : headerAllModels){
            headerAllRepository.deleteById((dto.getRcc()));
        }
        int sequence = 0;
        for (HeaderAllModel dto : redirectPageDTOout.getHeader1DTOoutList()){
            if(dto.getFile_name() == null && dto.getHeader_name() == null && dto.getRcc() != ""){

            }
            else if(dto.getFile_name() != "" && dto.getHeader_name() != "" && dto.getRcc() != ""){
                HeaderAllModel headerAllModel = new HeaderAllModel();
                headerAllModel.setRcc(dto.getRcc());
                headerAllModel.setHeaderNumber(1);
                headerAllModel.setFile_name(dto.getFile_name());
                headerAllModel.setHeader_name(dto.getHeader_name());
                headerAllModel.setPopup(dto.getPopup());
                headerAllModel.setSequence(sequence = sequence + 1);
                headerAllModel.setConvertAspModel(dto.getConvertAspModel());
                headerAllRepository.save(headerAllModel);
            }
            // if(dto.getFile_name() != "" && dto.getHeader_name() != "" && dto.getRcc() == null)
            else {
                HeaderAllModel headerAllModel = new HeaderAllModel();
                headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
                headerAllModel.setHeaderNumber(1);
                headerAllModel.setFile_name(dto.getFile_name());
                headerAllModel.setHeader_name(dto.getHeader_name());
                headerAllModel.setPopup(dto.getPopup());
                headerAllModel.setSequence(sequence = sequence + 1);
                headerAllModel.setConvertAspModel(convertAspModel);
                headerAllRepository.save(headerAllModel);
            }
        }

        sequence = 0;
        for (HeaderAllModel dto : redirectPageDTOout.getHeader2DTOoutList()){
            if(dto.getFile_name() == null && dto.getHeader_name() == null && dto.getRcc() != ""){
                System.out.println("null");
            }
            else if(dto.getFile_name() != "" && dto.getHeader_name() != "" && dto.getRcc() != ""){
                HeaderAllModel headerAllModel = new HeaderAllModel();
                headerAllModel.setRcc(dto.getRcc());
                headerAllModel.setHeaderNumber(2);
                headerAllModel.setFile_name(dto.getFile_name());
                headerAllModel.setHeader_name(dto.getHeader_name());
                headerAllModel.setPopup(dto.getPopup());
                headerAllModel.setSequence(sequence = sequence + 1);
                headerAllModel.setConvertAspModel(dto.getConvertAspModel());
                headerAllRepository.save(headerAllModel);
            }
            //if(dto.getFile_name() != "" && dto.getHeader_name() != "" && dto.getRcc() == null)
            else  {
                HeaderAllModel headerAllModel = new HeaderAllModel();
                headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
                headerAllModel.setHeaderNumber(2);
                headerAllModel.setFile_name(dto.getFile_name());
                headerAllModel.setHeader_name(dto.getHeader_name());
                headerAllModel.setPopup(dto.getPopup());
                headerAllModel.setSequence(sequence = sequence + 1);
                headerAllModel.setConvertAspModel(convertAspModel);
                headerAllRepository.save(headerAllModel);
            }
        }

        sequence = 0;
        for (HeaderAllModel dto : redirectPageDTOout.getHeader3DTOoutList()){
            if(dto.getFile_name() == null && dto.getHeader_name() == null && dto.getRcc() != ""){
                System.out.println("null");
            }
            else if(dto.getFile_name() != "" && dto.getHeader_name() != "" && dto.getRcc() != ""){
                HeaderAllModel headerAllModel = new HeaderAllModel();
                headerAllModel.setRcc(dto.getRcc());
                headerAllModel.setHeaderNumber(3);
                headerAllModel.setFile_name(dto.getFile_name());
                headerAllModel.setHeader_name(dto.getHeader_name());
                headerAllModel.setPopup(dto.getPopup());
                headerAllModel.setSequence(sequence = sequence + 1);
                headerAllModel.setConvertAspModel(dto.getConvertAspModel());
                headerAllRepository.save(headerAllModel);
            }
            //if(dto.getFile_name() != "" && dto.getHeader_name() != "" && dto.getRcc() == null)
            else  {
                HeaderAllModel headerAllModel = new HeaderAllModel();
                headerAllModel.setRcc(rccService.createRcc().getCheck_rcc());
                headerAllModel.setHeaderNumber(3);
                headerAllModel.setFile_name(dto.getFile_name());
                headerAllModel.setHeader_name(dto.getHeader_name());
                headerAllModel.setPopup(dto.getPopup());
                headerAllModel.setSequence(sequence = sequence + 1);
                headerAllModel.setConvertAspModel(convertAspModel);
                headerAllRepository.save(headerAllModel);
            }
        }

    }

    public ConvertAspModel createPage(CreatePageDTO createPageDTO) {
        ConvertAspModel convertAspModel = new ConvertAspModel();
        convertAspModel.setRcc(rccService.createRcc().getCheck_rcc());
        convertAspModel.setTitle(createPageDTO.getTitle());
        convertAspModel.setNamePage(createPageDTO.getNamePage());
        convertAspModel.setSubTitleH1("");
        convertAspModel.setSubTitleH2("");
        convertAspModel.setSubTitleH3("");
        return convertAspRepository.save(convertAspModel);
    }
}
