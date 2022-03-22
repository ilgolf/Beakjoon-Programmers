package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_2564 {

    static int n, m;
    static List<Integer> shops = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int total = (m + n) * 2;


        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            getIdx(st);
        }


        st = new StringTokenizer(br.readLine());
        int myIdx = getIdx(st);

        int answer = 0;
        for (int val : shops) {
            int temp = Math.abs(myIdx - val);
            answer += Math.min(temp, total - temp);
        }

        System.out.println(answer);
    }

    // 북, 남, 서, 동
    private static int getIdx(StringTokenizer st) {
        int dir = Integer.parseInt(st.nextToken());
        int idx = Integer.parseInt(st.nextToken());

        switch (dir) {
            case 1:
                shops.add(idx);
                return idx;
            case 2:
                shops.add(m + n + (m - idx));
                return m + n + (m - idx);
            case 3:
                shops.add(2 * m + n + (n - idx));
                return 2 * m + n + (n - idx);
            default:
                shops.add(m + idx);
                return m + idx;
        }
    }
}
