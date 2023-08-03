package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableColumnCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableColumnResponse;

import java.util.List;

public interface TableColumnService {


    int insert(TableColumnCreateRequest createRequest);

    List<TableColumnResponse> findByTableId(Integer id);

    TableColumnResponse queryById(Integer id);

    int dorpColumnByTableId(int tableId);

    int dorpColumnById(int id);
}
