package com.edu.cqupt.bigdata.RiskFactorExcavation.entity.abstractEntity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class AbstractBus {
    @TableId(value = "id",type = IdType.AUTO)
    protected int id;
    protected String name;
    protected String icdCode;
    protected int algorithmId;
    protected String description;
    protected Timestamp busCreateTime;
    protected int taskId;
}
