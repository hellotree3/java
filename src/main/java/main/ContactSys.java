package main;

import dao.ContactDao;
import entity.Contact;

import javax.sound.midi.SysexMessage;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hellotree on 2017/10/16.
 * ͨѶ¼����������
 * @author by �ھӵĶ���
 * @Begin 2017/10/16.
 */
public class ContactSys {
    public  static  void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ContactDao contactDao=new ContactDao();
        showMain();
        String input=sc.next();
        //������ʽƥ��1-4��q\Q������
        String regex="[1-4qQ]";
        while (true){
            if(input.matches(regex)){
               if("1".equals(input)){
                   System.out.println("********** �����ϵ��ҳ��  *********");
                   //������ϵ����Ϣ
                   Contact contact = new Contact();
                   System.out.println("����������:");
                   String name = sc.next();
                   System.out.println("�������Ա�:");
                   String sex = sc.next();
                   System.out.println("������绰:");
                   String telephone = sc.next();
                   System.out.println("����������:");
                   String email =sc.next();
                   System.out.println("������qq:");
                   String qq = sc.next();
                   //��װContact����
                   contact.setName(name);
                   contact.setQq(qq);
                   contact.setTelephone(telephone);
                   contact.setSex(sex);
                   contact.setEmail(email);
                   //�����ϵ��
                   contactDao.addContact(contact);
                   System.out.println("��ϵ����Ϣ��ӳɹ���");
               }else if("2".equals(input)){
                   System.out.println("********** �޸���ϵ��ҳ��  *********");
                   //������ϵ����Ϣ
                   Contact contact = new Contact();
                   System.out.println("������Ҫ�޸ĵı�ţ�id��");
                   String id=sc.next();
                   System.out.println("�������޸ĺ������:");
                   String name = sc.next();
                   System.out.println("�������޸ĺ���Ա�:");
                   String sex = sc.next();
                   System.out.println("�������޸ĺ�ĵ绰:");
                   String telephone = sc.next();
                   System.out.println("�������޸ĺ������:");
                   String email =sc.next();
                   System.out.println("�������޸ĺ��qq:");
                   String qq = sc.next();
                   //��װContact����
                   contact.setId(id);
                   contact.setName(name);
                   contact.setQq(qq);
                   contact.setTelephone(telephone);
                   contact.setSex(sex);
                   contact.setEmail(email);
                   //�����ϵ��
                   contactDao.updateContact(contact);
                   System.out.println("��ϵ����Ϣ�޸ĳɹ���");
               }else if("3".equals(input)){
                   System.out.println("********** ɾ����ϵ��ҳ��  *********");
                   System.out.println("������Ҫ�޸ĵı�ţ�id��");
                   String id=sc.next();
                   Contact contact=new Contact();
                   contact.setId(id);
                   contactDao.deleteContact(contact);
                   System.out.println("��ϵ����Ϣɾ���ɹ���");
               }else if("4".equals(input)){
                   System.out.println("********** ��ѯ������ϵ��ҳ��  *********");
                   List<Contact> list=contactDao.findAll();
                   for (Contact contact : list) {
                       System.out.println(contact);
                   }
               }else {
                   System.out.println("********* ��ѡ���˳�ϵͳ **********");
                   System.exit(0);
               }
                break;
            }else {
                System.out.println("�����������������룡");
                input=sc.next();
            }
        }

    }
    //��ѯ��ҳ��˵�
    public static   void showMain(){
        System.out.println("=======��ϵ�˹���ϵͳ======");
        System.out.println("[1]������ϵ��");
        System.out.println("[2]�޸���ϵ��");
        System.out.println("[3]ɾ����ϵ��");
        System.out.println("[4]��ѯ������ϵ��");
        System.out.println("[Q]�˳�����");
        System.out.println("===========================");
    }
}
