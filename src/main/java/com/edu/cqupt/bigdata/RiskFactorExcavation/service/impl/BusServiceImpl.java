package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.OfflineBusMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Algorithm;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.OfflineBus;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.BusServiceAdapter;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.AlgorithmService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.bus.spark.BusCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.livy.BatchRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.bus.spark.BusResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.spark.TaskResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
@Log4j2
public class BusServiceImpl extends BusServiceAdapter {

    @Resource
    private TaskServiceImpl taskService;

    @Resource
    private AlgorithmService algorithmService;

    @Value("${bus.output.path.base}")
    private String busOutputBasePath;

    @Resource
    private OfflineBusMapper offlineBusMapper;

    @Override
    public Integer createBus(BusCreateRequest request) {
        OfflineBus bus=new OfflineBus();
        BatchRequest batchRequest=new BatchRequest();
        BeanUtils.copyProperties(request,bus);
        Date now=new Date();
        String outputFileName= UUID.randomUUID().toString();
        bus.setTaskCreateTime(new Timestamp(now.getTime()));
        bus.setOutPutFilePath(busOutputBasePath+outputFileName+".json");
        Algorithm algorithm=algorithmService.selectById(bus.getAlgorithmId());
        batchRequest.setFile(algorithm.getDeployFilePath())
                .setArgs(null);
        return offlineBusMapper.insert(bus);
    }

    @Override
    public BusResponse queryById(Integer id) {
        OfflineBus bus=offlineBusMapper.selectById(id);
        TaskResponse taskResponse=taskService.queryByBizId(id).get(0);
        BusResponse busResponse=new BusResponse();
        BeanUtils.copyProperties(bus,busResponse);
        busResponse.setBusState(taskResponse.getTaskState().toString());
        return busResponse;
    }
}
