package main;

import util.SuanFa;

import java.util.Scanner;

/**
 * Created by hellotree on 2017/9/21.
 *
 * @author by �ھӵĶ���
 * @Begin 2017/9/21.
 */
public class SuanfaTest {
    public  static  void main(String args[]){
        // rabbitTest();
        //primeTest();
        //isPrimeTest();
        //showLotus();
        //showDepoNumTest();
        //showDeposeTest();
        //showMax_min();
        //showMyMaxMin();
        //showCountCharacter();
        //countATest();
        showCompleteNum();
        new SuanFa().compNumber(1000);
        //24=1*2*3*4*8*12     28=1*2*4*7*14   36=1*2*3*4*6*9*12

    }
    public  static void  rabbitTest(){  //�������Ӷ���
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("�����뼸����:");
        int month=sc.nextInt();
        System.out.println(month+"���º���"+suanFa.countRabbit(month)+"�����ӣ�");
    }
    public static void primeTest(){   //��������
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("��������Χ:");
        int start=sc.nextInt();
        int end=sc.nextInt();
        suanFa.primeNum(start,end);
    }
    public static void isPrimeTest(){  //�������жϷ����Ż�
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("������һ������:");
        int num=sc.nextInt();
        if(suanFa.isPrime(num)){
            System.out.println(num+" ��һ������");
        }else {
            System.out.println(num+" ����һ������");
        }
    }
    public static void showLotus(){  //չʾˮ�ɻ�
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("������100-1000���ڵ�һ������:");
        int num=sc.nextInt();
        suanFa.lotusNum(num);
    }
    public static  void showDepoNumTest(){   //�ֽ���������
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("������һ������:");
        int num=sc.nextInt();
        suanFa.showDeposeNum(num);
    }
    public static  void showDeposeTest(){
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("������һ������:");
        int num=sc.nextInt();
        suanFa.showDepose(num);
    }
    public static void showMax_min(){   //���Լ������С������
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("����������������");
        int max=sc.nextInt();
        int min=sc.nextInt();
        suanFa.max_min(max,min);
    }
    public static void showMyMaxMin(){
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("����������������");
        int max=sc.nextInt();
        int min=sc.nextInt();
        suanFa.MyMaxMin(max,min);
    }
    public static void showCountCharacter(){
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("�������ַ���:");
        String s=sc.nextLine();
        suanFa.countCharacter(s);
    }
    public static void countATest(){
        SuanFa suanFa=new SuanFa();
        System.out.print("��s=a+aa+aaa+aaaa+...��ֵ��������a��ֵ��");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.print("������a�ĸ�����");
        int n=sc.nextInt();
      //  System.out.println(suanFa.zhuanHuan(a,n));
        suanFa.countA(a,n);
    }
    public static void showCompleteNum(){
        SuanFa suanFa=new SuanFa();
        suanFa.completeNum();
    }

}
