package Beakjoon;

import java.io.*;

public class Baek_5525 {

    static int[] pi;
    static String s, p;
    static int n,m;

    static void getPi() {
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++ j;
            }
        }
    }

    static int KMP() {
        int j = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    j = pi[j];
                    count ++;
                }
                else {
                    ++j;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine();
        
        p = "I" + "OI".repeat(Math.max(0, n));

        pi = new int[p.length()];

        getPi();
        System.out.println(KMP());
    }
}
