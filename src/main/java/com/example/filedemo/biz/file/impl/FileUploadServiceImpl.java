package com.example.filedemo.biz.file.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.util.StrUtil;
import com.example.filedemo.biz.file.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import cn.hutool.core.date.DateUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author ZJBR
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    private static String ZIP = ".zip";
    private static String RAR = ".rar";

    @Override
    public void uploadFile(MultipartFile multipartFile) {
        String localPath = "D:/xuexi_test/testFile/";

        if(multipartFile.getSize()>10*1024*1024){
            System.out.print("上传文件不能超过10M");
        }
        String nowDayStr  = DateUtil.format(LocalDateTime.now(), DatePattern.PURE_DATE_PATTERN);
        String savePath = localPath + nowDayStr;
        String fileNameOri = multipartFile.getOriginalFilename();
        String fileName = (int)(Math.random() * 100000) + fileNameOri;
        File file = new File(savePath + StrUtil.SLASH + fileName);
        // 如果该文件的上级文件夹不存在，则创建该文件的上级文件夹及其祖辈级文件夹;
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件的全路径名字(含路径、后缀)>>>>>>>" + savePath + fileName);


      /*  // 先设定一个放置上传文件的文件夹(该文件夹可以不存在，下面会判断创建)
        String deposeFilesDir = "D:\\xuexi_test\\testFile\\";

        // 获取附件原名(有的浏览器如chrome获取到的是最基本的含 后缀的文件名,如myImage.png)
        // 获取附件原名(有的浏览器如ie获取到的是含整个路径的含后缀的文件名，如C:\\Users\\images\\myImage.png)
        String fileName = file.getOriginalFilename();
        // 如果是获取的含有路径的文件名，那么截取掉多余的，只剩下文件名和后缀名
        int index = fileName.lastIndexOf("\\");
        if (index > 0) {
            fileName = fileName.substring(index + 1);
        }
        // 判断单个文件大于1M
        long fileSize = file.getSize();
        if (fileSize > 1024 * 1024) {
            System.out.println("文件大小为(单位字节):" + fileSize);
            System.out.println("该文件大于1M");
        }
        // 当文件有后缀名时
        if (fileName.indexOf(".") >= 0) {
            // split()中放正则表达式; 转义字符"\\."代表 "."
            String[] fileNameSplitArray = fileName.split("\\.");
            // 加上random戳,防止附件重名覆盖原文件
            fileName = fileNameSplitArray[0] + (int) (Math.random() * 100000) + "." + fileNameSplitArray[1];
        }
        // 当文件无后缀名时(如C盘下的hosts文件就没有后缀名)
        if (fileName.indexOf(".") < 0) {
            // 加上random戳,防止附件重名覆盖原文件
            fileName = fileName + (int) (Math.random() * 100000);
        }
        System.out.println("fileName:" + fileName);

        // 根据文件的全路径名字(含路径、后缀),new一个File对象dest
        File dest = new File(deposeFilesDir + fileName);
        // 如果该文件的上级文件夹不存在，则创建该文件的上级文件夹及其祖辈级文件夹;
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 将获取到的附件file,transferTo写入到指定的位置(即:创建dest时，指定的路径)
            file.transferTo(dest);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件的全路径名字(含路径、后缀)>>>>>>>" + deposeFilesDir + fileName);*/
    }

    @Override
    public void uploadZipOrRar(MultipartFile multipartFile) {
        String fileNameOri = multipartFile.getOriginalFilename();
        if(multipartFile.getSize() > 20 * 1024 * 1024){
            System.out.print("上传文件不能超过20M");
        }
        String localPath = "D:/xuexi_test/testFile/";
        String targetFilePath = localPath + "proposal" + StrUtil.SLASH;
        String fileName = fileNameOri.split("\\.")[0];
        File temp = null;
        try {
            //创建临时文件存储压缩包
            temp = File.createTempFile(fileName, ZIP);
            multipartFile.transferTo(temp);
            // 删除之前上传的文件
            boolean isDel = deleteDir(new File(targetFilePath));
            //将压缩包解压到目标路径下
            zipUncompress(temp.getAbsolutePath(), targetFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (del(temp)) {
            System.out.print("zip文件已经删除");
        } else {
            System.out.print("zip文件删除失败");
        }
    }

    private boolean deleteDir(File dir) {
        //递归删除
        if(dir.isDirectory()){
            String[] children = dir.list();
           for(int i = 0; i < children.length; i++){
               boolean isDel = deleteDir( new File(dir,children[i]));
               if(!isDel){
                   return false;
               }
           }
        }
        return dir.delete();
    }

    private boolean del(File file) {
        if (file == null || !file.exists() || file.isDirectory()) {
            return false;
        }
        return file.delete();
    }


    private void zipUncompress(String absolutePath, String targetFilePath) {
        File srcFile = new File(absolutePath);
        //判断文件是否存在
        if(!srcFile.exists()){
            System.out.print("解压文件不存在");
        }
        try {
            //创建压缩文件对象
            ZipFile zipFile = new ZipFile(srcFile, Charset.forName("gbk"));
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()){
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                System.out.print("解压:"+zipEntry);
                if(zipEntry.isDirectory()){
                    srcFile.mkdirs();
                }else {
                    File targetFile = new File(targetFilePath + StrUtil.SLASH + zipEntry.getName());
                    //若该文件的父文件夹不存在，则创建
                    if(!targetFile.getParentFile().exists()){
                        targetFile.getParentFile().mkdirs();
                    }
                    targetFile.createNewFile();
                    // 将压缩文件内容写入到这个文件中
                    InputStream is = zipFile.getInputStream(zipEntry);
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
                    int length;
                    byte[] bytes = new byte[1024];
                    while ((length = is.read(bytes)) != -1){
                        bos.write(bytes,0,length);
                    }
                    bos.close();
                    is.close();
                }
            }
            //不关闭无法删除临时文件temp
            zipFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
