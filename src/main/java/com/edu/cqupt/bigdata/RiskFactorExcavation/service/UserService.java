package com.edu.cqupt.bigdata.RiskFactorExcavation.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.edu.cqupt.bigdata.RiskFactorExcavation.entity.User;
import com.edu.cqupt.bigdata.RiskFactorExcavation.service.request.Query;


import java.util.List;

public interface UserService {

        IPage<User> selectUserPage(Query query);

        Integer addUser(User user);

        Integer updateUser(User user);

        Integer deleteUser(Integer id);

        void batchDelete(List<Integer> ids);
    }



