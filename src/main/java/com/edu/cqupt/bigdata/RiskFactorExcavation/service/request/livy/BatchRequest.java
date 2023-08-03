package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.livy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BatchRequest {
    private String file;//File containing the application to execute
    private String className; // Application Java/Spark main class
    private List<String> args=new ArrayList<>();
    private List<String> jars = new ArrayList<>();
    private Integer numExecutors;
    private Integer executorCores;
    private String executorMemory="4096M";
    private Integer driverCores;
    private Integer driverMemory;
    private Map<String,Object> conf=new HashMap<>();
    //....etc. all of the property show in the docs
}
