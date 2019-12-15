package com.sxjf.blog.service;

import com.sxjf.blog.entity.TestUser;

import java.util.List;

public interface TestService {
    String test();
    /**
    * @Description: 测试
    * @Param: []
    * @return: java.util.List<com.sxjf.blog.entity.TestUser>
    * @Author: wangyang
    * @Date: 2018/12/25
    */
    List<TestUser> selectAll();
    /**
     * @Description: 测试
     * @Param: []
     * @return: java.util.List<com.sxjf.blog.entity.TestUser>
     * @Author: wangyang
     * @Date: 2018/12/25
     */
    List<TestUser> selectAll1();

    public String testCache(String key);

}
