package com.edu.cqupt.bigdata.RiskFactorExcavation;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.data.DataMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.AlgorithmMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.TableMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Algorithm;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.AlgorithmService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.TableService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableColumnCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.table.TableCreateRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.util.PythonRun;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@SpringBootTest
class RiskFactorExcavationApplicationTests {


    @Resource
    private PythonRun pythonRun;

    @Test
    void contextLoads() throws Exception {
        List<String> list=JSONObject.parseArray("[\"--factor-count=1\",\"--label=label\",\"--table-name=中国健康养老数据\",\"--table-cols=[{$columnName$:$communityID_x$},{$columnName$:$bl_fasting$},{$columnName$:$bl_tg$},{$columnName$:$bl_top_coding_tg$},{$columnName$:$bl_crea$},{$columnName$:$bl_bun$},{$columnName$:$bl_hdl$},{$columnName$:$bl_ldl$},{$columnName$:$bl_cho$},{$columnName$:$bl_glu$},{$columnName$:$bl_ua$},{$columnName$:$bl_cysc$},{$columnName$:$bl_crp$},{$columnName$:$bl_hbalc$},{$columnName$:$communityID_y$},{$columnName$:$pa001$},{$columnName$:$qa002$},{$columnName$:$qa002_1$},{$columnName$:$qa003$},{$columnName$:$qa004$},{$columnName$:$qa005$},{$columnName$:$qa006$},{$columnName$:$qa006_1$},{$columnName$:$qa007$},{$columnName$:$qa008$},{$columnName$:$qa009$},{$columnName$:$qa010$},{$columnName$:$qa010_1$},{$columnName$:$qa011$},{$columnName$:$qa012$},{$columnName$:$qa013$},{$columnName$:$qa014$},{$columnName$:$qa016$},{$columnName$:$qa017$},{$columnName$:$qb002$},{$columnName$:$qb003$},{$columnName$:$qb004$},{$columnName$:$qc003$},{$columnName$:$qc004$},{$columnName$:$qc005$},{$columnName$:$qc006$},{$columnName$:$pd001$},{$columnName$:$qd004$},{$columnName$:$qi002$},{$columnName$:$qi003$},{$columnName$:$pj001$},{$columnName$:$qj002$},{$columnName$:$qj003$},{$columnName$:$qj004$},{$columnName$:$pk001$},{$columnName$:$qk002$},{$columnName$:$ql002$},{$columnName$:$ql003$},{$columnName$:$ql004$},{$columnName$:$qm002$},{$columnName$:$qm005$},{$columnName$:$communityID$},{$columnName$:$ba000_w2_3$},{$columnName$:$be001$},{$columnName$:$label$},{$columnName$:$this_county_Insurance$},{$columnDescription$:$修改列名，否则与mysql关键字冲突$,$columnName$:$Set_data$}]\",\"--database-url=localhost:3306/data_tables\",\"--database-password=123456\",\"--database-user=root\"]\n",String.class);
        pythonRun.run("E:\\app\\upload\\db2740e3-9823-4af4-b131-5785109dbd0b\\test.py",list);
    }
}
