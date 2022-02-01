package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KaKao2022_02 {

    public static int solution(int n, int k) {
        int answer = 0;

        String str = Integer.toString(n, k);

        StringBuilder num = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '0' && num.length() > 0) {
                long t = Long.parseLong(num.toString());

                if (isDecimal(t)) {
                    answer ++;
                }

                num.setLength(0);
            }
            else {
                num.append(ch);
            }
        }

        if (num.length() > 0) {
            if (isDecimal(Integer.parseInt(num.toString()))) {
                answer ++;
            }
        }

        return answer;
    }

    private static boolean isDecimal(long t) {
        if (t <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(t); i++) {
            if (t % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;

        System.out.println(solution(n, k));
    }
}
