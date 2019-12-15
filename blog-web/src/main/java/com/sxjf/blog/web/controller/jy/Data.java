package com.sxjf.blog.web.controller.jy;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * Created with IntelliJ IDEA.
 * Description: 用来接收yaml文件信息
 * Author: wangyang
 * Date: 2019/10/6
 * Time: 19:18
 */
public class Data extends BaseRowModel {

    @ExcelProperty(index = 0 , value = "工作包名称")
    private String subject;
    @ExcelProperty(index = 1 , value = "工作包描述")
    private String raw;
    @ExcelProperty(index = 2 , value = "开始时间")
    private String startDate;
    @ExcelProperty(index = 3 , value = "结束时间")
    private String dueDate;

    public Data() {
    }

    public Data(String subject, String raw, String startDate, String dueDate) {
        this.subject = subject;
        this.raw = raw;
        this.startDate = startDate;
        this.dueDate = dueDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
