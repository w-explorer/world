package com.explore.tcp.caibao2;
 
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
 
/**
 * @Author: cjian
 * @Date: 2023/6/5 15:36
 * @Des:
 */
public class SpecialCharClient {
    public static void main(String[] args) throws IOException {
        // 启动 Socket 并尝试连接服务器
        Socket socket = new Socket("127.0.0.1", 8888);
        final String message = "Hi,ChenJian."; // 发送消息
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        // 给服务器端发送 10 次消息
        for (int i = 0; i < 10; i++) {
            // 注意:结尾的 \n 不能省略,它表示按行写入
            bufferedWriter.write(message + "\n");
            // 刷新缓冲区(此步骤不能省略)
            bufferedWriter.flush();
        }
    }
}