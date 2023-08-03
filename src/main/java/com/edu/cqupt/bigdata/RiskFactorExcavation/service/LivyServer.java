package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.livy.BatchLogResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.livy.BatchRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.livy.BatchResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.livy.BatchStateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${livy.url}", name = "livy")
public interface LivyServer {
    @RequestMapping(
            name = "提交至livy",
            value = "/batches",
            method = RequestMethod.POST,
            headers = {
                    "X-Requested-By=admin",
                    "Content-Type=application/json"
            }
    )
    BatchResponse submit(BatchRequest request);

    @RequestMapping(
            name = "根据ID查询任务信息",
            value = "/batches/{id}",
            method = RequestMethod.GET,
            headers = {
                    "X-Requested-By=admin",
                    "Content-Type=application/json"
            }
    )
    BatchResponse queryById(@PathVariable("id") Integer id);

    @RequestMapping(
            name = "根据ID查询任务状态",
            value = "/batches/{id}/state",
            method = RequestMethod.GET,
            headers = {
                    "X-Requested-By=admin",
                    "Content-Type=application/json"
            }
    )
    BatchStateResponse queryStateById(@PathVariable("id") Integer id);

    @RequestMapping(
            name = "Kill Task By Id",
            value = "/batches/{id}",
            method = RequestMethod.DELETE,
            headers = {
                    "X-Requested-By=admin",
                    "Content-Type=application/json"
            }
    )
    JSONObject killTaskById(@PathVariable("id") Integer id);

    @RequestMapping(
            name = "get task log",
            value = "/batches/{id}/log",
            method = RequestMethod.GET,
            headers = {
                    "X-Requested-By=admin",
                    "Content-Type=application/json"
            }
    )
    BatchLogResponse queryLogById(@PathVariable("id") Integer id);
}
