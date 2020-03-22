package com.sxjf.blog.common.Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description: 客户端端Socket
 * Author: wangyang
 * Date: 2019/10/8
 * Time: 19:18
 */
public class Client {

//    public static void main(String[] args) {
//        try {
//            //1.创建客户端Socket，指定服务i其地址和端口
//            Socket socket = new Socket("localhost",8888);
//            //2.获取输出流，向服务器端发送信息
//            OutputStream outputStream = socket.getOutputStream();//字节输出流
//            PrintWriter pw = new PrintWriter(outputStream);//将输出流包装为打印流
//            pw.write("用户名：wangyang;密码：qq141414");
//            pw.flush();
//            socket.shutdownOutput();//关闭输出流
//            //3.关闭资源
//            pw.close();
//            outputStream.close();
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
