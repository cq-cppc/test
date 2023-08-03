package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Factor {
    private int id;
    private int tableId;
    private int columnId;
    private int score;
    private String icdCode;
    private String FactorDec;

}
