package study.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hellotree on 2017/10/22.
 *
 * @author by �ھӵĶ���
 */
public class MyServer {
    public  static void main(String args[]) throws IOException{
        //����������
        ServerSocket serverSocket=new ServerSocket(9999);
        System.out.println("��������������������");
        //�����ͻ���
        Socket socket=serverSocket.accept();
        //
        OutputStream os=socket.getOutputStream();
        FileInputStream fis=new FileInputStream("./src/personList.html");
        //�߶���д
//        int len=0;
//        while ((len=fis.read())!=-1){
//            os.write(len);
//        }
       //ʹ���ַ�����
        byte[] buf=new byte[1024];
        int le=0;
        while((le=fis.read(buf))!=-1){
            os.write(buf,0,le); //��0��le���ȵ�����
        }
        os.close();
        fis.close();
    }
}
