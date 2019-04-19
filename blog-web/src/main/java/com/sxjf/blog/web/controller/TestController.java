package com.sxjf.blog.web.controller;

import com.sxjf.blog.common.aspectJ.Calculation;
import com.sxjf.blog.entity.TestUser;
import com.sxjf.blog.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private Calculation calculation;

    @GetMapping("/welcome")
    public String test(){return "Welcome to My Blog!";}

    @GetMapping("/testService")
    public String testService(){
        return testService.test();
    }

    @GetMapping("/testDao")
    public List<TestUser> testDao(){
       return testService.selectAll();
    }

    @GetMapping("/testDao1")
    public List<TestUser> testDao1(){
        return testService.selectAll1();
    }

    @GetMapping("/testAopAdd")
    public Integer testAopAdd(){
        return calculation.add(2,2);
    }

    @GetMapping("/testAopSub")
    public Integer testAopSub(){
        return calculation.sub(2,2);
    }

    @GetMapping("/testAopMul")
    public Integer testAopMul(){
        return calculation.mul(2,2);
    }

    @GetMapping("/testAopDiv")
    public Integer testAopDiv(){
        return calculation.div(2,0);
    }

}
