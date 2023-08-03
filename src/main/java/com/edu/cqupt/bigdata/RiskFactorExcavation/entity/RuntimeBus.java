package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("runtime_bus")
public class RuntimeBus {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer busId;
    private String busName;
    private String icdCode;
    private Integer algorithmId;
    private String outPutFilePath=null;
    private String busDescription;
    private Timestamp taskCreateTime;
    private Integer taskId;
}
