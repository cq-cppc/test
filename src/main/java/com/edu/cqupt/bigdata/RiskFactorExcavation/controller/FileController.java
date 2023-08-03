package com.edu.cqupt.bigdata.RiskFactorExcavation.controller;

import com.edu.cqupt.bigdata.RiskFactorExcavation.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/file")
@CrossOrigin

public class FileController {

    @Resource
    FileService fileService;

    @PostMapping("fileUpload/{isHDFS}")
    public String fileUpload(MultipartFile file,@PathVariable boolean isHDFS) throws IOException {
        return fileService.fileUpload(file,isHDFS);
    }

}
