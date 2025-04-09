package com.explore.tcp.caibao1;
 
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
 
/**
 * @Author: cjian
 * @Date: 2023/6/5 14:28
 * @Des:
 */
public class Client1 {
    private static final int BYTE_LENGTH = 1024;  // 字节长度
 
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        final String message = "Hi,ChenJian."; // 发送消息
        OutputStream outputStream = socket.getOutputStream();
        // 将数据组装成定长字节数组
        byte[] bytes = new byte[BYTE_LENGTH];
        int idx = 0;
        for (byte b : message.getBytes()) {
            bytes[idx] = b;
            idx++;
        }
        // 给服务器端发送 10 次消息
        for (int i = 0; i < 10; i++) {
            outputStream.write(bytes, 0, BYTE_LENGTH);
        }
 
    }
}