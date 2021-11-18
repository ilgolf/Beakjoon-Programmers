package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baek_1107 {

    static boolean[] broken = new boolean[10];

    static int possible(int c) {
        if (c == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int len = 0;
        while (c > 0) {
            if (broken[c % 10]) {
                return 0;
            }
            len += 1;
            c /= 10;
        }

        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int ans = Math.abs(n - 100);

        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for (int i = 0; i < 1000000; i++) {
            int count = possible(i);

            if (count > 0) {
                int press = Math.abs(i - n);

                if (ans > count + press) {
                    ans = count + press;
                }
            }
        }

        System.out.println(ans);
    }
}
