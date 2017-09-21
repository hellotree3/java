package main;

import util.SuanFa;

import java.util.Scanner;

/**
 * Created by hellotree on 2017/9/21.
 *
 * @author by 邻居的耳朵
 * @Begin 2017/9/21.
 */
public class SuanfaTest {
    public  static  void main(String args[]){
        // rabbitTest();
        //primeTest();
        // isPrimeTest();
        showLotus();
    }
    public  static void  rabbitTest(){  //测试兔子对数
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入几个月:");
        int month=sc.nextInt();
        System.out.println(month+"个月后有"+suanFa.countRabbit(month)+"对兔子：");
    }
    public static void primeTest(){   //测试素数
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请整数范围:");
        int start=sc.nextInt();
        int end=sc.nextInt();
        suanFa.primeNum(start,end);
    }
    public static void isPrimeTest(){  //素数的判断方法优化
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int num=sc.nextInt();
        if(suanFa.isPrime(num)){
            System.out.println(num+" 是一个素数");
        }else {
            System.out.println(num+" 不是一个素数");
        }
    }
    public static void showLotus(){  //展示水仙花
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入100-1000以内的一个整数:");
        int num=sc.nextInt();
        suanFa.lotusNum(num);
    }
}
