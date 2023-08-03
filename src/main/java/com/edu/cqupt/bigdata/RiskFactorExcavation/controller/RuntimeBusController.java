package com.edu.cqupt.bigdata.RiskFactorExcavation.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.RuntimeBusService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.runtime.RuntimeBusCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.runtime.RuntimeBusServiceResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Log4j2
@RestController
@RequestMapping("/runtime_bus")
@CrossOrigin

public class RuntimeBusController {

    @Resource
    private RuntimeBusService runtimeBusService;

    @PostMapping("/submit")
    public RuntimeBusServiceResponse busSubmit(@RequestBody RuntimeBusCreateRequest request) throws Exception {
        log.info("busSubmit："+ JSONObject.toJSONString(request));
        return runtimeBusService.submitBus(request);
    }


}
