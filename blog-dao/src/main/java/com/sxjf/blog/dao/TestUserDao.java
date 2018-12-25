package com.sxjf.blog.dao;

import com.sxjf.blog.entity.TestUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * Description: 测试dao层
 * Author: wangyang
 * Date: 2018/11/29
 * Time: 23:47
 */
public interface TestUserDao {
    /**
    * @Description: 测试
    * @Param: []
    * @return: java.util.List<com.sxjf.blog.entity.TestUser>
    * @Author: wangyang
    * @Date: 2018/12/25
    */
    List<TestUser> selectAll();
}
