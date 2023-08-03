package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.spark.BusCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.spark.BusResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.spark.BusUpdateRequest;

public interface BusService {


    BusResponse queryById(Integer id) ;


    Integer createBus(BusCreateRequest request);

//    String executeServing(BusModelServingRequest modelServingRequest);

    JSONObject queryResult(String taskId);

//    List<Object> createStreamTask(Bus bus, Boolean createTask)throws BaseException;

    Integer updateById(BusUpdateRequest request) ;

    Integer updateStateById(Integer busId,String state);

    Integer offLine(Integer busId);

//    PageInfo<BusResponse> queryByPage(BusQueryRequest queryRequest);
}
