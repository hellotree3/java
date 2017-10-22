import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Created by hellotree on 2017/10/22.
 * html 文件测试xpath
 * @author by 邻居的耳朵
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
        System.out.println("编号\t姓名\t性别\t年龄\t地址\t\t电话");
        //获取行信息
        List<Element> trs=(List<Element>) doc.selectNodes("//tbody/tr");
        //每一行 逐个打印单元格数据
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
