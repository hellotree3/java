package main;

import dao.ContactDao;
import entity.Contact;

import javax.sound.midi.SysexMessage;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hellotree on 2017/10/16.
 * 通讯录交互主程序
 * @author by 邻居的耳朵
 * @Begin 2017/10/16.
 */
public class ContactSys {
    public  static  void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ContactDao contactDao=new ContactDao();
        showMain();
        String input=sc.next();
        //正则表达式匹配1-4及q\Q的输入
        String regex="[1-4qQ]";
        while (true){
            if(input.matches(regex)){
               if("1".equals(input)){
                   System.out.println("********** 添加联系人页面  *********");
                   //输入联系人信息
                   Contact contact = new Contact();
                   System.out.println("请输入姓名:");
                   String name = sc.next();
                   System.out.println("请输入性别:");
                   String sex = sc.next();
                   System.out.println("请输入电话:");
                   String telephone = sc.next();
                   System.out.println("请输入邮箱:");
                   String email =sc.next();
                   System.out.println("请输入qq:");
                   String qq = sc.next();
                   //封装Contact对象
                   contact.setName(name);
                   contact.setQq(qq);
                   contact.setTelephone(telephone);
                   contact.setSex(sex);
                   contact.setEmail(email);
                   //添加联系人
                   contactDao.addContact(contact);
                   System.out.println("联系人信息添加成功！");
               }else if("2".equals(input)){
                   System.out.println("********** 修改联系人页面  *********");
                   //输入联系人信息
                   Contact contact = new Contact();
                   System.out.println("请输入要修改的编号（id）");
                   String id=sc.next();
                   System.out.println("请输入修改后的姓名:");
                   String name = sc.next();
                   System.out.println("请输入修改后的性别:");
                   String sex = sc.next();
                   System.out.println("请输入修改后的电话:");
                   String telephone = sc.next();
                   System.out.println("请输入修改后的邮箱:");
                   String email =sc.next();
                   System.out.println("请输入修改后的qq:");
                   String qq = sc.next();
                   //封装Contact对象
                   contact.setId(id);
                   contact.setName(name);
                   contact.setQq(qq);
                   contact.setTelephone(telephone);
                   contact.setSex(sex);
                   contact.setEmail(email);
                   //添加联系人
                   contactDao.updateContact(contact);
                   System.out.println("联系人信息修改成功！");
               }else if("3".equals(input)){
                   System.out.println("********** 删除联系人页面  *********");
                   System.out.println("请输入要修改的编号（id）");
                   String id=sc.next();
                   Contact contact=new Contact();
                   contact.setId(id);
                   contactDao.deleteContact(contact);
                   System.out.println("联系人信息删除成功！");
               }else if("4".equals(input)){
                   System.out.println("********** 查询所有联系人页面  *********");
                   List<Contact> list=contactDao.findAll();
                   for (Contact contact : list) {
                       System.out.println(contact);
                   }
               }else {
                   System.out.println("********* 你选择退出系统 **********");
                   System.exit(0);
               }
                break;
            }else {
                System.out.println("输入有误，请重新输入！");
                input=sc.next();
            }
        }

    }
    //查询主页面菜单
    public static   void showMain(){
        System.out.println("=======联系人管理系统======");
        System.out.println("[1]增加联系人");
        System.out.println("[2]修改联系人");
        System.out.println("[3]删除联系人");
        System.out.println("[4]查询所有联系人");
        System.out.println("[Q]退出程序");
        System.out.println("===========================");
    }
}
