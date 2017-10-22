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
 * ����ϵ�˲�����صķ������������ﴦ��
 * @author by �ھӵĶ���
 */
public class ContactDao {
    /**
     * �����ϵ�ˣ�Ҫ����Ψһ
     * @param con
     */
//    static int idcream=2;
    public  void addContact(Contact con){
        //��ȡdoc����������Ԫ��
        Document doc= XmlUtil.getDocument();
        //��ȡ���ڵ�
        Element rootElem=doc.getRootElement();
        //����ӽڵ�/��ǩ
        Element conElem=rootElem.addElement("contact");
        //�������
//        idcream++;
//        String idStr=String.valueOf(idcream);
//        conElem.addAttribute("id",idStr);
        //���ʹ��UUID�㷨����һ�������Ψһ���ַ���
       String uid=UUID.randomUUID().toString().substring(1,10);
       conElem.addAttribute("id", uid);

        //����ӱ�ǩ
        conElem.addElement("name").setText(con.getName());
        conElem.addElement("sex").setText(con.getSex());
        conElem.addElement("telephone").setText(con.getTelephone());
        conElem.addElement("qq").setText(con.getQq());
        conElem.addElement("email").setText(con.getEmail());
        //���޸ĵ�document����д�루���ǣ�ԭ�����ļ�
        XmlUtil.writeToXml(doc);
    }

    /**
     * ������ϵ����Ϣ��������ϵ�˵�id
     * @param contact
     */
    public void updateContact(Contact contact){
        //��ȡxml�ļ�
        Document doc=XmlUtil.getDocument();
        //�޸�doc����
        //����id��ѯ����Ӧ��contact��ǩ��xpath��ѯ
       // Element conElem=(Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");//"//contact[@id='001']"
        //2.1 ����id��ѯ��Ӧ��contact��ǩ
        Element conElem = (Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
        //�޸Ķ�Ӧ��contact��ǩ����
        conElem.element("name").setText(contact.getName());
        conElem.element("sex").setText(contact.getSex());
        conElem.element("telephone").setText(contact.getTelephone());
        conElem.element("qq").setText(contact.getQq());
        conElem.element("email").setText(contact.getEmail());
        //�޸ĵ�document����д����xml�ļ���
        XmlUtil.writeToXml(doc);
    }

    /**
     * ɾ����ϵ�ˣ�����id
     * @param contact
     */
    public void deleteContact(Contact contact){
        Document doc=XmlUtil.getDocument();
        //��ȡ��Ҫɾ���ı�ǩ������id
        String xpath="//contact[@id='"+contact.getId()+"']";
       Element conElem=(Element) doc.selectSingleNode(xpath);
        //ɾ������;1 .detach  2.���ڵ���ɾ���ӽڵ�
        conElem.detach();
        //���޸ĺ��documentд����xml�ļ���
        XmlUtil.writeToXml(doc);
    }

    /**
     * ��ѯ������ϵ��
     * @return
     */
    public List<Contact> findAll(){
        Document doc=XmlUtil.getDocument();
        //��ȡ���е�contact��ǩ
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
