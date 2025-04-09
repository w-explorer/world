package com.explore.tcp.caibao1;
 
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 * @Author: cjian
 * @Date: 2023/6/5 14:27
 * @Des:
 */
public class Server1 {
 
    private static final int BYTE_LENGTH = 1024;  // 字节数组长度（收消息用）
 
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        // 获取到连接
        Socket clientSocket = serverSocket.accept();
        InputStream inputStream = clientSocket.getInputStream();
        while (true) {
            byte[] bytes = new byte[BYTE_LENGTH];
            try {
                // 读取客户端发送的信息
                int count = inputStream.read(bytes, 0, BYTE_LENGTH);
                if (count > 0) {
                    // 接收到消息打印
                    System.out.println("接收到客户端的信息是:" + new String(bytes).trim());
                }
                count = 0;
            } catch (Exception e) {
                // ignore
            }
        }
    }
}