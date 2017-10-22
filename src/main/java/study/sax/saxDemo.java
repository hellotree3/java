package study.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by hellotree on 2017/10/22.
 *
 * @author by 邻居的耳朵
 */
public class saxDemo {
    public  static void main(String args[]) throws Exception{
       //创建saxparser对象
        SAXParser parser= SAXParserFactory.newInstance().newSAXParser();
        //2.调用parse方法，读取和解析xml文件
        File file=new File("./src/contact.xml");

        parser.parse(file, new MyDefaultHandler());
    }
}
