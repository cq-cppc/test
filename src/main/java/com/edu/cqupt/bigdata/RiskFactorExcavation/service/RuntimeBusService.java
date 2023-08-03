package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.runtime.RuntimeBusCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.runtime.RuntimeBusServiceResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.spark.BusResponse;

import java.io.IOException;

public interface RuntimeBusService {

    BusResponse queryById(Integer id) ;


    RuntimeBusServiceResponse submitBus(RuntimeBusCreateRequest request) throws Exception;

    JSONObject queryResult(String taskId);

    Integer offLine(Integer busId);

}
