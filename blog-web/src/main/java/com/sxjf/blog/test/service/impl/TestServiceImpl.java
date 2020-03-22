package com.sxjf.blog.test.service.impl;

import com.sxjf.blog.test.entity.User;
import com.sxjf.blog.test.mapper.TestMapper;
import com.sxjf.blog.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public User test() {
        return testMapper.test();
    }
}
