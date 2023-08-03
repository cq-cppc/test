package com.edu.cqupt.bigdata.RiskFactorExcavation.service;


import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.runtime.RuntimeTaskRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.runtime.RuntimeTaskResponse;

import java.io.IOException;
import java.util.List;

public interface RuntimeTaskService {

    RuntimeTaskResponse submitTask(RuntimeTaskRequest request) throws Exception;
    
    void killTask();

    RuntimeTaskResponse queryById(Integer id);

    List<RuntimeTaskResponse> queryByBizId(Integer bizId);

    List<RuntimeTaskResponse> queryByTaskTypeAndBizIdList(String taskType, Integer bizId);
    
}
