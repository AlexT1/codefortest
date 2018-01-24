package src.main.java.com.alexstudy.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @author AlexTong
 * @ClassName Send
 * @Description TODO()
 * @date 2018/1/22 16:05:54
 */
public class Send {
    private final static String QUEUE_NAME = "testQueues";

    public static void main(String[] argv) throws IOException, TimeoutException {
        Date timebefore10min = org.apache.commons.lang.time.DateUtils.addMinutes(new Date(), -10);
        System.out.println("time :" + timebefore10min);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World for test!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
