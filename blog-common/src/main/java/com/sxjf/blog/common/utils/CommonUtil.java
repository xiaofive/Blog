package com.sxjf.blog.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Description: 常用工具类
 * Author: wangyang
 * Date: 2019/9/28
 * Time: 17:41
 */
public class CommonUtil {

    public boolean isIP(String addr)
    {
        if(addr.length() < 7 || addr.length() > 15 || "".equals(addr))
        {
            return false;
        }
        /**
         * 判断IP格式和范围
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(addr);

        boolean ipAddress = mat.find();

        return ipAddress;
    }

}
