package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.AlgorithmMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Algorithm;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.Table;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.AlgorithmServiceAdapter;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.algorithm.AlgorithmRequest;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.response.algorithm.AlgorithmResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

@Service
@Log4j2
public class AlgorithmServiceImpl extends AlgorithmServiceAdapter {

    @Resource
    private AlgorithmMapper algorithmMapper;

    @Value("${algorithm.save.path.base}")
    private String basePath;

    @Override
    public int algorithmInsert(AlgorithmRequest algorithminfo, MultipartFile file) {
        Algorithm algorithm=new Algorithm();
        BeanUtils.copyProperties(algorithminfo,algorithm);
        algorithm.setDeployFilePath(basePath+UUID.randomUUID().toString()+".jar");
        return algorithmMapper.insert(algorithm);
    }

    /**
     * 插入算法信息到项目数据库中，入参是AlgorithmRequest包含了算法的信息
     * 返回值是是否成功指示值，如果大于0则成功
     * */
    @Override
    public int algorithmInsert(AlgorithmRequest algorithminfo) {
        Algorithm algorithm=new Algorithm();
        BeanUtils.copyProperties(algorithminfo,algorithm);
        algorithm.setDeployFilePath(algorithminfo.getDeployFilePath());
        return algorithmMapper.insert(algorithm);
    }

    /***
     * 根据id查找算法，入参是算法id，返回值是算法实体视图
     */
    @Override
    public Algorithm selectById(int algorithmId) {
        return algorithmMapper.selectById(algorithmId);
    }

    /***
     * 查找所算法，返回值是算法实体视图List
     */
    @Override
    public List<AlgorithmResponse> selectAll(){
        List<Algorithm> algorithms = algorithmMapper.selectByMap(new TreeMap<>());
        ArrayList<AlgorithmResponse> algorithmResponses = new ArrayList<>(algorithms.size());
        for (Algorithm algorithm : algorithms){
            AlgorithmResponse algorithmResponse=new AlgorithmResponse();
            BeanUtils.copyProperties(algorithm,algorithmResponse);
            algorithmResponses.add(algorithmResponse);
        }
        return algorithmResponses;
    }

    /**
     * 该方法未使用不需要写入文档中
     * */
    @Override
    public List<AlgorithmResponse> queryByAlgorithmName(String name) {
        TreeMap<String,Object> treeMap=new TreeMap<>();
        QueryWrapper<Algorithm> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("algorithm_name",name);
        List<Algorithm> algorithms = algorithmMapper.selectList(queryWrapper);
        ArrayList<AlgorithmResponse> algorithmResponses = new ArrayList<>(algorithms.size());
        for (Algorithm algorithm : algorithms){
            AlgorithmResponse algorithmResponse=new AlgorithmResponse();
            BeanUtils.copyProperties(algorithm,algorithmResponse);
            algorithmResponses.add(algorithmResponse);
        }
        return algorithmResponses;
    }

    /***
     * 根据id删除算法，入参是算法id，返回值是删除是否成功指示值，如果为true则成功
     */
    @Override
    public boolean algorithmDelete(AlgorithmRequest algorithminfo) {
        Algorithm algorithm=new Algorithm();
        algorithm.setId(algorithminfo.getId());
        boolean flag=false;
        String filePath=algorithmMapper.selectById(algorithminfo.getId()).getDeployFilePath();
        int value=algorithmMapper.deleteById(algorithminfo.getId());
        if (value==1){
            File file=new File(filePath);
            flag=file.delete();//删除算法文件
        }
        return flag;
    }

    /***
     * 分页查找算法，返回值是一个算法实体视图页
     */
    @Override
    public Page<AlgorithmResponse> selectAll(int current, long size) {
        Page<Algorithm> algorithmPage = new Page<>(current,size);
        Page<AlgorithmResponse> AlgorithmResponsePage = new Page<>(current,size);
        algorithmPage = algorithmMapper.selectPage(algorithmPage, null);
        ArrayList<AlgorithmResponse> AlgorithmResponses=new ArrayList<>(algorithmPage.getRecords().size());
        for (Algorithm table:algorithmPage.getRecords()){
            AlgorithmResponse AlgorithmResponse=new AlgorithmResponse();
            BeanUtils.copyProperties(table,AlgorithmResponse);
            AlgorithmResponses.add(AlgorithmResponse);
        }
        BeanUtils.copyProperties(algorithmPage,AlgorithmResponsePage);
        AlgorithmResponsePage.setRecords(AlgorithmResponses);
        return AlgorithmResponsePage;
    }
}
