package com.learn.word.rocketmq.general;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;


public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        // 创建一个producer，参数为Producer Group名称
        DefaultMQProducer producer = new DefaultMQProducer("pg");
        // 指定nameServer地址
        producer.setNamesrvAddr("J2EE:9876");
        // 设置异步发送，当消息发送失败后重试0次
        producer.setRetryTimesWhenSendAsyncFailed(0);
        // 设置发送超时时限为5s，默认3s
        producer.setSendMsgTimeout(5000);

        //设置queue队列数量为2
        producer.setDefaultTopicQueueNums(2);

        // 开启生产者
        producer.start();

        // 生产并发送100条消息
        for (int i = 0; i < 100; i++) {
            byte[] body = ("Hi," + i).getBytes();
            Message msg = new Message("asyncTopicA", "asyncTag", body);
            // 为消息指定key
            msg.setKeys("key-" + i);
            // 同步发送消息
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult);
                }

                @Override
                public void onException(Throwable throwable) {

                }
            });

        }
        TimeUnit.SECONDS.sleep(3);
        // 关闭producer
        producer.shutdown();
    }
}
