package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)

@TableName("algorithm")
public class Algorithm {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField("deploy_file_path")
    private String deployFilePath;
    @TableField("algorithm_description")
    private String algorithmDescription;
    @TableField("task_type")
    private String taskType;
    @TableField("algorithm_name")
    private String algorithmName;
}
