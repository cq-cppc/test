package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.livy.SessionState;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.spark.TaskCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.spark.TaskResponse;

import java.util.List;
import java.util.Map;

public interface TaskService {
    int create(TaskCreateRequest taskCreateRequest);

    int killTask(Integer taskId);

    TaskResponse queryByTaskTypeAndBizId(String taskType, Integer bizId);

    //不用livy

    TaskResponse queryById(Integer id);

    int updateState(Integer id, SessionState sessionState);

    int updateState(Map<SessionState,List<Integer>> updateMap);

    List<TaskResponse> queryByBizId(Integer bizId);

    List<TaskResponse> queryByState(SessionState sessionState);

    List<TaskResponse> queryByNotStates(List<SessionState> sessionStates);

    List<TaskResponse> queryByAllRunningTask();

    List<TaskResponse> queryByTaskTypeAndBizIdList(String taskType, Integer bizId);

//    PageInfo<TaskResponse> queryByMultiCondition(TaskMultiCondition taskMultiCondition);
}
