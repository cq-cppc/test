package com.edu.cqupt.bigdata.RiskFactorExcavation.service.adapter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.User;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.Query;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.UserService;

import java.util.List;

public class UserServiceAdapter implements UserService {


    @Override
    public IPage<User> selectUserPage(Query query) {
        return null;
    }

    @Override
    public Integer addUser(User user) {
        return null;
    }

    @Override
    public Integer updateUser(User user) {
        return null;
    }

    @Override
    public Integer deleteUser(Integer id) {
        return null;
    }

    @Override
    public void batchDelete(List<Integer> ids) {

    }
}
