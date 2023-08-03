package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.spark;


import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.livy.BatchRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskCreateRequest {
    private String taskType;
    private Integer bizId;
    private String extraParams;
    private BatchRequest batchRequest=new BatchRequest();
}
