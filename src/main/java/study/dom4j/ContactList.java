package study.dom4j;

import entity.Contact;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hellotree on 2017/10/15.
 * 最终把contact.xml中的contact数据转换成对象列表
 * @author by 邻居的耳朵
 * @Begin 2017/10/15.
 */
public class ContactList {
    public static void main(String args[]) throws DocumentException,IOException{
       //创建XML解析对象，并读取XML文件
        SAXReader saxReader=new SAXReader();
        Document doc= saxReader.read("./src/contact.xml");
        //创建contact对象列表
        List<Contact> contactList=new ArrayList<Contact>();
        //获取contact节点，封装成对象
        List<Element> list=new ArrayList<Element>();
        Element rootElem=doc.getRootElement();
        list=rootElem.elements("contact");
        //封装对象
        for(Element e:list){
            Contact con=new Contact();
            con.setId(e.attributeValue("id"));
            con.setName(e.elementText("name"));
            con.setSex(e.elementText("sex"));
            con.setTelephone(e.elementText("telephone"));
            con.setQq(e.elementText("qq"));
            con.setEmail(e.elementText("email"));
            contactList.add(con);
        }
        //遍历contact对象列表
        for(Contact c:contactList){
            System.out.println(c);
        }
        //获取第一个contact标签下的子节点
        Iterator<Element> conSon= rootElem.element("contact").elementIterator();
        //打印所有子节点信息
        while (conSon.hasNext()){
            Element e=conSon.next();
            System.out.println(e.getName()+":"+e.getText());
        }
       //创建输出流
        OutputStream os=new FileOutputStream("./src/contactCopy.xml");
        //创建输出格式
        OutputFormat format=OutputFormat.createCompactFormat();//紧凑的格式。去掉空格换行
       // OutputFormat format=OutputFormat.createPrettyPrint();//漂亮的格式。格式化的语句展示
        // 创建输出对象
        XMLWriter xmlWriter=new XMLWriter(os,format);
        //写数据到文件中
        xmlWriter.write(doc);

    }
}
