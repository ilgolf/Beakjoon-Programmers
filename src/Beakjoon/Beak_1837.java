package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1837 {

    static boolean[] primeArr;
    static final int PRIME_SIZE = (int)1e6 + 1;
    static String p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        p = st.nextToken();
        int k = Integer.parseInt(st.nextToken());

        primeArr = new boolean[PRIME_SIZE]; // false : 소수, true : 소수아님

        // 1 ~ k 소수 구하기
        getPrime(k);

        for (int i = 2; i < k; i++) {
            if (!primeArr[i]) {
                if (isBad(i)) {
                    System.out.println("BAD " + i);
                    return;
                }
            }
        }

        System.out.println("GOOD");
    }

    private static boolean isBad(int x) {
        char[] nums = p.toCharArray();
        int r = 0;

        for (int i = 0; i < nums.length; i++) {
            r = (r * 10 + (nums[i] - '0')) % x;
        }

        if (r == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void getPrime(int k) {
        for (int i = 2; i * i <= k; i++) {
            if (!primeArr[i]) {
                for (int j = i * i; j <= k; j += i) {
                    primeArr[j] = true;
                }
            }
        }
    }
}
