package study.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hellotree on 2017/10/22.
 *
 * @author by 邻居的耳朵
 */
public class MyServer {
    public  static void main(String args[]) throws IOException{
        //创建服务器
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("服务器正在启动。。。");
        //创建客户端
        Socket socket=serverSocket.accept();
        //
        OutputStream os=socket.getOutputStream();
        FileInputStream fis=new FileInputStream("./src/personList.html");
        //边读边写
//        int len=0;
//        while ((len=fis.read())!=-1){
//            os.write(len);
//        }
       //使用字符数组
        byte[] buf=new byte[1024];
        int le=0;
        while((le=fis.read(buf))!=-1){
            os.write(buf,0,le); //从0到le长度的数组
        }
        os.close();
        fis.close();
    }
}
