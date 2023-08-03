package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.livy.SessionState;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.TaskService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.spark.TaskCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.spark.TaskResponse;

import java.util.List;
import java.util.Map;

public class TaskServiceAdapter implements TaskService {

    @Override
    public int create(TaskCreateRequest taskCreateRequest) {
        return 0;
    }

    @Override
    public int killTask(Integer taskId) {
        return 0;
    }

    @Override
    public TaskResponse queryById(Integer id) {
        return null;
    }

    @Override
    public TaskResponse queryByTaskTypeAndBizId(String taskType, Integer bizId) {
        return null;
    }

    @Override
    public int updateState(Integer id, SessionState sessionState) {
        return 0;
    }

    @Override
    public int updateState(Map<SessionState, List<Integer>> updateMap) {
        return 0;
    }

    @Override
    public List<TaskResponse> queryByBizId(Integer bizId) {
        return null;
    }

    @Override
    public List<TaskResponse> queryByState(SessionState sessionState) {
        return null;
    }

    @Override
    public List<TaskResponse> queryByNotStates(List<SessionState> sessionStates) {
        return null;
    }

    @Override
    public List<TaskResponse> queryByAllRunningTask() {
        return null;
    }

    @Override
    public List<TaskResponse> queryByTaskTypeAndBizIdList(String taskType, Integer bizId) {
        return null;
    }
}
