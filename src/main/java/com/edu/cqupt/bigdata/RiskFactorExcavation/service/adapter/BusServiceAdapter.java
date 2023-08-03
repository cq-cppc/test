package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.BusService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.spark.BusCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.spark.BusResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.spark.BusUpdateRequest;


public class BusServiceAdapter implements BusService {
    @Override
    public BusResponse queryById(Integer id) {
        return null;
    }

    @Override
    public Integer createBus(BusCreateRequest request) {
        return null;
    }

    @Override
    public JSONObject queryResult(String taskId) {
        return null;
    }

    @Override
    public Integer updateById(BusUpdateRequest request) {
        return null;
    }

    @Override
    public Integer updateStateById(Integer busId, String state) {
        return null;
    }

    @Override
    public Integer offLine(Integer busId) {
        return null;
    }
}
