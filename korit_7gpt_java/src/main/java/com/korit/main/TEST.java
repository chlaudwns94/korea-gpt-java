package com.korit.main;

import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b && a == c) {
            System.out.println(10000 + a * 1000);
        } else if (a == c && a != b || a == b && a != c) {
            System.out.println(1000 + a * 1000);
        } else {
            int max = a;
            if (max < b) {
                max = b;
            }
            if (max < c) {
                max = c;
            }
                System.out.println( max * 1000);
        }
    }
}

