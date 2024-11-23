package EXERCISE.miniProject.mini22;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ReceiveMessage {
    public static void main(String[] args) throws IOException {
        //1.找到快递站
        //细节：一定要绑定端口 port与发送数据的port保持一致
        DatagramSocket ds = new DatagramSocket(10086);

        //2.准备接收数据的数据包
        byte[] b1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b1, b1.length);

        //3.接收数据
        //该方法是阻塞的 程序运行到这里时 会在这里死等
        //等发送端发送数据
        ds.receive(dp);

        //4.解析数据
        byte[] data = dp.getData();//注意 这里get的对象是之前准备数据包的DatagramPacket对象
        int len = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        System.out.println("从" + address + "设备的" + port + "端口接收到了数据");
        System.out.println("数据为 " + new String(data,0,len));
        System.out.println(len);
        //5.付钱走人
        ds.close();
    }
}
