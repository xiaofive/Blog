package com.sxjf.blog.web.controller;

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

}
