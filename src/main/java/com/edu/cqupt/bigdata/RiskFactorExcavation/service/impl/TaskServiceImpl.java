package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.livy.SessionState;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.TaskMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Task;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.LivyServer;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.TaskServiceAdapter;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.task.spark.TaskCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.livy.BatchResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.task.spark.TaskResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class TaskServiceImpl extends TaskServiceAdapter {
    @Resource
    private LivyServer livyServer;


    @Resource
    TaskMapper taskMapper;


    /**
     * Task创建模块
     * @param taskCreateRequest 任务创建信息
     * @return 返回一个状态码
     */
    @Override
    @Transactional(rollbackFor = Throwable.class)

    public int create(TaskCreateRequest taskCreateRequest) {

        log.info("创建Livy任务:" + JSONObject.toJSONString(taskCreateRequest));
        List<String> encodeArgs = new ArrayList<>();
        for (String str : taskCreateRequest.getBatchRequest().getArgs()
        ) {
            encodeArgs.add(new Base64().encodeAsString(str.getBytes(StandardCharsets.UTF_8)));
        }
        taskCreateRequest.getBatchRequest().setArgs(encodeArgs);
        BatchResponse batchResponse = livyServer.submit(taskCreateRequest.getBatchRequest());
        Task task = new Task();
        BeanUtils.copyProperties(taskCreateRequest,task);
        task.setTaskId(batchResponse.getId());
        task.setTaskState(batchResponse.getState());

        log.info("创建任务:" + JSONObject.toJSONString(task));
//        taskMapper.insertSelective(taskInfo);
        return task.getTaskId();
    }



    /**
     * 根据一个任务状态和业务id进行任务
     * @param taskType 任务类型
     * @param bizId 业务类型
     * @return 返回一个业务信息
     */
    /*@Override
    public TaskResponse queryByTaskTypeAndBizId(String taskType, Integer bizId) {

        Example example = new Example(TaskInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("taskType", taskType);
        criteria.andEqualTo("bizId", bizId);
        example.orderBy("taskId").desc();
        List<TaskInfo> streamTaskInfos = taskMapper.selectByExample(example);
        if (streamTaskInfos.size() > 0) {
            TaskInfo streamTaskInfo = streamTaskInfos.get(0);
            TaskResponse taskResponse = new TaskResponse();
            BeanUtils.copyProperties(streamTaskInfo, taskResponse);
            try {
                taskResponse.setBatchResponse(livyServer.queryById(streamTaskInfo.getTaskId()));
            } catch (Exception e) {
                log.error("任务状态已被删除");
            }
            return taskResponse;
        }
        return null;

    }*/

    /**
     * 根基有个任务状态和业务id查询任务
     * @param taskType 任务类型
     * @param bizId 业务类型
     * @return 返回一个任务信息列表
     */
    /*@Override
    public List<TaskResponse> queryByTaskTypeAndBizIdList(String taskType, Integer bizId) {

        Example example = new Example(TaskInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("taskType", taskType);
        criteria.andEqualTo("bizId", bizId);
        example.orderBy("taskId").desc();
        List<TaskInfo> streamTaskInfos = taskMapper.selectByExample(example);
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (TaskInfo t : streamTaskInfos
        ) {
            TaskResponse taskResponse = new TaskResponse();
            BeanUtils.copyProperties(t, taskResponse);
            try {
                taskResponse.setBatchResponse(livyServer.queryById(t.getTaskId()));
            } catch (Exception e) {
                log.error("任务状态已被删除");
            }
            taskResponses.add(taskResponse);
        }
        return taskResponses;

    }*/

    /**
     * 根据多条件查询接口
     * @param taskMultiCondition 多条件
     * @return 返回一个信息列表
     */
    /*@Override
    public PageInfo<TaskResponse> queryByMultiCondition(TaskMultiCondition taskMultiCondition) {

        Example example = new Example(TaskInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(taskMultiCondition.getBizId()!=null)
            criteria.andEqualTo("bizId",taskMultiCondition.getBizId());
        if(taskMultiCondition.getTaskState()!=null&&!taskMultiCondition.getTaskState().equals(""))
            criteria.andEqualTo("taskState",taskMultiCondition.getTaskState());
        if(taskMultiCondition.getTaskType()!=null&&!taskMultiCondition.getTaskType().equals(""))
            criteria.andEqualTo("taskType",taskMultiCondition.getTaskType());

        List<TaskInfo> streamTaskInfo = taskMapper.selectByExample(example);
        List<TaskResponse> taskResponses = new ArrayList<>();
        for(TaskInfo t: streamTaskInfo){
            TaskResponse taskResponse = new TaskResponse();
            BeanUtils.copyProperties(t,taskResponse);
            taskResponses.add(taskResponse);
        }
        PageInfo<TaskResponse> taskResponsePageInfo = new PageInfo<>(taskResponses);
        return taskResponsePageInfo;
    }*/

    /**
     * 查询任务id
     * @param id 任务id
     * @return 返回任务大概信息
     */
    @Override
    public TaskResponse queryById(Integer id) {
        TaskResponse taskResponse = new TaskResponse();
        Task taskInfo = taskMapper.selectById(id);
        BeanUtils.copyProperties(taskInfo, taskResponse);
        taskResponse.setBatchResponse(null);
        return taskResponse;
    }

    /**
     * 根据任务id更新状态
     * @param id 任务id
     * @param sessionState 状态
     * @return 返回状态码
     */
    @Override
    public int updateState(Integer id, SessionState sessionState) {
        Task task = new Task();
        task.setTaskState(sessionState);
        task.setTaskId(id);
        return taskMapper.updateById(task);
    }

    @Override
    public int updateState(Map<SessionState, List<Integer>> updateMap) {
        Iterator<Map.Entry<SessionState, List<Integer>>> entryIterator=updateMap.entrySet().iterator();
        Map.Entry<SessionState, List<Integer>> entry=null;
        while (entryIterator.hasNext()){
            entry=entryIterator.next();
            Task task=new Task();
            task.setTaskState(entry.getKey());
            UpdateWrapper<Task> wrapper=new UpdateWrapper<>();
            wrapper.in("id",entry.getValue());
            taskMapper.update(task,wrapper);
        }
        return super.updateState(updateMap);
    }

    /**
     * 根据业务id查询任务状态
     * @param bizId 业务id
     * @return 返回任务信息列表
     */
    @Override
    public List<TaskResponse> queryByBizId(Integer bizId) {
        QueryWrapper<Task> queryWrapper=new QueryWrapper();
        queryWrapper.eq("bus_id",bizId);
        List<Task> tasks=taskMapper.selectList(queryWrapper);
        List<TaskResponse> taskResponses = new ArrayList<>();
        for(Task task: tasks){
            TaskResponse taskResponse = new TaskResponse();
            BeanUtils.copyProperties(task,taskResponse);
            taskResponses.add(taskResponse);
        }
        return taskResponses;
    }

    @Override
    public int killTask(Integer taskId) {
        return 0;
    }

    /**
     * 根据id终止任务
     * @param taskId 任务id
     * @return 返回状态
     */
    /*@Override
    @Transactional(rollbackFor = Throwable.class)
    public int killTask(Integer taskId) {
        log.info("kill task " + taskId);
        TaskInfo streamTaskInfo = taskMapper.selectByPrimaryKey(taskId);
        if (!SessionState.isFinalState(streamTaskInfo.getTaskState())) {
            try {

                livyServer.killTaskById(taskId);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("结束livy任务失败" + e.getMessage() + " id:" + taskId);
            }
        }
        return taskMapper.deleteByPrimaryKey(taskId);

    }*/

    /**
     * 根据任务状态查询任务信息
     * @param sessionState 状态
     * @return 返回一个任务接口
     */
    @Override
    public List<TaskResponse> queryByState(SessionState sessionState) {
//        Example example = new Example(TaskInfo.class);
//        Example.Criteria c = example.createCriteria();
//        c.andEqualTo("taskState", sessionState);
//        return queryByExample(example);
        return null;
    }

    @Override
    public List<TaskResponse> queryByNotStates(List<SessionState> sessionStates) {
        QueryWrapper<Task> queryWrapper=new QueryWrapper();
        queryWrapper.notIn("task_state",sessionStates);
        List<Task> tasks=taskMapper.selectList(queryWrapper);
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (Task task : tasks) {
            TaskResponse taskResponse = new TaskResponse();
            BeanUtils.copyProperties(task, taskResponse);
            if (!SessionState.isFinalState(taskResponse.getTaskState())) {
                try {
                    taskResponse.setBatchResponse(livyServer.queryById(task.getTaskId()));

                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    log.error("查询Livy任务状态失败！ id:" + task.getTaskId());
                }
            }
            taskResponses.add(taskResponse);
        }
        return taskResponses;
    }

    /**
     * 分页查找
     * @param example 里面有 pageNum,pageSize
     * @return 返回一个列表信息
     */
   /* public List<TaskResponse> queryByExample(Example example) {
        List<TaskInfo> taskInfos = taskMapper.selectByExample(example);
        List<TaskResponse> taskResponses = new ArrayList<>();
        for (TaskInfo s : taskInfos
        ) {
            TaskResponse taskResponse = new TaskResponse();
            BeanUtils.copyProperties(s, taskResponse);
            if (!SessionState.isFinalState(taskResponse.getTaskState())) {
                try {
                    taskResponse.setBatchResponse(livyServer.queryById(s.getTaskId()));

                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    log.error("查询Livy任务状态失败！ id:" + s.getTaskId());
                }
            }
            taskResponses.add(taskResponse);
        }
        return taskResponses;
    }*/

    /**
     * 查找所有正在运行的任务
     * @return 返 回一个任务列表
     */
    @Override
    public List<TaskResponse> queryByAllRunningTask() {
//        Example example = new Example(TaskInfo.class);
//        Example.Criteria c = example.createCriteria();
//        c.andNotIn("taskState", SessionState.getFinalState());
//        return queryByExample(example);
        return null;
    }

    @Override
    public List<TaskResponse> queryByTaskTypeAndBizIdList(String taskType, Integer bizId) {
        return null;
    }

    /*@Override
    public PageInfo<TaskResponse> queryByMultiCondition(TaskMultiCondition taskMultiCondition) {
        return null;
    }*/
}
