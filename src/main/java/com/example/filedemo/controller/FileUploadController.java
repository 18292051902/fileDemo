package com.example.filedemo.controller;

import cn.hutool.core.util.StrUtil;
import com.example.filedemo.biz.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author ZJBR
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    private static String ZIP = "zip";
    private static String RAR = "rar";


    /**
     * 上传单个文件
     * @param file
     */
    @PostMapping("/uploadFile")
    public void fileUpload(@RequestParam("fileName") MultipartFile file) {
        // 判断文件手否有内容
        if (file.isEmpty()) {
            System.out.println("该文件无任何内容!!!");
        }
        String fileName = file.getOriginalFilename();
        String suffix = fileName.split("\\.")[1].toLowerCase();
        if(ZIP.equals(suffix) || RAR.equals(suffix)){
            fileUploadService.uploadZipOrRar(file);
        }else {
            fileUploadService.uploadFile(file);
        }
    }

    /**
     * 上传多个文件
     * @param files
     */
    @PostMapping("/uploadFiles")
    public void uploadFiles(@RequestParam("fileName") MultipartFile[] files){
        for(MultipartFile file : files){
            if(file.isEmpty()){
                System.out.println("该文件无任何内容!!!");
            }
            fileUploadService.uploadFile(file);
        }
    }


}
