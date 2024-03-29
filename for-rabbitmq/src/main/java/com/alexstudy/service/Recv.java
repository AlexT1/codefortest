package src.main.java.com.alexstudy.service;

import com.rabbitmq.client.*;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

/**
 * @author AlexTong
 * @ClassName Recv
 * @Description TODO()
 * @date 2018/1/22 16:29:05
 */
public class Recv {
    private final static String QUEUE_NAME = "testQueues";

    public static void main(String[] argv)
            throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws UnsupportedEncodingException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
