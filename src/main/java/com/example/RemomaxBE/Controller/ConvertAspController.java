package com.example.RemomaxBE.Controller;

import com.example.RemomaxBE.DTO.CreatePageDTO;
import com.example.RemomaxBE.DTO.SearchPageDTO;
import com.example.RemomaxBE.DTOout.Header1DTOout;
import com.example.RemomaxBE.DTOout.RedirectPageDTOout;
import com.example.RemomaxBE.Model.ConvertAspModel;
import com.example.RemomaxBE.Model.HeaderAllModel;
import com.example.RemomaxBE.Service.ConvertAspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ConvertAspController {
    @Autowired
    ConvertAspService convertAspService;
    @PostMapping("/converts/asp")
    public ConvertAspModel convertsAsp(@RequestParam("file") MultipartFile file) throws IOException {
        return convertAspService.convertAsp(file);
    }
    @PostMapping("/converts/asp/rpl")
    public ConvertAspModel convertAspRPLOleVertion(@RequestParam("file") MultipartFile file) throws IOException {
        return convertAspService.convertAspRPLOleVertion(file);
    }
    @GetMapping("/pages/{pageName}")
    public RedirectPageDTOout showPage(@PathVariable("pageName") String pageName) {
        return convertAspService.showPage(pageName);
    }
    @PostMapping("/edit/page/{rcc}")
    public RedirectPageDTOout EditPage(@PathVariable("rcc") String rcc) {
        return convertAspService.editPage(rcc);
    }

    @PostMapping("/search/page")
    public List<ConvertAspModel> SearchPage(@RequestBody SearchPageDTO searchPageDTO) {
        return convertAspService.searchPage(searchPageDTO);
    }

    @PostMapping("/create/page")
    public ConvertAspModel createPage(@RequestBody CreatePageDTO createPageDTO) {
        return convertAspService.createPage(createPageDTO);
    }

    @PostMapping("/edit/data")
    public void EditData(@RequestBody RedirectPageDTOout redirectPageDTOout) {
        convertAspService.editData(redirectPageDTOout);
    }
}
