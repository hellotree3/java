import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Created by hellotree on 2017/10/22.
 * html �ļ�����xpath
 * @author by �ھӵĶ���
 */
public class PersonTest {
    public  static void main(String args[]) throws DocumentException{
        Document doc=new SAXReader().read("./src/personList.html");
        Element rootHtml=doc.getRootElement();
        String title=rootHtml.element("head").elementText("title");
        System.out.println(title);
//        Element  tableHeader=(Element) doc.selectSingleNode("//body/center/h1");
//        String tableTitle=tableHeader.getText();
//        System.out.println(tableTitle);
        System.out.println("���\t����\t�Ա�\t����\t��ַ\t\t�绰");
        //��ȡ����Ϣ
        List<Element> trs=(List<Element>) doc.selectNodes("//tbody/tr");
        //ÿһ�� �����ӡ��Ԫ������
        for(Element tr:trs){
          String id=tr.selectSingleNode("td[1]").getText();
            String name=tr.selectSingleNode("td[2]").getText();
            String gender=tr.selectSingleNode("td[3]").getText();
            String age=tr.selectSingleNode("td[4]").getText();
            String address=tr.selectSingleNode("td[5]").getText();
            String phone=tr.selectSingleNode("td[6]").getText();
            System.out.println(id+"\t"+name+"\t"+gender+"\t"+age+"\t"+address+"\t"+phone);
        }

    }
}
