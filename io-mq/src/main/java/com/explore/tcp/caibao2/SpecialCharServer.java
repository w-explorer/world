package com.explore.tcp.caibao2;
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 * @Author: cjian
 * @Date: 2023/6/5 15:00
 * @Des:
 */
public class SpecialCharServer {
    public static void main(String[] args) throws IOException {
        // 创建 Socket 服务器端
        ServerSocket serverSocket = new ServerSocket(8888);
        // 获取客户端连接
        Socket clientSocket = serverSocket.accept();
        while (true) {
            try {
                // 获取客户端发送的消息流对象
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                while (true) {
                    // 按行读取客户端发送的消息
                    String msg = bufferedReader.readLine();
                    if (msg != null) {
                        // 成功接收到客户端的消息并打印
                        System.out.println("接收到客户端的信息:" + msg);
                    }
                }
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
                break;
            }
        }
    }
}