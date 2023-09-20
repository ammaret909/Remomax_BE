package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTOout.ConvertAspDTOout;
import com.example.RemomaxBE.DTOout.Header1DTOout;
import com.example.RemomaxBE.DTOout.Header2DTOout;
import com.example.RemomaxBE.DTOout.Header3DTOout;
import com.example.RemomaxBE.Service.ConvertAspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class testReadFile {
    @Autowired
    ConvertAspService convertAspService;
    @GetMapping("/asp")
    public ConvertAspDTOout extractLinkValue(@RequestParam("file") MultipartFile file) throws IOException {
        return convertAspService.convertAsp(file);
    }
}
