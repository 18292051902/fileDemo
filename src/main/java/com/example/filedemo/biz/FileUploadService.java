package com.example.filedemo.biz;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author ZJBR
 */
public interface FileUploadService {
    /**
     * 上传文件
     * @param file
     */
    void uploadFile(MultipartFile file);

    /**
     * 上传压缩包
     * @param file
     */
    void uploadZipOrRar(MultipartFile file);
}
