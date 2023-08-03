package com.edu.cqupt.bigdata.RiskFactorExcavation.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.TableService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableColumnCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@Log4j2
@RestController
@RequestMapping("/table")
@CrossOrigin

public class TableController {

    @Resource
    private TableService tableService;

    @PostMapping("/tableSchemaConvert")
    public ArrayList<TableColumnCreateRequest> convertFile2Schema(@RequestBody TableCreateRequest request)throws Exception {
        log.info("tableSchemaConvert："+ JSONObject.toJSONString(request));
        return tableService.convertFile2Schema(request);
    }

    @PostMapping("/importData")
    public int importData(@RequestBody TableCreateRequest request) throws Exception {
        return tableService.insert(request);
    }

    @PostMapping("/selectById/{tableId}")
    public TableResponse queryTableById(@PathVariable int tableId){
        return tableService.findById(tableId);
    }

    @PostMapping("/page/{currentPage}/{pageSize}")
    public String queryAllTable(@PathVariable int currentPage,@PathVariable long pageSize){
        return JSONObject.toJSONString(tableService.queryAllTable(currentPage,pageSize));
    }

    @PostMapping("/datas")
    public String queryAllTable(){
        return JSONObject.toJSONString(tableService.queryAllTable());
    }

    @PostMapping("/delete/{tableId}")
    public int deleteTable(@PathVariable int tableId){
        return tableService.dropTable(tableId);
    }

}
