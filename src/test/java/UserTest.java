import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by hellotree on 2017/10/22.
 *
 * @author by �ھӵĶ���
 */
public class UserTest {
    public static void main(String[] args) throws Exception {
        //1)��ȡ�û�������û���������
        //ע�⣺ System.in���ֽ�����BufferedReader���ַ������ֽ���ת�ַ�����Ҫʹ��ת����
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("�������û�����");
        String name = br.readLine();

        System.out.println("���������룺");
        String password = br.readLine();


        //2)��user.xml�в�ѯ
        //name��ǩ�ı�Ϊ��rose��,password��ǩ�ı�Ϊ��123456����user��ǩ
        Document doc = new SAXReader().read(new File("./src/user.xml"));

        //��ѯ  �ı�Ϊ��xxx����name��ǩ
        Element nameElem = (Element)doc.selectSingleNode("//user/name[text()='"+name+"']");
        //�ж�name��ǩ�Ƿ����
        if(nameElem!=null){
            //����
            //�ж������Ƿ���ȷ
            Element userElem = nameElem.getParent();
            //�ж�password�ӱ�ǩ���ı�����
            String dbpwd = userElem.elementText("password");
            //���ݿ��������û����������ƥ��
            if(password.equals(dbpwd)){
                System.out.println("��¼�ɹ�");
            }else{
                //����ȷ
                System.out.println("����������������룡");
            }
        }else{
            //������
            System.out.println("���û��������ڵģ�");
        }

    }
}
