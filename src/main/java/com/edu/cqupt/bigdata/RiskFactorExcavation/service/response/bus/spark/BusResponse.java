package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.spark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusResponse {
    private Integer busId;
    private String busName;
    private String busDescription;
    private String busState;
    private Timestamp taskCreateTime;
    private String icdCode;
    private int algorithmId;
    private String outputFilePath;
}
