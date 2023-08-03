package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class TaskMultiCondition {
    private Integer bizId;
//    private String taskType;
    private String taskState;
}
