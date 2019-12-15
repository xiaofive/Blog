package com.sxjf.blog.common.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description: 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 * Author: wangyang
 * Date: 2019/9/28
 * Time: 22:44
 */
public class Server {

    /**
     * 创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
     */
    public void init(){
        try {
            //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            //2.调用accept()方法开始监听，等待客户端的连接
            System.out.println("服务器已启动，等待客户端的连接...");
            Socket socket = serverSocket.accept();
            //3.获取输入流，读取客户端信息
            InputStream inputStreamReader = socket.getInputStream();//字节输入流
            InputStreamReader inputStreamReader1 = new InputStreamReader(inputStreamReader);//将字节流转换为字符流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader1);//为输入流添加缓冲
            String data = null;
            while ((data = bufferedReader.readLine()) != null){//循环读取客户端信息
                System.out.println("我是服务器，客户端说：" + data);
            }
            socket.shutdownInput();//关闭输入流
            //4.关闭资源
            bufferedReader.close();
            inputStreamReader1.close();
            inputStreamReader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }

}
