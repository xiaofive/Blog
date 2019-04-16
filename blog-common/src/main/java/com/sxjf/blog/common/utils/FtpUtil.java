//package com.sxjf.blog.common.utils;
//
//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;
//import org.apache.commons.net.ftp.FTPFile;
//import org.apache.commons.net.ftp.FTPReply;
//import java.io.*;
//
///**
// * @Author: kdafang[1176776058@qq.com]
// * @Date: 2019-2-19 10:02
// */
//public class FtpUtil {
//        public static boolean uploadFile(String host,int port,String username,String password,String basePath,
//                                         String filePath,String fileName,InputStream input){
//            boolean result = false;
//            FTPClient ftp = new FTPClient();
//            int reply;
//            try {
//                ftp.connect(host, port); //连接FTP服务器
//                //如果采用默认端口,可以使用ftp.connect(host)的方式直接连接FTP服务器
//                ftp.login(username, password);
//                reply = ftp.getReplyCode();//获取一个数字码,通过这个数字码来判断是否登录成功；登陆失败直接断开连接,返回false
//                if(!FTPReply.isPositiveCompletion(reply)){
//                    ftp.disconnect();//断开连接
//                    return result;
//                }
//                //切换到上传目录
//                if(!ftp.changeWorkingDirectory(basePath+filePath)){
//                    //如果目录不存在就创建目录
//                    String [] dirs = filePath.split("/");// 2017/03/29/
//                    String tempPath = basePath;
//                    for(String dir : dirs){
//                        if(null == dir || "".equals(dir)) {
//                            continue;
//                        }
//                            tempPath += "/" + dir;
//
//                        if(!ftp.changeWorkingDirectory(tempPath)){
//                            if(!ftp.makeDirectory(tempPath)){
//                                return result;
//                            }else{
//                                System.out.println(tempPath);
//                                ftp.changeWorkingDirectory(tempPath);
//                            }
//                        }
//                    }
//                }
//
//                //设置上传文件的类型为二进制类型
//                ftp.setFileType(FTP.BINARY_FILE_TYPE);
//                //上传文件
//                if(!ftp.storeFile(fileName, input)){
//                    return result;
//                }
//                input.close();
//                ftp.logout();//ftp用户退出
//                result = true;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return result;
//        }
//
//
//        /**
//         * Description: 从FTP服务器下载文件
//         *
//         * @param host
//         *            FTP服务器hostname
//         * @param port
//         *            FTP服务器端口
//         * @param username
//         *            FTP登录账号
//         * @param password
//         *            FTP登录密码
//         * @param remotePath
//         *            FTP服务器上的相对路径
//         * @param fileName
//         *            要下载的文件名
//         * @param localPath
//         *            下载后保存到本地的路径
//         * @return
//         */
//        public static boolean downloadFile(String host, int port, String username, String password, String remotePath,
//                                           String fileName, String localPath) {
//            boolean result = false;
//            FTPClient ftp = new FTPClient();
//            try {
//                int reply;
//                ftp.connect(host, port);
//                // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
//                ftp.login(username, password);// 登录
//                reply = ftp.getReplyCode();
//                if (!FTPReply.isPositiveCompletion(reply)) {
//                    ftp.disconnect();
//                    return result;
//                }
//                ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
//                FTPFile[] fs = ftp.listFiles();
//                for (FTPFile ff : fs) {
//                    if (ff.getName().equals(fileName)) {
//                        File localFile = new File(localPath + "/" + ff.getName());
//
//                        OutputStream is = new FileOutputStream(localFile);
//                        ftp.retrieveFile(ff.getName(), is);
//                        is.close();
//                    }
//                }
//
//                ftp.logout();
//                result = true;
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if (ftp.isConnected()) {
//                    try {
//                        ftp.disconnect();
//                    } catch (IOException ioe) {
//                    }
//                }
//            }
//            return result;
//        }
//
//        public static void main(String[] args) throws Exception {
//
//                FileInputStream in = new FileInputStream(new File("D:\\3.png"));
//                boolean flag = uploadFile("59.218.32.22", 201, "xys_wlsj", "xys_wlsj@610400", "/2",
//                        "/2", "3.png", in);
//                System.out.println(flag);
//
//        }
//    }