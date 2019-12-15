package com.sxjf.blog.web.controller.jy;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sxjf.blog.common.utils.CommonUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 测试请求OpenProject API V3接口
 */
@RestController
@RequestMapping("/rest/test")
@PropertySource({"openProject.yml"})
public class HttpTestController {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${op.url}")
    private String url;

    @Value("${op.importUrl}")
    private String importUrl;

    @Value("${op.username}")
    private String userName;

    @Value("${op.password}")
    private String passWord;

    /**
     * 导入
     */
    @GetMapping(value = "/import")
    public void testImport(){
        try {
            List<Data> dataList = importPackageFiles();
            if (dataList.size() != 0){
                for (Data data:dataList){
                    sendDataTwo(importPackageData(data));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析工作包yaml文件数据
     */
    public List<Data> importPackageFiles() throws Exception {
        Yaml yaml = new Yaml();
        File f = new File("D:\\test.yaml");
        Iterable<Object> result = null;
        List<Data> dataList = new ArrayList<>();
        result = yaml.loadAll(new FileInputStream(f));
        for (Object obj : result) {
            Data data = CommonUtil.mapToBean((Map)obj,Data.class);
            dataList.add(data);
        }
        return dataList;
    }

    /**
     * 封装新建工作包json串
     */
    public String importPackageData(Data data){
        Link _links = new Link();
        _links.setType(new HrefTitle(null,null,"/api/v3/types/1","Task"));
        _links.setPriority(new HrefTitle(null,null,"/api/v3/priorities/8","Normal"));
        _links.setProject(new HrefTitle(null,null,"/api/v3/projects/5","测试标题描述和入参vo和日期"));
        _links.setStatus(new HrefTitle(null,null,"/api/v3/statuses/1","New"));
        _links.setAuthor(new HrefTitle(null,null,"/api/v3/users/4","洋 汪"));
        _links.setParent(new HrefTitle(true,null,null,null));
        WorkSpace workSpace = new WorkSpace(0,data.getSubject(),new HrefTitle(null,data.getRaw(),null,null),data.getStartDate(),data.getDueDate(),null,0,null,_links);
        String jsonString = JSONObject.toJSONString(workSpace).replace("links","_links");
        return jsonString;
    }

    /**
     * 发送新建工作包请求
     */
    public void sendDataTwo(String data){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        requestHeaders.set("Authorization", getAuthHeader());
        HttpEntity<String> request = new HttpEntity<>(data, requestHeaders);
        restTemplate.postForEntity(url,request, JSONObject.class).getBody();
    }

    /**
     * 导出
     */
    @GetMapping(value = "/export")
    public void testExport(){
        try {
            exportPackageFile(exportPackageData(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取请求头参数
     */
    public String getAuthHeader(){
        String authString = userName + ":" + passWord;
        byte[] encodedAuth = Base64.encodeBase64(authString.getBytes(Charset.forName("utf-8")));
        String authHeader = "Basic " + new String(encodedAuth);
        return authHeader;
    }

    /**
     * 封装需导出工作包vo
     */
    public List<Data> exportPackageData(Data data) throws Exception{
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        requestHeaders.set("Authorization", getAuthHeader());
        HttpEntity<String> request = new HttpEntity<>(null, requestHeaders);
       JSONArray jsonArray = restTemplate.exchange(importUrl, HttpMethod.GET,request,JSONObject.class).getBody().getJSONObject("_embedded").getJSONArray("elements");
        System.out.println(jsonArray);
        List<Data> dataList = new ArrayList<>();
        for (int i = 0;i<jsonArray.size();i++){
             Data dataObj = CommonUtil.mapToBean((Map)jsonArray.get(i),Data.class);
             dataList.add(dataObj);
        }
        return dataList;
    }


    /**
     * CSV导出项目下工作包基本信息
     */
    public void exportPackageFile(List<Data> dataList) throws Exception{
        OutputStream out = new FileOutputStream("D:\\excel\\excel.xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        Sheet sheet1 = new Sheet(1, 0, Data.class);
        sheet1.setSheetName("sheet1");
        writer.write(dataList,sheet1);
        writer.finish();
    }

}
