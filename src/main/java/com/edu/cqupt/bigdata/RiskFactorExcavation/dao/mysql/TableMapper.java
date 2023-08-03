package com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Table;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TableMapper extends BaseMapper<Table> {

    @Update("update data_table set data_name = #{dataName} where id = #{tableId}")
    int resetDataName(int tableId,String dataName);

}
