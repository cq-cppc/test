package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.spark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusCreateRequest {
    private String icdCode;
    private Integer algorithmId;
    private String busName;
    private String busDescription;
}
