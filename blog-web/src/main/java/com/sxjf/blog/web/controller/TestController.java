package com.sxjf.blog.web.controller;

import com.alibaba.fastjson.JSON;
import com.sxjf.blog.common.aspectJ.Calculation;
import com.sxjf.blog.entity.TestUser;
import com.sxjf.blog.service.TestService;
import com.sxjf.blog.web.es.Entity.sales.EsSalesOrderHeader;
import com.sxjf.blog.web.es.Entity.sales.EsSalesOrderLine;
import com.sxjf.blog.web.es.Entity.sales.EsUser;
import com.sxjf.blog.web.es.EsMapConfig;
import com.sxjf.blog.web.es.EsUtils;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private Calculation calculation;

    @Autowired
    RestHighLevelClient client;

    @Autowired
    RestClient restClient;


    @GetMapping("/welcome")
    public String test() {
        return "Welcome to My Blog!";
    }

    @GetMapping("/testService")
    public String testService() {
        return testService.test();
    }

    @GetMapping("/testDao")
    public List<TestUser> testDao() {
        return testService.selectAll();
    }

    @GetMapping("/testDao1")
    public List<TestUser> testDao1() {
        return testService.selectAll1();
    }

    @GetMapping("/testAopAdd")
    public Integer testAopAdd() {
        return calculation.add(2, 2);
    }

    @GetMapping("/testAopSub")
    public Integer testAopSub() {
        return calculation.sub(2, 2);
    }

    @GetMapping("/testAopMul")
    public Integer testAopMul() {
        return calculation.mul(2, 2);
    }

    @GetMapping("/testAopDiv")
    public Integer testAopDiv() {
        return calculation.div(2, 0);
    }

    @GetMapping("/testCache")
    public void testCache() {
        System.out.println(testService.testCache("cacheOne_key"));
    }

    @GetMapping("/testElasticsearchClient")
    public void testElasticsearch() {
        List<Class> classList = new ArrayList<>();
        classList.add(EsSalesOrderHeader.class);
        classList.add(EsSalesOrderLine.class);
        EsMapConfig.buildEsMapping(classList);
    }

    @GetMapping("/addDocument")
    public void addDocument() {
        EsSalesOrderHeader salesOrderHeader = new EsSalesOrderHeader();
        salesOrderHeader.setBalaTypeRefId("111");
        salesOrderHeader.setCxBillRefId("111");
        salesOrderHeader.setIncomeTerm("111");
        salesOrderHeader.setRecvCxRefId("111");
        EsSalesOrderHeader salesOrderHeader2 = new EsSalesOrderHeader();
        salesOrderHeader2.setBalaTypeRefId("222");
        salesOrderHeader2.setCxBillRefId("222");
        salesOrderHeader2.setIncomeTerm("222");
        salesOrderHeader2.setRecvCxRefId("222");
        try {
            EsUtils.createDocument("test_19","3", JSON.toJSONString(salesOrderHeader));
            EsUtils.createDocument("test_19","4", JSON.toJSONString(salesOrderHeader2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getDocument")
    public void getDocument() {
        try {
            String documentString1 = EsUtils.getDocument("test_19","3");
            System.out.println(documentString1);
            String documentString2 = EsUtils.getDocument("test_19", "4");
            System.out.println(documentString2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping
    public void buildMapping(){
        try {
            List<Class> classList = new ArrayList<>();
            classList.add(EsSalesOrderHeader.class);
            classList.add(EsSalesOrderLine.class);
            classList.add(EsUser.class);
            EsUtils.createIndex("test_29", "完善构建mapping", EsMapConfig.buildEsMapping(classList));
        } catch (Exception e) {
            System.out.println("---");
        }
    }

}
