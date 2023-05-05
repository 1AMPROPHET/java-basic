package Mysocket.CharRoom;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Sender {
    public static void main(String[] args) throws IOException {
        /*
        UDP发送数据，数据来源于键盘录入，知道输入的数据是886，发送数据结束
        UDP接收数据，因为接收端不知道发送端什么时候停止发送，故采用死循环接收
         */

        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your word:");
            String str = sc.nextLine();
            if (str.equals("886")) break;
            byte[] bytes = str.getBytes();

            InetAddress address = InetAddress.getByName("LAPTOP-811S5RM3");
            int port = 10086;
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
            ds.send(dp);
        }

        ds.close();
    }
}
