package study.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by hellotree on 2017/10/22.
 *
 * @author by �ھӵĶ���
 */
public class saxDemo {
    public  static void main(String args[]) throws Exception{
       //����saxparser����
        SAXParser parser= SAXParserFactory.newInstance().newSAXParser();
        //2.����parse��������ȡ�ͽ���xml�ļ�
        File file=new File("./src/contact.xml");

        parser.parse(file, new MyDefaultHandler());
    }
}
