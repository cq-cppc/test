package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.task.TaskType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.livy.SessionState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)

@TableName("task")
public class Task {

    @TableId(value = "id",type = IdType.INPUT)
    private Integer taskId; // 任务ID
    @TableField("task_state")
    private SessionState taskState;//任务状态
    @TableField("task_start_time")
    private Timestamp taskStartTime; //任务开始时间
    @TableField("task_finish_time")
    private Timestamp taskFinishTime; //任务完成时间
    @TableField("task_type")
    private TaskType taskType; // 任务类型
    @TableField("extra_params")
    private String extraParams;
}
