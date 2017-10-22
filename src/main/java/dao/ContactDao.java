package dao;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import entity.Contact;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import util.XmlUtil;

/**
 * Created by hellotree on 2017/10/16.
 * 把联系人操作相关的方法集中在这里处理
 * @author by 邻居的耳朵
 */
public class ContactDao {
    /**
     * 添加联系人：要求编号唯一
     * @param con
     */
//    static int idcream=2;
    public  void addContact(Contact con){
        //获取doc对象，来解析元素
        Document doc= XmlUtil.getDocument();
        //获取根节点
        Element rootElem=doc.getRootElement();
        //添加子节点/标签
        Element conElem=rootElem.addElement("contact");
        //添加属性
//        idcream++;
//        String idStr=String.valueOf(idcream);
//        conElem.addAttribute("id",idStr);
        //编号使用UUID算法生成一个随机且唯一的字符串
       String uid=UUID.randomUUID().toString().substring(1,10);
       conElem.addAttribute("id", uid);

        //添加子标签
        conElem.addElement("name").setText(con.getName());
        conElem.addElement("sex").setText(con.getSex());
        conElem.addElement("telephone").setText(con.getTelephone());
        conElem.addElement("qq").setText(con.getQq());
        conElem.addElement("email").setText(con.getEmail());
        //把修改的document对象写入（覆盖）原来的文件
        XmlUtil.writeToXml(doc);
    }

    /**
     * 更新联系人信息。根据联系人的id
     * @param contact
     */
    public void updateContact(Contact contact){
        //读取xml文件
        Document doc=XmlUtil.getDocument();
        //修改doc对象
        //根据id查询到对应的contact标签，xpath查询
       // Element conElem=(Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");//"//contact[@id='001']"
        //2.1 根据id查询对应的contact标签
        Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
        //修改对应的contact标签内容
        conElem.element("name").setText(contact.getName());
        conElem.element("sex").setText(contact.getSex());
        conElem.element("telephone").setText(contact.getTelephone());
        conElem.element("qq").setText(contact.getQq());
        conElem.element("email").setText(contact.getEmail());
        //修改的document对象写出到xml文件中
        XmlUtil.writeToXml(doc);
    }

    /**
     * 删除联系人：根据id
     * @param contact
     */
    public void deleteContact(Contact contact){
        Document doc=XmlUtil.getDocument();
        //获取需要删除的标签，根据id
        String xpath="//contact[@id='"+contact.getId()+"']";
       Element conElem=(Element) doc.selectSingleNode(xpath);
        //删除方法;1 .detach  2.父节点来删该子节点
        conElem.detach();
        //把修改后的document写出到xml文件中
        XmlUtil.writeToXml(doc);
    }

    /**
     * 查询所有联系人
     * @return
     */
    public List<Contact> findAll(){
        Document doc=XmlUtil.getDocument();
        //获取所有的contact标签
        List<Element> conList=(List<Element>)doc.getRootElement().elements("contact");
        List<Contact> list=new ArrayList<Contact>();
        for(Element e:conList){
            Contact contact=new Contact();
            contact.setId(e.attributeValue("id"));
            contact.setName(e.elementText("name"));
            contact.setSex(e.elementText("sex"));
            contact.setTelephone(e.elementText("telephone"));
            contact.setQq(e.elementText("qq"));
            contact.setEmail(e.elementText("email"));
            list.add(contact);
        }
        return  list;
    }
}
