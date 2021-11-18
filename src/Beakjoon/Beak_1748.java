package Beakjoon;

import java.io.*;

/**
 * 1 ~ 부터 이어가며 숫자를 배열에 저장?
 * 1 ~ 9 : 9개
 * 10 ~ 99 : 90개
 * 100 ~ 999 : 900개
 * 1000 ~ 9999 : 9000개
 */

public class Beak_1748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String val = String.valueOf(n);

        int length = val.length();
        int temp = 9;
        int result = 0;

        for (int i = 1; i < length; i++) {
            result += i * temp;
            temp *= 10;
        }

        int last = (int)(n - Math.pow(10, length - 1) + 1) * length;
        result += last;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
