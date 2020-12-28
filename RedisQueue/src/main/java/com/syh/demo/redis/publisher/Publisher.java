package com.syh.demo.redis.publisher;

import com.syh.demo.redis.queue.MyJedisFactory;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * 消息发布方
 *
 * @author hsy
 * @date 2020/12/28
 */
public class Publisher {

    public static final String CHANNEL_KEY = "channel:message";
    private final Jedis jedis;

    public Publisher() {
        jedis = MyJedisFactory.getJedis();
    }

    public void publishMessage(String message) {
        if (message.length() <= 0) {
            return;
        }
        jedis.publish(CHANNEL_KEY, message);
    }

    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        try {
            int i = 0;
            while (true) {
                publisher.publishMessage("Hello Redis!" + (++i));
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (InterruptedException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
