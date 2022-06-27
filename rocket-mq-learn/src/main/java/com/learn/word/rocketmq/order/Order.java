package com.learn.word.rocketmq.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wencheng
 * @create 2022/6/22 21:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private int id;

    private String status;

    private String info;
}
