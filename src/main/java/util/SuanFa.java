package util;

/**
 * �㷨�����࣬��ϰ�㷨��ͨ��SuanfaTest������
 * @author by �ھӵĶ���
 * @Begin 2017/9/21.
 */

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class SuanFa {
    /**
     * 1. 쳲�����--�ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
     С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ����Ӷ���Ϊ����
     */
    public int countRabbit(int n){
        //�ݹ���ʵ�֡��ݹ�Ĺؼ�����׼���ڣ����ǵݹ�̫ռ�ڴ棬Ч�ʲ��ߡ�����̫��ʱ������ʹ��
        if(n==1||n==2){
            return 1;
        }else{
            return countRabbit(n-1)+countRabbit(n-2);
        }
    }
    /**
     * 2.�ж�101-200֮���ж��ٸ����������������������
     */
    public void primeNum(int start,int end){
        int count=0;   //ͳ��start,end֮�������������
        if(start>end){   //��֤startС��end
            System.out.println("������������");
            return;
        }
        for(int i=start;i<=end;i++){
            boolean flag=true;  //������־��Ĭ��Ϊtrue��
            //�����Ķ��壬��1�⣬ֻ�ܱ�������������
            for(int j=2;j<i;j++){
                if(i%j==0){         //����������Ϊfalse��2���ڲ��ܽ���ѭ���������true
                    flag=false;
                }
            }
            if(flag){
                count++;
                System.out.print(i+"\t");
                if(count%15==0)      //ÿ15������
                    System.out.println();
            }
        }
        System.out.println("\n"+"-----------------****************-------------------");
        System.out.println(start+"��"+end+" ����"+count+" ������");
    }
    /**
     * 2.����ʵ�ַ���������һ�����ֱ�ȥ��2��sqrt(�����)������ܱ����������������������������֮������
     */
    public  boolean isPrime(int num) {
        boolean flag = true; //Ĭ��������
        if(num<=1)
            flag=false;
        for(int i=2;i<=sqrt(num);i++){
            if(num%i==0){
                flag=false;
            }
        }
        return  flag;
    }
    /**
     * 3.��ӡ�����е�"ˮ�ɻ���"����ν"ˮ�ɻ���"��ָһ����λ�������λ���������͵��ڸ�������
     */
    public void lotusNum(int n){
        if(n<=100){
            System.out.println("��������");
            return;
        }
        //�ؼ��ǲ�ֳ���ʮ��λ
        int ge,shi,bai;
        for(int i=100;i<=n;i++){
            ge=i%10;
            shi=i/10%10;
            bai=i/10/10%10;
            double d=Math.pow(ge,3)+ Math.pow(shi,3)+Math.pow(bai,3);
            if(d==i){
                System.out.print(i+"\t");
            }
        }
    }
    /**
     * 4. ��һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
     */
    public void showDepose(int n){              //���������bug ��24��13
        if(n<=1){
            System.out.println("��������");
            return;
        }
//        System.out.print(n+"���������У�");
       /*
       �����������n���зֽ���������Ӧ���ҵ�һ����С������k��Ȼ������������ɣ�
     (1)����������ǡ����n����˵���ֽ��������Ĺ����Ѿ���������ӡ�����ɡ�
     (2)���n<>k����n�ܱ�k��������Ӧ��ӡ��k��ֵ������n����k����,��Ϊ�µ�������n,�ظ�ִ�е�һ����
     (3)���n���ܱ�k����������k+1��Ϊk��ֵ,�ظ�ִ�е�һ��
        */
        if(n==2){
            System.out.println(n);
        }
//        for(int i=2;i<n;i++){         //���������������ġ��ؼ��������n�Ǳ仯�ġ�Ӧ���½�һ����ʱ�����洢�仯��n
//            while(n%i==0 && n!=i){
//                n/=i;
//                System.out.print(i+"*");
//            }
//            if(n==i){
//                System.out.println(i);
//                break;
//            }
//        }
        int tmp=n;                   //tmp���洢�仯��n
        for(int i=2;i<n;i++){
            while(tmp%i==0 && n!=i){
                tmp/=i;
                System.out.print(i+"*");
            }
            if(n==i){
                System.out.println(i);
                break;
            }
        }
        System.out.println();
    }

    /**
     * �ֽ������� ���˷������ж�����������ȥѭ���ֽ⣬�ٴ�ӡ
     * @param n
     */
    public  void showDeposeNum(int n){
        if(n<=1){
            System.out.println("��������"); //ע�� 1��������
            return;
        }
        System.out.print(n+"=");
        int tp=n;  //������
//        for(int i=2;i<=n;i++){
//          while(isPrime(i)&&tp%i==0){  //Ŀǰ��˵�����һ�����ӡ��*  ��̫�á�����ǶԵ�
//              System.out.print(i+"*");
//              tp=tp/i;
//          }
//        }
        //�Ż������ֽ���������Ӵ����б��У�Ȼ���ٴ�ӡ
        ArrayList<Integer> primeNum=new ArrayList<Integer>();
        for(int i=2;i<=n;i++){
           while (isPrime(i)&&(tp%i==0)){
               tp=tp/i;
               primeNum.add(i);
           }
        }
        showPrimeArr(primeNum);
    }

    /**
     * ��ӡ������Ԫ��
     * @param list
     */
    public void showPrimeArr(List<Integer> list){
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1){        //���������Ϊ���һ�����ӣ�ֻ��һ������ʱ���ͱ�ʾ������
                System.out.println(list.get(i));
            }else {
                System.out.print(list.get(i)+"*") ;
            }
        }
    }
}

