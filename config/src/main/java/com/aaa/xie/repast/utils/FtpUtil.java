package com.aaa.xie.repast.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2020/3/17 10:06
 * @Description
 **/
public class FtpUtil {

    public static Boolean uploadFile(String host, int port, String username, String password, String basePath,
                                     String filePath, String filename, InputStream input) throws IOException {
        // 1.创建临时路径
        String tempPath = "";
        // 2.创建FTPClient对象(对于连接ftp服务器，以及上传和下载都必须要用到的一个对象)
        FTPClient ftp = new FTPClient();
        try {
            // 3.定义返回的状态码
            int reply;
            // 4.连接ftp(当前项目所部署的服务器和ftp服务器之间可以相互通讯，叫做连接成功)
            ftp.connect(host, port);
            // 5.输入账号和密码进行登录
            ftp.login(username, password);
            // 6.接收状态码(如果成功，返回230，如果失败返回503/530)
            reply = ftp.getReplyCode();
            // 7.根据状态码检测ftp的连接，调用isPositiveCompletion(reply)-->如果连接成功返回true，否则返回false
            if (!FTPReply.isPositiveCompletion(reply)) {
                // 说明连接失败，需要断开连接
                ftp.disconnect();
                return false;
            }
            // 8.changeWorkingDirectory(linux上的文件夹路径):检测所传入的目录是否存在，如果存在返回true，如果不存在返回false
            // basePath+filePath-->home/ftp/www/2019/08/31
            if (!ftp.changeWorkingDirectory(basePath + filePath)) {
                // 9.截取filePath:2019/08/31-->String[]:2019,08,31
                String[] dirs = filePath.split("/");
                // 10.把basePath(/home/ftp/www)-->tempPath
                tempPath = basePath;
                for (String dir : dirs) {
                    // 11.循环数组(第一次循环-->2019)
                    if (null == dir || StringUtil.isEmpty(dir))
                        continue; // 跳出本地循环，进入下一次循环
                    // 12.更换临时路径:/home/ftp/www/2019
                    tempPath += "/" + dir;
                    // 13.再次检测路径是否存在(/home/ftp/www/2019)-->返回为false，说明路径不存在
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        // 14.makeDirectory():创建目录 返回的是Boolean类型 如果创建成功返回true，否则返回false
                        if (!ftp.makeDirectory(tempPath)) {
                            return false;
                        } else {
                            // 15.严谨判断(重新检测路径是否真的存在(检测是否创建成功))
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            // 16.把文件转换为二进制字符流的形式进行上传
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 17.这才是真正上传方法storeFile(filename, input)，返回Boolean类型 如果上传成功返回true，否则返回false
            if (!ftp.storeFile(filename, input)) {
                return false;
            }
            // 18.关闭输入流
            input.close();
            // 19.退出ftp
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        } finally {
            if (ftp.isConnected()) {
                try {
                    // 20.断开ftp的连接
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return true;
    }

}
