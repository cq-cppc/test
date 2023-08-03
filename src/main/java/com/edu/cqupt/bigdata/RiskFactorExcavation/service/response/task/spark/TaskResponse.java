package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.spark;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.livy.SessionState;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.livy.BatchResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskResponse {
    private Integer taskId;
    private SessionState taskState;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Long taskStartTime;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Long taskFinishTime;
    private JSONObject args;
    private String taskType;
    private Integer bizId;
    private String extraParams;
    private BatchResponse batchResponse;
}
