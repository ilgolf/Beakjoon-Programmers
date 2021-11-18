package Beakjoon;

/**
 *
 * 245의 분해합 -> 256(= 245 + 2 + 4 + 5)
 * 문자열을 배열로 나눠 준 다음 숫자로 바꿔 주고 연산
 *
 */

import java.io.*;

public class Baek_2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int val = Integer.parseInt(br.readLine());
        int num = 0;

        while (num <= val) {
            num ++;
            String str = String.valueOf(num);

            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }

            sum += num;

            if(sum == val) {
                System.out.println(num);
                return;
            }
        }

        System.out.println(0);
    }
}
