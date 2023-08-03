package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.spark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusUpdateRequest {
    private Integer busId;
    private String busName;
    private Integer algorithmId;
}
