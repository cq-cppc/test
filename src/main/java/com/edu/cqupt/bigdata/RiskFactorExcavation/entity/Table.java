package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableColumnResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)

@TableName("data_table")
public class Table {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String tableDesc;
    private String tableName;
    private String dataName;
    @TableField("table_creator_id")
    private Integer tableCreatorId=1;
    @TableField("table_create_time")
    private Timestamp tableCreateTime;
    private String tableType;
}


//    private Integer id;
//    private String dataName;
//    private String tableName;
//    private String tableType;
//    private String tableDesc;
//    @JSONField(format="yyyy-MM-dd HH:mm:ss")
//    private Timestamp tableCreateTime;
//    private List<TableColumnResponse> tableColumns;