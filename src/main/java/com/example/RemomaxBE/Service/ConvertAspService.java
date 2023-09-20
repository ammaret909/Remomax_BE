package com.example.RemomaxBE.Service;

import com.example.RemomaxBE.DTOout.ConvertAspDTOout;
import com.example.RemomaxBE.DTOout.Header1DTOout;
import com.example.RemomaxBE.DTOout.Header2DTOout;
import com.example.RemomaxBE.DTOout.Header3DTOout;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class ConvertAspService {

    public ConvertAspDTOout convertAsp(MultipartFile file) throws IOException {
        ConvertAspDTOout convertAspDTOout = new ConvertAspDTOout();
        List<Header3DTOout> header3DTOoutList = new ArrayList<>();
        List<Header1DTOout> header1DTOoutList = new ArrayList<>();
        List<Header2DTOout> header2DTOoutList = new ArrayList<>();

        Resource resource = file.getResource();
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        String content = new String(bytes, "tis-620" );

        String H3patternFileName = "<%'\\*\\*\\*\\*\\* LINK3 \\*\\*\\*\\*\\*%>(.*?)\r\n\">";
        Pattern H3regexFileName = Pattern.compile(H3patternFileName);
        Matcher H3matcherFileName = H3regexFileName.matcher(content);

        String H3patternName = "<%'\\*\\*\\*\\*\\* ITEM3 \\*\\*\\*\\*\\*%>(.*?)\r\n<%";
        Pattern H3regexName = Pattern.compile(H3patternName, Pattern.DOTALL);
        Matcher H3matcherName = H3regexName.matcher(content);

        String H3popu = "<%'\\*\\*\\*\\*\\* POPU3 \\*\\*\\*\\*\\*(.*?)?%>";
        Pattern H3regexPopu = Pattern.compile(H3popu);
        Matcher H3matcherPopu = H3regexPopu.matcher(content);

        String H1patternFileName = "<%'\\*\\*\\*\\*\\* LINK1 \\*\\*\\*\\*\\*%>(.*?)\r\n\">";
        Pattern H1regexFileName = Pattern.compile(H1patternFileName);
        Matcher H1matcherFileName = H1regexFileName.matcher(content);

        String H1patternName = "<%'\\*\\*\\*\\*\\* ITEM1 \\*\\*\\*\\*\\*%>(.*?)\r\n<%";
        Pattern H1regexName = Pattern.compile(H1patternName, Pattern.DOTALL);
        Matcher H1matcherName = H1regexName.matcher(content);

        String H1popu = "<%'\\*\\*\\*\\*\\* POPU1 \\*\\*\\*\\*\\*(.*?)?%>";
        Pattern H1regexPopu = Pattern.compile(H1popu);
        Matcher H1matcherPopu = H1regexPopu.matcher(content);

        String H2patternFileName = "<%'\\*\\*\\*\\*\\* LINK2 \\*\\*\\*\\*\\*%>(.*?)\r\n\">";
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

        while (H3matcherFileName.find() && H3matcherName.find() && H3matcherPopu.find()) {
            Header3DTOout header3DTOout = new Header3DTOout();

            String H3fileName = H3matcherFileName.group(1);
            String H3Name = H3matcherName.group(1);
            String H3Popu = H3matcherPopu.group(1);

            if(H3fileName.length() >= 4) {
                String lastThreeCharacters = H3fileName.substring(0,H3fileName.length() - 4);
                header3DTOout.setFile(lastThreeCharacters);
            }
            else {
                header3DTOout.setFile(H3fileName);
            }

            header3DTOout.setName(H3Name);
            header3DTOout.setPopup(H3Popu);
            header3DTOoutList.add(header3DTOout);
        }


        while (H1matcherFileName.find() && H1matcherName.find() && H1matcherPopu.find()) {
            Header1DTOout header1DTOout = new Header1DTOout();

            String H1fileName = H1matcherFileName.group(1);
            String H1Name = H1matcherName.group(1);
            String H1Popu = H1matcherPopu.group(1);

            if(H1fileName.length() >= 4) {
                String lastThreeCharacters = H1fileName.substring(0,H1fileName.length() - 4);
                header1DTOout.setFile(lastThreeCharacters);
            }
            else {
                header1DTOout.setFile(H1fileName);
            }

            header1DTOout.setName(H1Name);
            header1DTOout.setPopup(H1Popu);
            header1DTOoutList.add(header1DTOout);
        }

        while (H2matcherFileName.find() && H2matcherName.find() && H2matcherPopu.find()) {
            Header2DTOout header2DTOout = new Header2DTOout();

            String H2fileName = H2matcherFileName.group(1);
            String H2Name = H2matcherName.group(1);
            String H2Popu = H2matcherPopu.group(1);

            if(H2fileName.length() >= 4) {
                String lastThreeCharacters = H2fileName.substring(0,H2fileName.length() - 4);
                header2DTOout.setFile(lastThreeCharacters);
            }
            else {
                header2DTOout.setFile(H2fileName);
            }

            header2DTOout.setName(H2Name);
            header2DTOout.setPopup(H2Popu);
            header2DTOoutList.add(header2DTOout);
        }

        if(H3matcherHeader.find()){
            String H3subTitle = H3matcherHeader.group(1);
            convertAspDTOout.setSubTitleH3(H3subTitle);
        }

        if(H1matcherHeader.find()){
            String H1subTitle = H1matcherHeader.group(1);
            convertAspDTOout.setSubTitleH1(H1subTitle);
        }

        if(H2matcherHeader.find()){
            String H2subTitle = H2matcherHeader.group(1);
            convertAspDTOout.setSubTitleH2(H2subTitle);
        }

        if(matcherHeader.find()){
            String Title = matcherHeader.group(1);
            convertAspDTOout.setTitle(Title);
        }

        convertAspDTOout.setHeader1(header1DTOoutList);
        convertAspDTOout.setHeader2(header2DTOoutList);
        convertAspDTOout.setHeader3(header3DTOoutList);

        return convertAspDTOout;
    }
}
