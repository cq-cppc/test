package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.task.TaskType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.AlgorithmMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.AlgorithmService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.RuntimeTaskService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.TableService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.RuntimeBusServiceAdapter;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.runtime.RuntimeBusCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.runtime.RuntimeTaskRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.runtime.RuntimeBusServiceResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.runtime.RuntimeTaskResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Service
@Log4j2
public class RuntimeBusServiceImpl extends RuntimeBusServiceAdapter {

    @Resource
    private RuntimeTaskService runtimeTaskService;

    @Resource
    private AlgorithmService algorithmService;

    @Resource
    private TableService tableService;

    @Resource(name = "dataTableDataSourceProperties")
    private DataSourceProperties dataTableDataSourceProperties;


    @Override
    public RuntimeBusServiceResponse submitBus(RuntimeBusCreateRequest request) throws Exception {
        System.out.println(request);
        RuntimeBusServiceResponse response=new RuntimeBusServiceResponse();
        BeanUtils.copyProperties(request,response);
        List<String> args=new LinkedList<>();
        //TableResponse tableResponse=tableService.findById(request.getTableId());
        args.add("--symptom1="+request.getSymptom1());
        args.add("--symptom2="+request.getSymptom2());
        args.add("--symptom3="+request.getSymptom3());
        args.add("--symptom4="+request.getSymptom4());
        args.add("--symptom5="+request.getSymptom5());


        RuntimeTaskRequest runtimeTaskRequest=new RuntimeTaskRequest();
       // runtimeTaskRequest.setTaskType(TaskType.runtime.toString());
       // runtimeTaskRequest.setArgs(args);
       // runtimeTaskRequest.setBizId(request.getBusId());
        runtimeTaskRequest.setPyPath("F:/Code/Disease-prediction-using-Machine-Learning-master/test2.py");
        runtimeTaskRequest.setArgs(args);
        System.out.println("Python脚本路径：" + runtimeTaskRequest.getPyPath());

        RuntimeTaskResponse taskResponse=runtimeTaskService.submitTask(runtimeTaskRequest);
       // response.setTaskCreateTime(new Timestamp(taskResponse.getTaskFinishTime()));
        response.setRes(taskResponse.getRes());
        return response;
    }
}
