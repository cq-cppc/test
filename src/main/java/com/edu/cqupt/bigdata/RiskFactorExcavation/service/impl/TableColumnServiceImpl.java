package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.ColumnMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Column;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.TableColumnServiceAdapter;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableColumnCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableColumnResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Service
@Log4j2
public class TableColumnServiceImpl extends TableColumnServiceAdapter {

    @Resource
    private ColumnMapper columnMapper;

    /***
     * 根据表id查找列，入参是表id，返回值是列实体List
     */
    @Override
    public List<TableColumnResponse> findByTableId(Integer id) {
        QueryWrapper<Column> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("table_id",id);
        List<Column> columns=columnMapper.selectList(queryWrapper);
        List<TableColumnResponse> columnResponses=new ArrayList<>(columns.size());
        for (Column column:columns){
            TableColumnResponse tableColumnResponse=new TableColumnResponse();
            BeanUtils.copyProperties(column,tableColumnResponse);
            columnResponses.add(tableColumnResponse);
        }
        return columnResponses;
    }

    /**
     * 插入列信息到项目数据库中，入参是TableCreateRequest包含了列的信息
     * 返回值是插入列是否成功指示值，如果大于0则成功
     * */
    @Override
    public int insert(TableColumnCreateRequest createRequest) {
        Column column=new Column();
        BeanUtils.copyProperties(createRequest,column);
        return columnMapper.insert(column);
    }

    /***
     * 根据表id删除列，入参是表id，返回值是列删除是否成功指示值，如果大于0则成功
     */

    @Override
    public int dorpColumnByTableId(int tableId) {
        TreeMap<String,Object> map=new TreeMap<>();
        map.put("table_id",tableId);
        return columnMapper.deleteByMap(map);
    }
}
