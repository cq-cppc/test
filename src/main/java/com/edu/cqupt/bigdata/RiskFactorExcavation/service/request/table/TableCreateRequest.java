package com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TableCreateRequest {
    private String tableName;
    private String dataName;
    private String tableType;
    private String tableDesc;
    private List<TableColumnCreateRequest> tableColumns;
    private String tableFilePath;
}
