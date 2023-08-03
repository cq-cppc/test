package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)

public class Disease {
    private String icdCode;
    private String diseaseName;
    private String diseaseDescription;
}
