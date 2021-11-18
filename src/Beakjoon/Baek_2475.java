package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baek_2475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;

        for (int i = 0; i < 5; i++) {
            long num = Integer.parseInt(st.nextToken());

            sum += (long)(Math.pow(num, 2));
        }

        System.out.println(sum % 10);
    }
}
