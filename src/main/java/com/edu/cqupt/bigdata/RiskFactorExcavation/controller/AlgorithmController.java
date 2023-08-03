package com.edu.cqupt.bigdata.RiskFactorExcavation.controller;


import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Algorithm;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.AlgorithmService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.algorithm.AlgorithmRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.algorithm.AlgorithmResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/algorithm")
@CrossOrigin
public class AlgorithmController {

    @Resource
    AlgorithmService algorithmService;

    @PostMapping("upload")
    public int algorithmUpload(@RequestBody AlgorithmRequest algorithminfo){
        return algorithmService.algorithmInsert(algorithminfo);
    }

    @PostMapping("selectById/{algorithmId}")
    public Algorithm algorithmSelectById(@PathVariable int algorithmId){
        return algorithmService.selectById(algorithmId);
    }

    @PostMapping("selectAll")
    public String algorithmSelectAll(){
        return JSONObject.toJSONString(algorithmService.selectAll());
    }

    @PostMapping("/page/{currentPage}/{pageSize}")
    public String algorithmSelectAll(@PathVariable int currentPage,@PathVariable long pageSize){
        return JSONObject.toJSONString(algorithmService.selectAll(currentPage,pageSize));
    }

    /**
     * 该方法未使用不需要写入文档中
     * */
    @PostMapping("selectByname/{algorithmName}")
    public List<AlgorithmResponse> algorithmSelectByName(@PathVariable String algorithmName){
        return algorithmService.queryByAlgorithmName(algorithmName);
    }

    @PostMapping("delete")
    public boolean algorithmDelete(@RequestBody AlgorithmRequest algorithminfo){
        return algorithmService.algorithmDelete(algorithminfo);
    }

}
