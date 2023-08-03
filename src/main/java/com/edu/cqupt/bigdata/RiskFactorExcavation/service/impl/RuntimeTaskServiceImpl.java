package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.task.TaskType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.RuntimeServiceTaskAdapter;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.runtime.RuntimeTaskRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.runtime.RuntimeTaskResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.util.PythonRun;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class RuntimeTaskServiceImpl extends RuntimeServiceTaskAdapter {

    @Resource
    private PythonRun pythonRun;

    @Resource(name = "dataTableDataSourceProperties")
    private DataSourceProperties dataTableDataSourceProperties;

    @Override
    public RuntimeTaskResponse submitTask(RuntimeTaskRequest request) throws Exception {
        RuntimeTaskResponse taskResponse = new RuntimeTaskResponse();
        BeanUtils.copyProperties(request, taskResponse);
        taskResponse.setTaskStartTime(new Date().getTime());
        System.out.println("接收到的PyPath"+request.getPyPath());
        System.out.println("接收到的Args"+request.getArgs());
        //任务信息入库
        //提交任务
        taskResponse.setTaskFinishTime(new Date().getTime());
        String a1 = pythonRun.run(request.getPyPath(), request.getArgs());
        System.out.println("a1="+a1);
        List<String> res =JSONObject.parseArray(pythonRun.run(request.getPyPath(), request.getArgs()),String.class);
        taskResponse.setRes(res);
        System.out.println("res"+res);
        return taskResponse;
//        try {
//            String result = pythonRun.run(request.getPyPath(), request.getArgs());
//
//            JSONObject jsonResult = JSONObject.parseObject(result);
//            List<String> res = new ArrayList<>();
//            res.add(jsonResult.getString("decision_tree"));
//            res.add(jsonResult.getString("random_forest"));
//            res.add(jsonResult.getString("naive_bayes"));
//            taskResponse.setRes(res);
//        } catch (Exception e) {
//            log.error("提交任务时发生错误: " + e.getMessage());
//            // 处理异常情况
//            // ...
//        }

    }
}
