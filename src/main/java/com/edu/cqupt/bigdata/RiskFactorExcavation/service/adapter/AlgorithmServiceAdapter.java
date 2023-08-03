package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Algorithm;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.AlgorithmService;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.algorithm.AlgorithmRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.algorithm.AlgorithmResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class AlgorithmServiceAdapter implements AlgorithmService {
    @Override
    public int algorithmInsert(AlgorithmRequest algorithminfo) {
        return 0;
    }

    @Override
    public boolean algorithmDelete(AlgorithmRequest algorithminfo) {
        return false;
    }

    @Override
    public int algorithmInsert(AlgorithmRequest algorithminfo, MultipartFile file) {
        return 0;
    }

    @Override
    public Algorithm selectById(int algorithmId) {
        return null;
    }

    @Override
    public List<AlgorithmResponse> selectAll() {
        return null;
    }

    @Override
    public Page<AlgorithmResponse> selectAll(int current, long size) {
        return null;
    }

    @Override
    public List<AlgorithmResponse> queryByAlgorithmName(String name) {
        return null;
    }

    @Override
    public boolean updateById() {
        return false;
    }


}
