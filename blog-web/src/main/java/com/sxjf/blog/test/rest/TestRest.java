package com.sxjf.blog.test.rest;

import com.sxjf.blog.test.entity.User;
import com.sxjf.blog.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class TestRest {

    @Autowired
    private TestService testService;
//
//    @Autowired
//    private Calculation calculation;

    @GetMapping("/welcome")
    public String test() {
        return "Welcome to My Blog!";
    }

    @GetMapping("/testService")
    public User testService() {
        return testService.test();
    }
//
//    @GetMapping("/testAopAdd")
//    public Integer testAopAdd() {
//        return calculation.add(2, 2);
//    }
//
//    @GetMapping("/testAopSub")
//    public Integer testAopSub() {
//        return calculation.sub(2, 2);
//    }
//
//    @GetMapping("/testAopMul")
//    public Integer testAopMul() {
//        return calculation.mul(2, 2);
//    }
//
//    @GetMapping("/testAopDiv")
//    public Integer testAopDiv() {
//        return calculation.div(2, 0);
//    }

}
