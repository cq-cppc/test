package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.RuntimeBusService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.runtime.RuntimeBusCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.runtime.RuntimeBusServiceResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.spark.BusResponse;

import java.io.IOException;

public class RuntimeBusServiceAdapter implements RuntimeBusService {
    @Override
    public BusResponse queryById(Integer id) {
        return null;
    }

    @Override
    public RuntimeBusServiceResponse submitBus(RuntimeBusCreateRequest request) throws Exception {
        return null;
    }

    @Override
    public JSONObject queryResult(String taskId) {
        return null;
    }

    @Override
    public Integer offLine(Integer busId) {
        return null;
    }
}
