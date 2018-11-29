package com.sxjf.blog.service.impl;

import com.sxjf.blog.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "Welcome to My Blog!";
    }
}
