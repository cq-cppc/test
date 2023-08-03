package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.livy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchStateResponse {
    private Integer id;
    private String state;
}
