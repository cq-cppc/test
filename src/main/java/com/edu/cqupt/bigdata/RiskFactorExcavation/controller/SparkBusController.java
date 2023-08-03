package com.edu.cqupt.bigdata.RiskFactorExcavation.controller;


import com.edu.cqupt.bigdata.RiskFactorExcavation.service.BusService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.spark.BusCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.spark.BusResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/bus")
@CrossOrigin

public class SparkBusController {

    @Resource
    private BusService busService;

    @PostMapping("create")
    public int BusCreate(BusCreateRequest request){
        return busService.createBus(request);
    }

    @PostMapping("query/{id}")
    public BusResponse queryBusById(@PathVariable Integer id){
        return busService.queryById(id);
    }

}
