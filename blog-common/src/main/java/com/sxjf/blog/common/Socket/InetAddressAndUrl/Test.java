package com.sxjf.blog.common.Socket.InetAddressAndUrl;

import java.net.InetAddress;
/**
 * Created with IntelliJ IDEA.
 * Description: InetAddress测试类
 * Author: wangyang
 * Date: 2019/9/28
 * Time: 22:21
 */
public class Test {

    public static void main(String[] args) {
        InetAddressInfo inetAddressInfo = new InetAddressInfo();
        InetAddress inetAddress = null;
        //inetAddress = inetAddressInfo.getLocalInetAddress();
        inetAddress = inetAddressInfo.getInetAddressByHostName("DESKTOP-E6Q8VJL");
        inetAddressInfo.printInetAddressInfo(inetAddress);
    }

}
