package util;

/**
 * 算法工具类，练习算法。通过SuanfaTest来测试
 *
 * @author by 邻居的耳朵
 * @Begin 2017/9/21.
 */

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class SuanFa {
    /**
     * 1. 斐波拉契--古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
     * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少
     */
    public int countRabbit(int n) {
        //递归来实现。递归的关键是找准出口，但是递归太占内存，效率不高。数量太大时不建议使用
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return countRabbit(n - 1) + countRabbit(n - 2);
        }
    }

    /**
     * 2.判断101-200之间有多少个素数，并输出所有素数。
     */
    public void primeNum(int start, int end) {
        int count = 0;   //统计start,end之间的素数个数。
        if (start > end) {   //保证start小于end
            System.out.println("传入数据有误！");
            return;
        }
        for (int i = start; i <= end; i++) {
            boolean flag = true;  //素数标志，默认为true。
            //素数的定义，除1外，只能被本身整除的数
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {         //满足整除则为false，2由于不能进入循环因而还是true
                    flag = false;
                }
            }
            if (flag) {
                count++;
                System.out.print(i + "\t");
                if (count % 15 == 0)      //每15个则换行
                    System.out.println();
            }
        }
        System.out.println("\n" + "-----------------****************-------------------");
        System.out.println(start + "到" + end + " 共有" + count + " 个素数");
    }

    /**
     * 2.素数实现方法二：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数
     */
    public boolean isPrime(int num) {
        boolean flag = true; //默认是素数
        if (num <= 1)
            flag = false;
        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 3.打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
     */
    public void lotusNum(int n) {
        if (n <= 100) {
            System.out.println("输入有误！");
            return;
        }
        //关键是拆分出个十百位
        int ge, shi, bai;
        for (int i = 100; i <= n; i++) {
            ge = i % 10;
            shi = i / 10 % 10;
            bai = i / 10 / 10 % 10;
            double d = Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3);
            if (d == i) {
                System.out.print(i + "\t");
            }
        }
    }

    /**
     * 4. 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     */
    public void showDepose(int n) {              //这个代码有bug ，24，13
        if (n <= 1) {
            System.out.println("输入有误！");
            return;
        }
//        System.out.print(n+"的质因素有：");
       /*
       程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：
     (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
     (2)如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步。
     (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步
        */
        if (n == 2) {
            System.out.println(n);
        }
//        for(int i=2;i<n;i++){         //这个代码是有问题的。关键问题就是n是变化的。应该新建一个临时变量存储变化的n
//            while(n%i==0 && n!=i){
//                n/=i;
//                System.out.print(i+"*");
//            }
//            if(n==i){
//                System.out.println(i);
//                break;
//            }
//        }
        int tmp = n;                   //tmp来存储变化的n
        for (int i = 2; i < n; i++) {
            while (tmp % i == 0 && n != i) {
                tmp /= i;
                System.out.print(i + "*");
            }
            if (n == i) {
                System.out.println(i);
                break;
            }
        }
        System.out.println();
    }

    /**
     * 分解质因素 ，此方法先判断了质数，再去循环分解，再打印
     *
     * @param n
     */
    public void showDeposeNum(int n) {
        if (n <= 1) {
            System.out.println("输入有误！"); //注意 1不是素数
            return;
        }
        System.out.print(n + "=");
        int tp = n;  //除质数
//        for(int i=2;i<=n;i++){
//          while(isPrime(i)&&tp%i==0){  //目前来说，最后一个会打印出*  不太好。结果是对的
//              System.out.print(i+"*");
//              tp=tp/i;
//          }
//        }
        //优化：将分解的质数因子存入列表中，然后再打印
        ArrayList<Integer> primeNum = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            while (isPrime(i) && (tp % i == 0)) {
                tp = tp / i;
                primeNum.add(i);
            }
        }
        showPrimeArr(primeNum);
    }

    /**
     * 打印质因素元素
     *
     * @param list
     */
    public void showPrimeArr(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {        //多个因子则为最后一个因子；只有一个因子时，就表示该因子
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + "*");
            }
        }
    }

    /**
     * 6. 输入两个正整数m和n，求其最大公约数和最小公倍数。
     * 最大公约数：最大的共同质因素的乘积。最小公倍数，
     *
     * @param max
     * @param min
     */
    public void MyMaxMin(int max, int min) {
        ArrayList<Integer> listMax = new ArrayList<Integer>();
        ArrayList<Integer> listMin = new ArrayList<Integer>();
        if (min > max) {             //保证max>min
            int tp = max;
            max = min;
            min = tp;
        }
        int a = max, b = min; //存放max,min的初始值
        //思路1：同质因素的分解法，将max，min取出来质因子放在列表中。最大公约数则比较共同的，最小公倍  ArrayList<Integer> primeNum=new ArrayList<Integer>();
        addPrimeList(listMax, max);
        addPrimeList(listMin, min);
        showPrimeArr(listMax);
        showPrimeArr(listMin);
        //交集
        listMax.retainAll(listMin);  //有问题，因为list数据可以重复，而质因子是可以分解多个的
        showPrimeArr(listMax);
        //放弃这个交集并集差集的想法
    }

    // 思路2：网上的辗转相除法，比我的简单
    public void max_min(int m, int n) {   //文档里的答案
        int temp;
        int yshu;
        int bshu = m * n;
        if (n < m) {
            temp = n;
            n = m;
            m = temp;
        }
        int a = m, b = n;
        while (m != 0) {
            temp = n % m;
            n = m;
            m = temp;
        }
        yshu = n;
        bshu /= n;
        System.out.println(a + "和" + b + "的最大公约数为" + yshu);
        System.out.println(a + "和" + b + "的最小公倍数为" + bshu);
    }

    /**
     * 分解质因子，添加到list列表中的公用方法
     *
     * @param list 列表
     * @param n    需要分解质因子的整数
     */
    public void addPrimeList(List<Integer> list, int n) { //
        int tp = n;
        for (int i = 2; i <= n; i++) {
            while (isPrime(i) && (tp % i == 0)) {
                tp = tp / i;
                list.add(i);
            }
        }
    }

    /**
     * 7. 输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。
     * @param s
     */
    public void countCharacter(String s) {
        /*
         思路1：直接通过正则表达式，逐个匹配统计个数，count++
         思路2：将匹配的串存入list列表中，然后统计size
         */
        //相应的正则表达式
        String digitReg = "\\d";
        String blankReg = "\\s";  //用//s
        String chineseReg = "[\\u4e00-\\u9fa5]"; //中文
        String letterReg = "[a-zA-Z]";
        int digCount = 0;
        int letterCount = 0;
        int blankCount = 0;
        int chineseCount = 0;
        int otherCount = 0;
        char[] arr = s.toCharArray();
        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = String.valueOf(arr[i]);
            if (str[i].matches(letterReg)) {    //匹配英文字母
                letterCount++;
            } else if (str[i].matches(chineseReg)) {   //匹配中文
                chineseCount++;
            } else if (str[i].matches(digitReg)) {   //匹配数字
                digCount++;
            } else if (str[i].matches(blankReg)) {
                blankCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("输入的字符串为：" + s + "  总长度为：" + s.length());
        System.out.println("其中：" + " 英文字母个数：" + letterCount + " 中文个数：" + chineseCount + " 数字个数：" + digCount + " 空格个数："
                + blankCount + " 其他字符个数：" + otherCount);
    }

    /**
     * 8. 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字,n代表几个a.求和
     * @param a
     * @param n
     */
    public void countA(int a, int n) {  //n个a 统计和
     /*
     思路1： 将a~n个a的值通过十进制算法转化，然后再统计
     思路2： 用stringBuilder直接append 1-n个a,然后再转化为数字，最后累加
      */
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int aValue = zhuanHuan(a, i);
            result += aValue;
        }
        System.out.println("s=" + result);
    }

    public int zhuanHuan(int a, int n) {   //n个a转化成十进制数
        int result = 0;
        if (n <= 0) {
            System.out.println("数据有误");
            return result;
        }
        for (int i = 0; i < n; i++) {
            result += a * Math.pow(10, i);
        }
        return result;
    }

    /**
     * 9. 一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。
     */
    public void completeNum() {
        ArrayList<Integer> complist = new ArrayList<Integer>();  //完数list
        //思路：同质数分解，先求因子，再判断
        System.out.println("完数：数值恰好等于它的因子之和。1000以内的所有完数如下：");
        //疑问：因子，应该不是指质因子吧，比如说12的因子应该是：1,2,3,6,12
        for (int i = 1; i <= 1000; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();   //单个数的因子list
            int result = 0;    //统计所有因子的总和
            addDeposeList(list, i);     //将数分解，所得因子加入到list表中
            for (Integer inte : list) {         //将因子列表的数据取出，累加后与结果比对
                result += inte.intValue();
            }
            if (result == i) {
                complist.add(i);  //满足完数条件，则添加到complist
            }
        }
        showArrList(complist);
    }

    /**
     * 公用方法：获取n的所有因子，存入list表中
     * @param list
     * @param n
     */
    public void addDeposeList(List<Integer> list, int n) {
        //能整除的数就是因子，包括本身. 此题，因为涉及到累加，如果包含了本身，那加其他因子的结果是一定大于本身的。因而暂时去掉本身
        for (int i = 1; i <= n / 2; i++) {  //优化：最大的因子等于n/2
            if (n % i == 0) {
                list.add(i);
            }
        }
    }

    /**
     * 公共方法：遍历list数组
     * @param list
     */
    public void showArrList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //网上的
    public void compNumber(int n) {    //输入1000后会出现24这样的错误数据
        int count = 1;
        System.out.println(n + "以内的完数：");
        for (int i = 1; i < n + 1; i++) {     //i=24
            int sum = 0;
            for (int j = 1; j < i / 2 + 1; j++) {     //j<13
                if ((i % j) == 0) {
                    sum += j;    //1+2+3+4+6+8+12
                }
                // 这里是有问题的。不应该放到循环体这个位置。如果前面的因子累加的结果刚好就是该数，会打印出来。所以出现了24这样的错误数据，
                //24：1+2+3+4+6+8+12  =  24+12 。当满足等于24的时候就会把24打印出来
//                    if(sum==i){
//                        System.out.print(i+" ");
//                        if((count++)%5==0)
//                            System.out.println();
//                    }
            }
            if (sum == i) {        //修复后
                System.out.print(i + " ");
                if ((count++) % 5 == 0)
                    System.out.println();
            }
        }
    }

    /**
     * 有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
     */
    public void showDifComb() {

    }
}


