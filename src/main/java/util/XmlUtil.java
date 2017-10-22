package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by hellotree on 2017/10/16.
 * ��xml�ļ���ͨ�õĲ���������ȡ����
 * @author by �ھӵĶ���
 */
public class XmlUtil {
    /**
     * ��ȡxml�ļ�������document����
     * @return
     */
    public static Document getDocument(){
        try{
            Document doc=new SAXReader().read("./src/contact.xml");
            return  doc;
        }catch (DocumentException e){
            e.printStackTrace();
            throw  new RuntimeException();
        }
    }

    /**
     * ����doc����д��xml�ļ���
     * @param doc
     */
    public static void writeToXml(Document doc){
        try {
            OutputStream out=new FileOutputStream("./src/contact.xml");
            OutputFormat format=OutputFormat.createCompactFormat();
            XMLWriter writer=new XMLWriter(out,format);
            writer.write(doc);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
