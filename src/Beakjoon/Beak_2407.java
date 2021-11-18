package Beakjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Beak_2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger num1 = BigInteger.ONE;
        BigInteger num2 = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            num1 = num1.multiply(new BigInteger(String.valueOf(n - i))); // n!
            num2 = num2.multiply(new BigInteger(String.valueOf(i + 1))); // r!
        }

        System.out.println(num1.divide(num2));
    }
}
