package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_14719 {

    static int n, m;
    static int[] map;
    static int ret, left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m];

        ret = left = right = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < m - 1; i++) {
            left = right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(map[j], left);
            }

            for (int j = i + 1; j < m; j++) {
                right = Math.max(map[j], right);
            }

            if (map[i] < left && map[i] < right) {
                ret += Math.min(left, right) - map[i];
            }
        }

        System.out.println(ret);
    }
}
