package com.edu.cqupt.bigdata.RiskFactorExcavation.dao.data;


import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableCreateRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Repository
public interface DataMapper {

    int createTable(@Param("request") TableCreateRequest request);

    int loadTata(@Param("request") TableCreateRequest request);

    @Select("select * from ${tableName}")
    List<Map> selectAll(String tableName);

    int updateValue();

    @Update("drop table ${tableName}")
    int dropTable(String tableName);

}
