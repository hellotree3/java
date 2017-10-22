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
 * @author by 邻居的耳朵
 * @Begin 2017/10/15.
 */
public class dom4jDemo {
    public  static void main(String args[]) throws DocumentException {
        //1）创建XML解析器对象
        SAXReader saxReader=new SAXReader();
        //读取XML文件
        Document doc=saxReader.read(new File("./src/contact.xml"));
        //获取根标签
        Element rootElem= doc.getRootElement();
        //获取子标签
//        Element conElem=rootElem.element("contact"); //第一个子标签
//        System.out.println(conElem.getName());
        //获取所有子标签
//        List<Element> list=rootElem.elements("contact");
//        //遍历所有子标签
//        for(Element e:list){
//            System.out.println(e.getName());
//        }
        //迭代器实现
//        Iterator<Element> it=list.iterator();
//        while(it.hasNext()){
//            Element e=it.next();
//            System.out.println(e.getName());
//        }
        //获取所有标签（不指定名称）
        List<Element> allElem=rootElem.elements();
//        for(Element e:allElem){
//            System.out.println(e.getName());
//        }
        //注意，等逐层去取孙节点
        Element nameElem=rootElem.element("contact").element("name");
        //注意：xml中的空格换行会被读取到text中。
        System.out.println(nameElem.getText());
        Element conElem2=(Element)rootElem.elements("contact").get(1);
        //获取属性
        //方法1.直接获取属性值
        String idValue=conElem2.attributeValue("cid");
        System.out.println(idValue);
        //方法2：先获取属性，再获取属性对象，再获取属性的数据
        Attribute idAtr=conElem2.attribute("cid");
        //打印属性值
        System.out.println(idAtr.getName()+":"+idAtr.getValue());
        //获取标签的所有属性
        List<Attribute> allAtrr=conElem2.attributes();
        for(Attribute at:allAtrr){
            System.out.println(at.getName()+" "+at.getValue());
        }

    }
}
