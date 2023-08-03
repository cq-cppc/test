package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.runtime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class RuntimeTaskRequest {

    private String taskType;
    private Integer bizId;
    private List<String> args=null;
    private String pyPath;


}
