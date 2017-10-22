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
 * ���հ�contact.xml�е�contact����ת���ɶ����б�
 * @author by �ھӵĶ���
 * @Begin 2017/10/15.
 */
public class ContactList {
    public static void main(String args[]) throws DocumentException,IOException{
       //����XML�������󣬲���ȡXML�ļ�
        SAXReader saxReader=new SAXReader();
        Document doc= saxReader.read("./src/contact.xml");
        //����contact�����б�
        List<Contact> contactList=new ArrayList<Contact>();
        //��ȡcontact�ڵ㣬��װ�ɶ���
        List<Element> list=new ArrayList<Element>();
        Element rootElem=doc.getRootElement();
        list=rootElem.elements("contact");
        //��װ����
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
        //����contact�����б�
        for(Contact c:contactList){
            System.out.println(c);
        }
        //��ȡ��һ��contact��ǩ�µ��ӽڵ�
        Iterator<Element> conSon= rootElem.element("contact").elementIterator();
        //��ӡ�����ӽڵ���Ϣ
        while (conSon.hasNext()){
            Element e=conSon.next();
            System.out.println(e.getName()+":"+e.getText());
        }
       //���������
        OutputStream os=new FileOutputStream("./src/contactCopy.xml");
        //���������ʽ
        OutputFormat format=OutputFormat.createCompactFormat();//���յĸ�ʽ��ȥ���ո���
       // OutputFormat format=OutputFormat.createPrettyPrint();//Ư���ĸ�ʽ����ʽ�������չʾ
        // �����������
        XMLWriter xmlWriter=new XMLWriter(os,format);
        //д���ݵ��ļ���
        xmlWriter.write(doc);

    }
}
