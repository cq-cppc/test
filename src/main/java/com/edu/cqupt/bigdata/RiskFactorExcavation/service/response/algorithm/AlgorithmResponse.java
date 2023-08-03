package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.algorithm;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlgorithmResponse {
    private int id;
    private String algorithmName;
    private String algorithmDescription;
    private String taskType;;
}
