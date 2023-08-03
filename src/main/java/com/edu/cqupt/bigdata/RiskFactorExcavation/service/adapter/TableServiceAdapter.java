package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table.TableType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Table;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.TableService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.FETableCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableColumnCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableQueryRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableResponse;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public class TableServiceAdapter implements TableService {
    @Override
    public int insert(TableCreateRequest request) throws Exception {
        return 0;
    }

    @Override
    public PageInfo findByPage(TableQueryRequest queryRequest) {
        return null;
    }

    @Override
    public TableResponse findById(Integer id) {
        return null;
    }

    @Override
    public List<TableResponse> queryAllTable() {
        return null;
    }

    @Override
    public Page<TableResponse> queryAllTable(int current, long size) {
        return null;
    }

    @Override
    public List<TableResponse> queryByTableName(String name) {
        return null;
    }

    @Override
    public PageInfo<TableResponse> queryByPage(TableQueryRequest queryRequest) {
        return null;
    }

    @Override
    public Integer createFeTable(FETableCreateRequest request) throws Exception {
        return null;
    }

    @Override
    public ArrayList<TableColumnCreateRequest> convertFile2Schema(TableCreateRequest request)throws Exception{
        return null;
    }

    @Override
    public int dropTable(int tableId) {
        return 0;
    }
}
