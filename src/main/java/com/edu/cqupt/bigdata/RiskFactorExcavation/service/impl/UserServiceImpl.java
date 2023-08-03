package com.edu.cqupt.bigdata.RiskFactorExcavation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter.UserServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.cqupt.bigdata.RiskFactorExcavation.dao.mysql.UserMapper;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.User;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.Query;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends UserServiceAdapter {
    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> selectUserPage(Query queryDTO) {
        Page<User> page=new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return userMapper.selectUserPage(page,queryDTO.getKeyword());
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }



    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }



    @Override
    public void batchDelete(List<Integer> ids) {
        userMapper.deleteBatchIds(ids);
    }

}
