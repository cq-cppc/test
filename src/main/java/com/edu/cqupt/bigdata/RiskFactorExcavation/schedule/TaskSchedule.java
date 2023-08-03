package com.edu.cqupt.bigdata.RiskFactorExcavation.schedule;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.livy.SessionState;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.BusService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.TaskService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.spark.TaskResponse;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Resource;
import java.util.List;

//@Component
@Log4j2
public class TaskSchedule {

    @Resource
    private TaskService taskService;
    @Resource
    private BusService busService;

//    @Scheduled(fixedRate = 12000L) //二分钟同步一次
    public void sysncTaskState() {
        List<SessionState> finalStates=SessionState.getFinalState();
        List<TaskResponse> taskResponses=taskService.queryByNotStates(finalStates);
        for (TaskResponse taskResponse:taskResponses){
            taskService.updateState(taskResponse.getTaskId(),taskResponse.getBatchResponse().getState());
            String busName=busService.queryById(taskResponse.getTaskId()).getBusName();
            log.info("业务："+busName+",更新业务状态状态:" + JSONObject.toJSONString(taskResponse));
        }
    }
}
