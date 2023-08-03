package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table.ColumnType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TableColumnCreateRequest {
    private Integer tableId;
    private String columnName;
    private String columnDescription;
    private String columnType;
}
