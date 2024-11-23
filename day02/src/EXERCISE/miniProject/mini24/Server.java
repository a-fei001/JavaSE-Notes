package EXERCISE.miniProject.mini24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建ServerSocket对象(注意port 100要对应上)
        ServerSocket serverSocket = new ServerSocket(100);

        //2.监听客户端的链接
        Socket socket = serverSocket.accept();

        //3.从连接通道获取输入流 读取数据
        InputStream inputStream = socket.getInputStream();
        //用转换流 解决无法读取中文数据的问题
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //用缓冲流 设置缓冲区 提高效率
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int b;
        while ((b = bufferedReader.read()) != -1) {
            System.out.print((char) b);
        }

        //4.释放资源
        socket.close();
        serverSocket.close();
    }
}
