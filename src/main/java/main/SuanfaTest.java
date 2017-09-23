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
    public static  void showDepoNumTest(){   //分解素数因子
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int num=sc.nextInt();
        suanFa.showDeposeNum(num);
    }
    public static  void showDeposeTest(){
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int num=sc.nextInt();
        suanFa.showDepose(num);
    }
    public static void showMax_min(){   //最大公约数，最小公倍数
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入两个整数：");
        int max=sc.nextInt();
        int min=sc.nextInt();
        suanFa.max_min(max,min);
    }
    public static void showMyMaxMin(){
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入两个整数：");
        int max=sc.nextInt();
        int min=sc.nextInt();
        suanFa.MyMaxMin(max,min);
    }
    public static void showCountCharacter(){
        SuanFa suanFa=new SuanFa();
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入字符串:");
        String s=sc.nextLine();
        suanFa.countCharacter(s);
    }
    public static void countATest(){
        SuanFa suanFa=new SuanFa();
        System.out.print("求s=a+aa+aaa+aaaa+...的值，请输入a的值：");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.print("请输入a的个数：");
        int n=sc.nextInt();
      //  System.out.println(suanFa.zhuanHuan(a,n));
        suanFa.countA(a,n);
    }
    public static void showCompleteNum(){
        SuanFa suanFa=new SuanFa();
        suanFa.completeNum();
    }

}
