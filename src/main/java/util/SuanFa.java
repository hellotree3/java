package util;

/**
 * �㷨�����࣬��ϰ�㷨��ͨ��SuanfaTest������
 *
 * @author by �ھӵĶ���
 * @Begin 2017/9/21.
 */

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

public class SuanFa {
    /**
     * 1. 쳲�����--�ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
     * С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ����Ӷ���Ϊ����
     */
    public int countRabbit(int n) {
        //�ݹ���ʵ�֡��ݹ�Ĺؼ�����׼���ڣ����ǵݹ�̫ռ�ڴ棬Ч�ʲ��ߡ�����̫��ʱ������ʹ��
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return countRabbit(n - 1) + countRabbit(n - 2);
        }
    }

    /**
     * 2.�ж�101-200֮���ж��ٸ����������������������
     */
    public void primeNum(int start, int end) {
        int count = 0;   //ͳ��start,end֮�������������
        if (start > end) {   //��֤startС��end
            System.out.println("������������");
            return;
        }
        for (int i = start; i <= end; i++) {
            boolean flag = true;  //������־��Ĭ��Ϊtrue��
            //�����Ķ��壬��1�⣬ֻ�ܱ�������������
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {         //����������Ϊfalse��2���ڲ��ܽ���ѭ���������true
                    flag = false;
                }
            }
            if (flag) {
                count++;
                System.out.print(i + "\t");
                if (count % 15 == 0)      //ÿ15������
                    System.out.println();
            }
        }
        System.out.println("\n" + "-----------------****************-------------------");
        System.out.println(start + "��" + end + " ����" + count + " ������");
    }

    /**
     * 2.����ʵ�ַ���������һ�����ֱ�ȥ��2��sqrt(�����)������ܱ����������������������������֮������
     */
    public boolean isPrime(int num) {
        boolean flag = true; //Ĭ��������
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
     * 3.��ӡ�����е�"ˮ�ɻ���"����ν"ˮ�ɻ���"��ָһ����λ�������λ���������͵��ڸ�������
     */
    public void lotusNum(int n) {
        if (n <= 100) {
            System.out.println("��������");
            return;
        }
        //�ؼ��ǲ�ֳ���ʮ��λ
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
     * 4. ��һ���������ֽ������������磺����90,��ӡ��90=2*3*3*5��
     */
    public void showDepose(int n) {              //���������bug ��24��13
        if (n <= 1) {
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
        if (n == 2) {
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
        int tmp = n;                   //tmp���洢�仯��n
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
     * �ֽ������� ���˷������ж�����������ȥѭ���ֽ⣬�ٴ�ӡ
     *
     * @param n
     */
    public void showDeposeNum(int n) {
        if (n <= 1) {
            System.out.println("��������"); //ע�� 1��������
            return;
        }
        System.out.print(n + "=");
        int tp = n;  //������
//        for(int i=2;i<=n;i++){
//          while(isPrime(i)&&tp%i==0){  //Ŀǰ��˵�����һ�����ӡ��*  ��̫�á�����ǶԵ�
//              System.out.print(i+"*");
//              tp=tp/i;
//          }
//        }
        //�Ż������ֽ���������Ӵ����б��У�Ȼ���ٴ�ӡ
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
     * ��ӡ������Ԫ��
     *
     * @param list
     */
    public void showPrimeArr(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {        //���������Ϊ���һ�����ӣ�ֻ��һ������ʱ���ͱ�ʾ������
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + "*");
            }
        }
    }

    /**
     * 6. ��������������m��n���������Լ������С��������
     * ���Լ�������Ĺ�ͬ�����صĳ˻�����С��������
     *
     * @param max
     * @param min
     */
    public void MyMaxMin(int max, int min) {
        ArrayList<Integer> listMax = new ArrayList<Integer>();
        ArrayList<Integer> listMin = new ArrayList<Integer>();
        if (min > max) {             //��֤max>min
            int tp = max;
            max = min;
            min = tp;
        }
        int a = max, b = min; //���max,min�ĳ�ʼֵ
        //˼·1��ͬ�����صķֽⷨ����max��minȡ���������ӷ����б��С����Լ����ȽϹ�ͬ�ģ���С����  ArrayList<Integer> primeNum=new ArrayList<Integer>();
        addPrimeList(listMax, max);
        addPrimeList(listMin, min);
        showPrimeArr(listMax);
        showPrimeArr(listMin);
        //����
        listMax.retainAll(listMin);  //�����⣬��Ϊlist���ݿ����ظ������������ǿ��Էֽ�����
        showPrimeArr(listMax);
        //�������������������뷨
    }

    // ˼·2�����ϵ�շת����������ҵļ�
    public void max_min(int m, int n) {   //�ĵ���Ĵ�
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
        System.out.println(a + "��" + b + "�����Լ��Ϊ" + yshu);
        System.out.println(a + "��" + b + "����С������Ϊ" + bshu);
    }

    /**
     * �ֽ������ӣ���ӵ�list�б��еĹ��÷���
     *
     * @param list �б�
     * @param n    ��Ҫ�ֽ������ӵ�����
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
     * 7. ����һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
     * @param s
     */
    public void countCharacter(String s) {
        /*
         ˼·1��ֱ��ͨ��������ʽ�����ƥ��ͳ�Ƹ�����count++
         ˼·2����ƥ��Ĵ�����list�б��У�Ȼ��ͳ��size
         */
        //��Ӧ��������ʽ
        String digitReg = "\\d";
        String blankReg = "\\s";  //��//s
        String chineseReg = "[\\u4e00-\\u9fa5]"; //����
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
            if (str[i].matches(letterReg)) {    //ƥ��Ӣ����ĸ
                letterCount++;
            } else if (str[i].matches(chineseReg)) {   //ƥ������
                chineseCount++;
            } else if (str[i].matches(digitReg)) {   //ƥ������
                digCount++;
            } else if (str[i].matches(blankReg)) {
                blankCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println("������ַ���Ϊ��" + s + "  �ܳ���Ϊ��" + s.length());
        System.out.println("���У�" + " Ӣ����ĸ������" + letterCount + " ���ĸ�����" + chineseCount + " ���ָ�����" + digCount + " �ո������"
                + blankCount + " �����ַ�������" + otherCount);
    }

    /**
     * 8. ��s=a+aa+aaa+aaaa+aa...a��ֵ������a��һ������,n������a.���
     * @param a
     * @param n
     */
    public void countA(int a, int n) {  //n��a ͳ�ƺ�
     /*
     ˼·1�� ��a~n��a��ֵͨ��ʮ�����㷨ת����Ȼ����ͳ��
     ˼·2�� ��stringBuilderֱ��append 1-n��a,Ȼ����ת��Ϊ���֣�����ۼ�
      */
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int aValue = zhuanHuan(a, i);
            result += aValue;
        }
        System.out.println("s=" + result);
    }

    public int zhuanHuan(int a, int n) {   //n��aת����ʮ������
        int result = 0;
        if (n <= 0) {
            System.out.println("��������");
            return result;
        }
        for (int i = 0; i < n; i++) {
            result += a * Math.pow(10, i);
        }
        return result;
    }

    /**
     * 9. һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ"����"������6=1��2��3.����ҳ�1000���ڵ�����������
     */
    public void completeNum() {
        ArrayList<Integer> complist = new ArrayList<Integer>();  //����list
        //˼·��ͬ�����ֽ⣬�������ӣ����ж�
        System.out.println("��������ֵǡ�õ�����������֮�͡�1000���ڵ������������£�");
        //���ʣ����ӣ�Ӧ�ò���ָ�����Ӱɣ�����˵12������Ӧ���ǣ�1,2,3,6,12
        for (int i = 1; i <= 1000; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();   //������������list
            int result = 0;    //ͳ���������ӵ��ܺ�
            addDeposeList(list, i);     //�����ֽ⣬�������Ӽ��뵽list����
            for (Integer inte : list) {         //�������б������ȡ�����ۼӺ������ȶ�
                result += inte.intValue();
            }
            if (result == i) {
                complist.add(i);  //������������������ӵ�complist
            }
        }
        showArrList(complist);
    }

    /**
     * ���÷�������ȡn���������ӣ�����list����
     * @param list
     * @param n
     */
    public void addDeposeList(List<Integer> list, int n) {
        //�����������������ӣ���������. ���⣬��Ϊ�漰���ۼӣ���������˱����Ǽ��������ӵĽ����һ�����ڱ���ġ������ʱȥ������
        for (int i = 1; i <= n / 2; i++) {  //�Ż����������ӵ���n/2
            if (n % i == 0) {
                list.add(i);
            }
        }
    }

    /**
     * ��������������list����
     * @param list
     */
    public void showArrList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //���ϵ�
    public void compNumber(int n) {    //����1000������24�����Ĵ�������
        int count = 1;
        System.out.println(n + "���ڵ�������");
        for (int i = 1; i < n + 1; i++) {     //i=24
            int sum = 0;
            for (int j = 1; j < i / 2 + 1; j++) {     //j<13
                if ((i % j) == 0) {
                    sum += j;    //1+2+3+4+6+8+12
                }
                // ������������ġ���Ӧ�÷ŵ�ѭ�������λ�á����ǰ��������ۼӵĽ���պþ��Ǹ��������ӡ���������Գ�����24�����Ĵ������ݣ�
                //24��1+2+3+4+6+8+12  =  24+12 �����������24��ʱ��ͻ��24��ӡ����
//                    if(sum==i){
//                        System.out.print(i+" ");
//                        if((count++)%5==0)
//                            System.out.println();
//                    }
            }
            if (sum == i) {        //�޸���
                System.out.print(i + " ");
                if ((count++) % 5 == 0)
                    System.out.println();
            }
        }
    }

    /**
     * ��1��2��3��4�����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�
     */
    public void showDifComb() {

    }
}


