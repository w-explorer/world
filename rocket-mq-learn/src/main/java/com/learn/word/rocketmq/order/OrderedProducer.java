package com.learn.word.rocketmq.order;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.context.annotation.Scope;

import java.util.List;

/**
 * 顺序消息
 *
 * 消费消息按照消息的发送顺序消费
 *
 * 例如订单状态--未支付-已支付-发货中-发货成功-发货失败。
 *
 * 分区有序：
 * 即：同样的订单的消息写入一个queue中。发送消息时可以自定义选择算法。
 *
 * 全局有序：
 * 一个topic只有一个queue。
 */
public class OrderedProducer {

    private static DefaultMQProducer producer = new DefaultMQProducer("pg");
    public static void main(String[] args) throws Exception {
        producer = new DefaultMQProducer("pg");
        producer.setNamesrvAddr("J2EE:9876");

        // 若为全局有序，则需要设置Queue数量为1
        // producer.setDefaultTopicQueueNums(1);

        producer.start();

        for (int i = 0; i < 10; i++) {
            // 为了演示简单，使用整型数作为orderId
            Integer orderId = i;
            Order body = new Order();
            body.setId(orderId);
            // send()的第三个参数值会传递给选择器的select()的第三个参数
            // 该send()为同步发送
            body.setStatus("未支付");
            SendResult sendResult1 = send("OrderTopicA", "TagA", body,orderId);
            System.out.println(sendResult1);

            body.setStatus("已支付");
            SendResult sendResult2 = send("OrderTopicA", "TagA", body,orderId);
            System.out.println(sendResult2);

            body.setStatus("发货中");
            SendResult sendResult3 = send("OrderTopicA", "TagA", body,orderId);
            System.out.println(sendResult3);

            body.setStatus("发货成功");
            SendResult sendResult4 = send("OrderTopicA", "TagA", body,orderId);
            System.out.println(sendResult4);

        }
        producer.shutdown();
    }

    private static SendResult send(String topic, String tag, Object body,Object arg) throws Exception {

        MyMessageQueueSelector myMessageQueueSelector = MyMessageQueueSelector.getInstance();
        return producer.send(new Message(topic, tag, JSON.toJSONString(body).getBytes()), myMessageQueueSelector, arg);
    }
}

class MyMessageQueueSelector implements MessageQueueSelector{

    private static class Inner{
        private static final MyMessageQueueSelector instance = new MyMessageQueueSelector();
    }

    public static MyMessageQueueSelector getInstance(){
        return Inner.instance;
    }

    @Override
    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
        // 以下是使用消息key作为选择的选择算法
        String keys = arg.toString();
        Integer id = Integer.valueOf(keys);

        // 以下是使用arg作为选择key的选择算法
        // Integer id = (Integer) arg;

        int index = id % mqs.size();
        return mqs.get(index);
    }
}
