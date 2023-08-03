package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TableResponse {
    private Integer id;
    private String dataName;
    private String tableName;
    private String tableType;
    private String tableDesc;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Timestamp tableCreateTime;
    private List<TableColumnResponse> tableColumns;
}
