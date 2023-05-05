package Mysocket.TCP.Demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("LAPTOP-811S5RM3", 10000);
        OutputStream os = socket.getOutputStream();

        os.write("Hello".getBytes());

        os.close();
        socket.close();
    }
}
