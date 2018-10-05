package Øving2;

import java.util.Date;

public class Rekursjon {

    public static double method1(double x, int n){
        if (n == 0){
            return 1;
        }
        if(n==1)return x;
        return x*method1(x,n-1);
    }

    public static double method2(double x, int n){
        if (n == 0){
            return 1;
        }
        else if (n == 1){
            return x;
        }
        else if ((n&1) == 1){
            return x*method2(x*x, (n-1)/2);
        }
        else {
            return method2(x*x, n/2);
        }
    }

    public static void main(String[] args) {
        double xValue = 1.0001;
        int nValue = 1000;
        System.out.println("X: " + xValue + ", N: " + nValue);

        int runder = 0;
        double tid;
        Date slutt;
        double r;

        Date start = new Date();
        do {
            r = method1(xValue, nValue);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;
        System.out.println("1: Millisekund pr. runde: \n     " + tid);

        start = new Date();
        runder = 0;
        do {
            r = method2(xValue, nValue);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;
        System.out.println("2: Millisekund pr. runde: \n     " + tid);

        start = new Date();
        runder = 0;
        do {
            r = Math.pow(xValue, nValue);
            slutt = new Date();
            ++runder;
        } while (slutt.getTime()-start.getTime() < 1000);
        tid = (double)
                (slutt.getTime()-start.getTime()) / runder;
        System.out.println("Math: Millisekund pr. runde: \n     " + tid);
    }
}
