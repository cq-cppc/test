package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table.ColumnType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.commom.table.TableType;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.data.DataMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.TableMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Table;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.TableColumnService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.TableServiceAdapter;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableColumnCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.util.NameNameGenerator;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;

@Service
@Log4j2
public class TableServiceImpl extends TableServiceAdapter {

    @Resource
    private TableMapper tableMapper;

    @Resource
    private NameNameGenerator nameNameGenerator;

    @Resource
    private DataMapper dataMapper;

    @Resource
    private TableColumnService columnService;

    /**
     * 解析导入的数据表文件，并生成不包含列头的数据文件，入参是TableCreateRequest包含了建表所需要的信息
     * 返回值是数据列的信息包含了，列的名称以及列的类型
     * */
    @Override
    public ArrayList<TableColumnCreateRequest> convertFile2Schema(TableCreateRequest request) throws Exception {
        int i = 0;
        TableType tableType = TableType.verify(request.getTableType());//通过枚举类验证并获取列类型
        File dataFile = new File(request.getTableFilePath());//数据表原始文件
        File withoutHead=new File(dataFile.getParentFile(),"without_head.csv");//用于存储无表头的数据表文件
        InputStream inputStream = new FileInputStream(dataFile);
        InputStreamReader reader = new InputStreamReader(inputStream);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
        CSVPrinter printer = new CSVPrinter(new FileWriter(withoutHead), CSVFormat.DEFAULT);//建立向存储无表头的数据表文件写入数据的printer
        ArrayList<String> colName = new ArrayList<>();
        ArrayList<String> colType = new ArrayList<>();
        ArrayList<TableColumnCreateRequest> cols = new ArrayList<>();
        for (CSVRecord record : records) {
            if (i == 0) {                         //i==0时为数据列头
                for (String str : record) colName.add(str);
            } else {                        //i！=0时为数据
                if (i == 1) {                         //取第一行推断列类型
                    for (String val : record) {
                        if (val.matches("[0-9]+\\.[0-9]+"))//正则表达式解析浮点数
                            colType.add(ColumnType.convertType(ColumnType.cdouble, tableType));
                        else if (val.matches("[0-9]+")&&val.length()<11) colType.add(ColumnType.convertType(ColumnType.cinteger, tableType));//正则表达式解析整数
                        else colType.add(ColumnType.convertType(ColumnType.cstring, tableType));//正则表达式解析字符串
                    }
                }
                printer.printRecord(record);//将数据写入无表头的数据表文件中
            }
            i++;
        }
        for (i = 0; i < colName.size(); i++) {
            TableColumnCreateRequest col = new TableColumnCreateRequest();
            col.setColumnName(colName.get(i));
            col.setColumnType(colType.get(i));
            cols.add(col);
        }
        printer.close(true);
        inputStream.close();
        reader.close();
        return cols;
    }

    /**
     * 插入数据表信息到项目数据库中，并将数据表数据导入到数据库中，入参是TableCreateRequest包含了建表所需要的信息
     * 返回值是数据库导入表是否成功指示值，如果大于0则成功
     * */
    @Override
    public int insert(TableCreateRequest request) throws Exception {
        int flag;
        StringBuffer tableName=new StringBuffer(nameNameGenerator.getName());//生成数据表名以防表名冲突
        tableName.append('_');//生成数据表名以防表名冲突
        Table table = new Table();
        BeanUtils.copyProperties(request, table);
        table.setTableCreateTime(new Timestamp(new Date().getTime()));
        flag=tableMapper.insert(table);
        tableName.append(table.getId());
        String name=tableName.toString();//生成数据表名以防表名冲突
        tableMapper.resetDataName(table.getId(),name);
        request.setDataName(name);
        List<TableColumnCreateRequest> columnRequests=request.getTableColumns();
        File dataFile = new File(request.getTableFilePath());//获取数据表原始csv文件
        File withoutHead=new File(dataFile.getParentFile(),"without_head.csv");//根据数据表原始csv文件，获取数据表剔除表头的csv文件
        request.setTableFilePath(withoutHead.getCanonicalPath());
        for (TableColumnCreateRequest columnRequest:columnRequests){
            columnRequest.setTableId(table.getId());
            flag=columnService.insert(columnRequest);
        }
        dataMapper.createTable(request);
        dataMapper.loadTata(request);
        return flag;
    }

    /***
     * 根据id查找表，入参是表id，返回值是表实体视图
     */

    @Override
    public TableResponse findById(Integer id) {
        Table table = tableMapper.selectById(id);
        TableResponse response = new TableResponse();
        BeanUtils.copyProperties(table, response);//将实体封装入视图中
        response.setTableColumns(columnService.findByTableId(id));
        return response;
    }


    /***
     * 查找所表，返回值是表实体视图List
     */

    @Override
    public List<TableResponse> queryAllTable() {
        List<Table> tables=tableMapper.selectByMap(new TreeMap<>());
        ArrayList<TableResponse> tableResponses=new ArrayList<>(tables.size());
        for (Table table:tables){
            TableResponse tableResponse=new TableResponse();
            BeanUtils.copyProperties(table,tableResponse);
            tableResponses.add(tableResponse);//将实体封装入视图中
        }
        return tableResponses;
    }

    @Override
    public List<TableResponse> queryByTableName(String name) {
        TreeMap<String,Object> treeMap=new TreeMap<>();
        treeMap.put("table_name",name);
        List<Table> tables=tableMapper.selectByMap(treeMap);
        ArrayList<TableResponse> tableResponses=new ArrayList<>(tables.size());
        for (Table table:tables){
            TableResponse tableResponse=new TableResponse();
            BeanUtils.copyProperties(table,tableResponse);
            tableResponses.add(tableResponse);
        }
        return tableResponses;
    }

    /***
     * 根据id删除表，入参是表id，返回值是数据库导入表是否成功指示值，如果大于0则成功
     */

    @Override
    public int dropTable(int tableId) {
        Table table=new Table();
        table.setId(tableId);
        dataMapper.dropTable(tableMapper.selectById(tableId).getTableName());
        columnService.dorpColumnByTableId(tableId);
        return tableMapper.deleteById(tableId);
    }

    /***
     * 分页查找所有表，返回值是一个表实体视图页
     */

    @Override
    public Page<TableResponse> queryAllTable(int current, long size) {
        Page<Table> tablePage = new Page<>(current,size);
        Page<TableResponse> tableResponsePage = new Page<>(current,size);
        tablePage = tableMapper.selectPage(tablePage, null);
        ArrayList<TableResponse> tableResponses=new ArrayList<>(tablePage.getRecords().size());
        for (Table table:tablePage.getRecords()){
            TableResponse tableResponse=new TableResponse();
            BeanUtils.copyProperties(table,tableResponse);
            tableResponses.add(tableResponse);
        }
        BeanUtils.copyProperties(tablePage,tableResponsePage);
        tableResponsePage.setRecords(tableResponses);
        return tableResponsePage;
    }
}
