package study.dom4j;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Created by hellotree on 2017/10/15.
 *
 * @author by �ھӵĶ���
 * @Begin 2017/10/15.
 */
public class dom4jDemo {
    public  static void main(String args[]) throws DocumentException {
        //1������XML����������
        SAXReader saxReader=new SAXReader();
        //��ȡXML�ļ�
        Document doc=saxReader.read(new File("./src/contact.xml"));
        //��ȡ����ǩ
        Element rootElem= doc.getRootElement();
        //��ȡ�ӱ�ǩ
//        Element conElem=rootElem.element("contact"); //��һ���ӱ�ǩ
//        System.out.println(conElem.getName());
        //��ȡ�����ӱ�ǩ
//        List<Element> list=rootElem.elements("contact");
//        //���������ӱ�ǩ
//        for(Element e:list){
//            System.out.println(e.getName());
//        }
        //������ʵ��
//        Iterator<Element> it=list.iterator();
//        while(it.hasNext()){
//            Element e=it.next();
//            System.out.println(e.getName());
//        }
        //��ȡ���б�ǩ����ָ�����ƣ�
        List<Element> allElem=rootElem.elements();
//        for(Element e:allElem){
//            System.out.println(e.getName());
//        }
        //ע�⣬�����ȥȡ��ڵ�
        Element nameElem=rootElem.element("contact").element("name");
        //ע�⣺xml�еĿո��лᱻ��ȡ��text�С�
        System.out.println(nameElem.getText());
        Element conElem2=(Element)rootElem.elements("contact").get(1);
        //��ȡ����
        //����1.ֱ�ӻ�ȡ����ֵ
        String idValue=conElem2.attributeValue("cid");
        System.out.println(idValue);
        //����2���Ȼ�ȡ���ԣ��ٻ�ȡ���Զ����ٻ�ȡ���Ե�����
        Attribute idAtr=conElem2.attribute("cid");
        //��ӡ����ֵ
        System.out.println(idAtr.getName()+":"+idAtr.getValue());
        //��ȡ��ǩ����������
        List<Attribute> allAtrr=conElem2.attributes();
        for(Attribute at:allAtrr){
            System.out.println(at.getName()+" "+at.getValue());
        }

    }
}
