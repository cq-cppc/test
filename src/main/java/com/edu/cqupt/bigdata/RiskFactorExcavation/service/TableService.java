package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table.TableType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Table;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.FETableCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableColumnCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableQueryRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableResponse;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface TableService {
    int insert(TableCreateRequest request) throws Exception;

    PageInfo findByPage(TableQueryRequest queryRequest);

    TableResponse findById(Integer id);

    List<TableResponse> queryAllTable();

    Page<TableResponse> queryAllTable(int current, long size);

    List<TableResponse> queryByTableName(String name);

    PageInfo<TableResponse> queryByPage(TableQueryRequest queryRequest);

    Integer createFeTable(FETableCreateRequest request) throws Exception;

    ArrayList<TableColumnCreateRequest> convertFile2Schema(TableCreateRequest request)throws Exception;

    int dropTable(int tableId);

}
