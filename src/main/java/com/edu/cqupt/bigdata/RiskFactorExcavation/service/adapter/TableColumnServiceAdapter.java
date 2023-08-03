package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.edu.cqupt.bigdata.RiskFactorExcavation.service.TableColumnService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableColumnCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableColumnResponse;

import java.util.List;

public class TableColumnServiceAdapter implements TableColumnService {
    @Override
    public int insert(TableColumnCreateRequest createRequest) {
        return 0;
    }

    @Override
    public List<TableColumnResponse> findByTableId(Integer id) {
        return null;
    }

    @Override
    public TableColumnResponse queryById(Integer id) {
        return null;
    }

    @Override
    public int dorpColumnByTableId(int tableId) {
        return 0;
    }

    @Override
    public int dorpColumnById(int id) {
        return 0;
    }
}
