package com.sxjf.blog.common.Socket.InetAddressAndUrl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: Java中InetAddress类。
 * Author: wangyang
 * Date: 2019/9/28
 * Time: 16:47
 */
public class InetAddressInfo {

    /**
     * 获取本机InetAddress实例
     */
    public InetAddress getLocalInetAddress(){
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return inetAddress;
    }
    /**
     * 根据机器名或主机的IP地址获取InetAddress实例
     */
    public InetAddress getInetAddressByHostName(String hostName){
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(hostName);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return inetAddress;
    }
    /**
     * 打印计算机名，IP地址，数组形式的IP
     */
    public void printInetAddressInfo(InetAddress inetAddress){
        System.out.println("计算机名：" + inetAddress.getHostName()); //如果DNS不允许通过IP地址得到域名，那么这个方法就会返回IP地址来代替域名。
        System.out.println("IP地址：" + inetAddress.getHostAddress());
        byte[] bytes = inetAddress.getAddress();//获取字节数组形式的IP地址
        System.out.println("字节数组形式的IP：" + Arrays.toString(bytes));
        System.out.println(inetAddress.getCanonicalHostName()); //如果DNS不允许通过IP地址得到域名，那么这个方法就会返回IP地址来代替域名。
    }

}
