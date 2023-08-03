package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.edu.cqupt.bigdata.RiskFactorExcavation.service.RuntimeTaskService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.runtime.RuntimeTaskRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.runtime.RuntimeTaskResponse;

import java.io.IOException;
import java.util.List;

public class RuntimeServiceTaskAdapter implements RuntimeTaskService {
    @Override
    public RuntimeTaskResponse submitTask(RuntimeTaskRequest request) throws Exception {
        return null;
    }

    @Override
    public void killTask() {

    }

    @Override
    public RuntimeTaskResponse queryById(Integer id) {
        return null;
    }

    @Override
    public List<RuntimeTaskResponse> queryByBizId(Integer bizId) {
        return null;
    }

    @Override
    public List<RuntimeTaskResponse> queryByTaskTypeAndBizIdList(String taskType, Integer bizId) {
        return null;
    }
}
