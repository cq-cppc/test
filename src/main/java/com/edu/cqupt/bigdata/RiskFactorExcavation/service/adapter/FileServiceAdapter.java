package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.file.FileType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.FileService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.file.FileChunkMergeRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.file.FileChunkUploadRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class FileServiceAdapter implements FileService {

    @Override
    public String fileUpload(MultipartFile file, boolean isHDFS) throws IOException {
        return null;
    }

    @Override
    public boolean fileChunkUpload(FileChunkUploadRequest fileChunkUploadRequest) throws IOException {
        return false;
    }

    @Override
    public String file2HDFS(File file, FileType type) throws IOException {
        return null;
    }

    @Override
    public String fileChunkMerge(FileChunkMergeRequest fileChunkMergeRequest) throws Exception {
        return null;
    }

    @Override
    public boolean fileChunkExist(String fileHash, String chunkIdx) {
        return false;
    }

    @Override
    public void downLoadFileFromHDFS(HttpServletResponse response, String filepath) throws Exception {

    }

}
