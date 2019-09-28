package com.sxjf.blog.common.Socket.InetAddressAndUrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * Description: URL类常用方法
 * Author: wangyang
 * Date: 2019/9/28
 * Time: 18:31
 */
public class URLInfo {

    /**
     * 根据资源字符串创建URL实例
     */
    public URL getURLByString(String url){
        URL baidu = null;
        URL url1 = null;
        try {
            baidu = new URL(url);
            //可以根据已存在的url实例创建一个新的url实例
            //?后面表示的是参数，#后面表示的是锚点
            url1 = new URL(baidu,"/index.html?username=wangyang#test");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url1;
    }
    /**
     * 打印URL实例的协议，主机，端口,文件路径，文件名，相对路径
     */
    public void printf(URL url){
        System.out.println("协议：" + url.getProtocol());
        System.out.println("主机：" + url.getHost());
        //如果创建URL实例时未指定端口号，那么使用默认端口号，此时getPort()方法返回值为-1
        System.out.println("端口：" + url.getPort());
        System.out.println("文件路径:" + url.getPath());
        System.out.println("文件名：" + url.getFile());
        System.out.println("相对路径：" + url.getRef());
        System.out.println("查询字符串：" + url.getQuery());
    }
    /**
     * 通过输入流可以读取，访问网络上的数据
     * 使用URL读取网页内容
     */
    public void readerByUrl(URL url){
        try {
            //通过URL对象的openStream()方法可以得到指定资源的输入流
            InputStream inputStream = url.openStream();
            //将字节输入流转换为字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"gb2312");
            //为字符输入流添加缓冲
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data = bufferedReader.readLine();
            while(null != data){//循环读取数据
                System.out.println(data);//输出数据
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
