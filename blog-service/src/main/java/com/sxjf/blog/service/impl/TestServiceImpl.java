package com.sxjf.blog.service.impl;

import com.sxjf.blog.dao.TestUserDao;
import com.sxjf.blog.entity.TestUser;
import com.sxjf.blog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestUserDao testUserDao;

    @Override
    public String test() {
        return "Welcome to My Blog!";
    }

    /**
    * @Description: 测试
    * @Param: []
    * @return: java.util.List<com.sxjf.blog.entity.TestUser>
    * @Author: wangyang
    * @Date: 2018/12/25
    */
    @Override
    public List<TestUser> selectAll() {
        return testUserDao.selectAll();
    }
}
