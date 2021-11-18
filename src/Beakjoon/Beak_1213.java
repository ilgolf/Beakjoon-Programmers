package Beakjoon;

import java.io.*;

public class Beak_1213 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] a = new int[26];

        for (char c : str.toCharArray()) {
            a[c - 'A'] ++;
        }

        int index = 0, odd = 0;

        for (int i = 0; i < 26; i++) {
            if (a[i] % 2 != 0) {
                index = i;
                odd ++;
            }
        }

        if ((str.length() % 2 != 0 && odd > 1) || (str.length() % 2 == 0 && odd > 0)) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                ans.append(String.valueOf((char) (i + 'A')).repeat(Math.max(0, a[i] / 2)));
            }

            String rev = reverseStr(ans);

            if (odd == 1) ans.append((char)(index + 'A'));

            System.out.println(ans + rev);
        }
    }

    private static String reverseStr(StringBuilder ans) {
        return new StringBuffer(ans).reverse().toString();
    }
}
