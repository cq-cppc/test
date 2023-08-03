package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.file.FileType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.file.FileChunkMergeRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.file.FileChunkUploadRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public interface FileService {

    //单文件上传

    String fileUpload(MultipartFile file, boolean isHDFS) throws IOException;

    //文件分片上传
    boolean fileChunkUpload(FileChunkUploadRequest fileChunkUploadRequest) throws IOException;
    //将文件上传至HDFS
    String file2HDFS(File file, FileType type) throws IOException;
    //将文件分片进行合并
    String fileChunkMerge(FileChunkMergeRequest fileChunkMergeRequest) throws Exception;
    //验证文件分片是否存在
    boolean fileChunkExist(String fileHash,String chunkIdx);


    //文件下載
    void downLoadFileFromHDFS(HttpServletResponse response,String filepath) throws Exception;





}
