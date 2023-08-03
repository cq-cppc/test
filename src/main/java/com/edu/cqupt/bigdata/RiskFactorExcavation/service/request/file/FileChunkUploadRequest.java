package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileChunkUploadRequest {
    private MultipartFile chunk;
    private String fileHash;
    private String chunkIdx;
    private Integer chunkSize;
}
