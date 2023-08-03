package com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table;

import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table.ColumnType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class TableColumnResponse {
    private Integer columnId;
    private String columnName;
    private String columnDescription;
    private ColumnType columnType;
}
