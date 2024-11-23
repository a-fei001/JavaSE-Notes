package EXERCISE.miniProject.mini22;

import java.io.IOException;
import java.net.*;

public class SendMessage {
    public static void main(String[] args) throws IOException {
        //1.找快递站
        //创建DatagramSocket对象 细节：可以传递参数(端口数) 也可以不传递
        //                          传递了->按指定端口号绑定
        //                          没传递->从可用的端口号中随机找一个传递
        DatagramSocket ds = new DatagramSocket();

        //这是要发送的数据
        String s = "舒源好帅我好爱";
        byte[] bytes = s.getBytes();

        //2.打包数据
        //传递给本机
        InetAddress address = InetAddress.getByName("127.0.0.1");
        //ctrl+p 查看需要传递的参数类型(这里port表示传递给对面设备的port端口)
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, 10086);

        //3.快递站发送数据
        ds.send(dp);

        //4.付钱走人
        ds.close();

    }
}
