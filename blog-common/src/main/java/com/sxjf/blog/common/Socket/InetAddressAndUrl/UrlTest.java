package com.sxjf.blog.common.Socket.InetAddressAndUrl;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * Description: URL测试类
 * Author: wangyang
 * Date: 2019/9/28
 * Time: 22:21
 */
public class UrlTest {

    public static void main(String[] args) {
        URLInfo urlInfo = new URLInfo();
        URL url = urlInfo.getURLByString("http://www.baidu.com");
        urlInfo.printf(url);
        urlInfo.readerByUrl(url);
    }

}
