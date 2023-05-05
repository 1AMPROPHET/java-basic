package Mysocket.UDP_Demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        // 接收数据

        // 1.创建DatagramSocket
        DatagramSocket ds = new DatagramSocket(10086);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        // 该方法是阻塞的，程序会在这里等待
        ds.receive(dp);

        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println("Receive data" + new String(data, 0, len));
        System.out.println("Received from" + address + " address " + port + " port");

        ds.close();
    }
}
