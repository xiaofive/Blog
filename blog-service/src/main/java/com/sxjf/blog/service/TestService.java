package com.sxjf.blog.service;

import com.sxjf.blog.entity.TestUser;

import java.util.List;

public interface TestService {
    String test();
    List<TestUser> selectAll();
}
