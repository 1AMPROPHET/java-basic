package Mysocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建DatagramSocket对象
        DatagramSocket ds = new DatagramSocket();

        String str = "Hello world";
        byte[] bytes = str.getBytes();
        InetAddress address = InetAddress.getByName("LAPTOP-811S5RM3");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        ds.send(dp);

        ds.close();
    }
}
