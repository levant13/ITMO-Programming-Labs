package com.company;
import static java.lang.Math.*;
import java.util.Random;

import static java.lang.Math.random;

public class Main {

    public static void main(String[] args) {
        /**---------------------------- */
        long[] a = new long[100];
        int c=1;
        int i;
        for ( i = 18; i >=6 ; i -= 1)
        {
            a[c] = i;
            c+=1;

        }
        /**---------------------------- */

        int b;

        double[] x = new double[100];
        for (b = 1; b <= 16; b += 1)
        {
            x[b] = random() * 15 - 4;

        }
        /**---------------------------- */
        double k= (double) 1/4;
        double q= (double) 2/3;
        double p= (double) 1/3;

        double[][] l = new double[13][16];
        for (i = 0; i < l.length; i++)
        {
            for (int j = 0; j < l[i].length; j++)
            {
                if (a[i]==13)

                    l[i][j] = pow( (pow((double) ((k - x[i]) / 4), 9) * ( atan( pow(E,- abs(x[i])) )-1) ) , 3);

                else

                if (a[i] == 6 || a[i] == 8 || a[i] == 15 || a[i] == 17 || a[i]==11 || a[i]==18)

                {
                    l[i][j] = pow(((pow( (double)  (x[i]/2),(q) * atan((x[i]+3.5)/15))-1)/  tan((double) x[i]/2) ), 3);
                }

                else
                {
                    l[i][j] = pow(   (  pow(E,(pow(cos(x[i]), (p)/pow(((k)*(1-x[i])),3))))/2),2);
                }
            }
        }

        for (i = 0; i < l.length; i++)
        {
            for (int j = 0; j < l[i].length; j++)
            {
                System.out.printf("%-10.5f\t",(double) l[i][j]);
            }
            System.out.println();
        }

    }
}