package com.explore.tcp.zhanbao;
 
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
 
/**
 * @Author: cjian
 * @Date: 2023/6/5 10:20
 * @Des:
 */
public class Client {
    public static void main(String[] args) {
        // 定义服务器地址和端口
        String serverAddress = "127.0.0.1";
        int serverPort = 8888;
        // 定义发送的消息内容
        String message = "Hi,ChenJian.";
        // 定义发送消息的次数
        int messageCount = 10;

        try (Socket socket = new Socket(serverAddress, serverPort);
             OutputStream os = socket.getOutputStream()) {

            // 循环发送消息
            for (int i = 0; i < messageCount; i++) {
                os.write(message.getBytes());
            }

            System.out.println("All messages sent successfully.");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to send messages to the server.");
        }
    }
}