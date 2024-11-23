package EXERCISE.miniProject.mini24;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象
        //细节：在创建对象同时连接服务端 如果连接不上 代码就会报错
        Socket socket = new Socket("127.0.0.1", 100);//三次握手协议确保连接

        //2.可以从连接通道获取输出流->写出数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("哈哈哈 aaa".getBytes());

        //3.释放资源
        //io流是在传输通道Socket里面的 只要 Socket关闭了 io流自然也会关闭
        //所以关闭io流的代码不是必要的
        outputStream.close();
        socket.close();//四次挥手协议确保断开
    }
}
