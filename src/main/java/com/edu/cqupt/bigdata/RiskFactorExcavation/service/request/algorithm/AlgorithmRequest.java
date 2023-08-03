package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlgorithmRequest {
    private int id;
    private String algorithmDescription;
    private String taskType;
    private String algorithmName;
    private String deployFilePath;
}
