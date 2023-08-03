package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.file.FileType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.FileServiceAdapter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Service
@Log4j2
public class FileServiceImpl extends FileServiceAdapter {

    @Value("${file.upload.save_path}")
    private String fileUploadSavePath;
    @Value("${data.save.path.base}")
    private String dataSavePathBase;
    @Value("${algorithm.save.path.base}")
    private String algorithmSavePathBase;
    @Value("${hdfs.uri}")
    private String hdfsUri;

    /**
     * 文件上传功能，入参为MultipartFile，以及一个指示是否将文件存入HDFS的标志的布尔值，返回值为存入地址的字符串
     * */
    @Override
    public String fileUpload(MultipartFile file, boolean isHDFS) throws IOException {
        InputStream inputStream=file.getInputStream();
        String originalFilename=file.getOriginalFilename();
        String fileSuffix=originalFilename.substring(originalFilename.lastIndexOf('.')+1);
        FileType fileType=FileType.verify(fileSuffix);
        StringBuffer buffer=new StringBuffer(fileUploadSavePath);
        buffer.append(UUID.randomUUID().toString())
                .append('/');
        File dir=new File(buffer.toString());
        dir.mkdir();
        File file_out=new File(buffer.toString(),originalFilename);
        OutputStream outputStream=new FileOutputStream(file_out);
        IOUtils.copy(inputStream,outputStream);
        outputStream.close();
        inputStream.close();
        if (isHDFS) return getHdfsPath(file_out,fileType);
        else return file_out.getCanonicalPath();
    }

    public String getHdfsPath(File file,FileType fileType) {
        StringBuffer buffer=new StringBuffer();
        switch (fileType){
            case csv:
                buffer.append(dataSavePathBase)
                        .append(UUID.randomUUID().toString())
                        .append(file.getName());
                return buffer.toString();
            case jar:
                buffer.append(algorithmSavePathBase)
                        .append(UUID.randomUUID().toString())
                        .append(file.getName());
                return buffer.toString();
            default:
                buffer.append(hdfsUri)
                        .append(fileUploadSavePath)
                        .append(file.getName());
                return buffer.toString();
        }
    }



}
