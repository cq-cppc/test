package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Algorithm;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.algorithm.AlgorithmRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.algorithm.AlgorithmResponse;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.table.TableResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AlgorithmService {

    int algorithmInsert(AlgorithmRequest algorithminfo);

    boolean algorithmDelete(AlgorithmRequest algorithminfo);

    int algorithmInsert(AlgorithmRequest algorithminfo, MultipartFile file);

    Algorithm selectById(int algorithmId);

    List<AlgorithmResponse> selectAll();

    Page<AlgorithmResponse> selectAll(int current, long size);

    List<AlgorithmResponse> queryByAlgorithmName(String name);

    boolean updateById();


}
