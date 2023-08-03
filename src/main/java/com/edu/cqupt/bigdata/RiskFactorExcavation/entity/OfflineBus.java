package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)

@TableName("offline_bus")
public class OfflineBus {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer busId;
    @TableField("bus_name")
    private String busName;
    @TableField("icd_code")
    private String icdCode;
    @TableField("algorithm_id")
    private Integer algorithmId;
    @TableField("output_file_path")
    private String outPutFilePath;
    @TableField("bus_description")
    private String busDescription;
    @TableField("bus_create_time")
    private Timestamp taskCreateTime;
    @TableField("task_id")
    private Integer taskId;
}
