package EXERCISE.miniProject.mini23;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class RM2 {
    public static void main(String[] args) throws IOException {

        //端口号100必须和发送数据的端口号对的上
        MulticastSocket ms = new MulticastSocket(100);

        //将本机添加到224.0.0.1这一组当中
        //(这是和前面代码有区别的地方 因为前面是发送给本机 不用添加了)
        InetAddress group = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(group);

        byte[] b1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b1, b1.length);

        ms.receive(dp);

        byte[] data = dp.getData();
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();

        System.out.println("ip为" + address.getHostAddress() + " 主机名为" + address.getHostName() + "的人 从" + port + "端口"
                + " 发来了数据：" + new String(data, 0, len));

        ms.close();
    }
}
