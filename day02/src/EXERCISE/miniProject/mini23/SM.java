package EXERCISE.miniProject.mini23;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//组播发送数据的代码和单播唯一的不同就是
//包装数据用的是MulticastSocket对象
public class SM {
    public static void main(String[] args) throws IOException {
        MulticastSocket ms = new MulticastSocket();

        String s = "地球的所有生物，你们好！";
        byte[] buf = s.getBytes();

        InetAddress group = InetAddress.getByName("224.0.0.1");
        int port = 100;
        DatagramPacket dp = new DatagramPacket(buf, buf.length, group, port);

        ms.send(dp);

        ms.close();
    }
}
