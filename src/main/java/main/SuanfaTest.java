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
        // isPrimeTest();
        showLotus();
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
}
