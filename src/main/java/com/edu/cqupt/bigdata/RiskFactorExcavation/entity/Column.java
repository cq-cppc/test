package com.edu.cqupt.bigdata.RiskFactorExcavation.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table.ColumnType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@TableName("table_column")
public class Column {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer tableId;
    private String columnName;
    private String columnDescription;
    private String columnType;
}
