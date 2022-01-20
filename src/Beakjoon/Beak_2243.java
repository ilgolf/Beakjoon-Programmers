package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2243 {

    static int n;
    static long[] tree;
    static int s;
    static final int TASTE = 1000_000;

    // init
    static void init() {
        s = 1;
        while (s < TASTE) {
            s *= 2;
        }

        tree = new long[s * 2];
    }

    // update
    static void update(int index, long diff) {
        int k = s + index - 1;
        tree[k] += diff;

        k /= 2;
        while (k >= 1) {
            tree[k] = tree[k * 2] + tree[k * 2 + 1];

            k /= 2;
        }
    }

    // query
    static int query(int left, int right, int node, long query) {
        // 1. Leaf 노드에 도착했을 때 -> 사탕 번호 반환
        if (left == right) {
            return left;
        }

        int mid = (right + left) / 2;

        // 2. 왼쪽 >= query 라면 왼쪽으로 이동
        if (tree[node * 2] >= query) {
            return query(left, mid, node * 2, query);
        }

        // 3. 왼쪽 < query라면 오른쪽으로 이동동
        else {
           return query(mid + 1, right, node * 2 + 1, query - tree[node * 2]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        init();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                long num1 = Long.parseLong(st.nextToken());
                int index = query(1, s, 1, num1);
                update(index, -1);
                sb.append(index).append('\n');
            } else {
                int num1 = Integer.parseInt(st.nextToken());
                int diff = Integer.parseInt(st.nextToken());
                update(num1, diff);
            }
        }

        System.out.println(sb);
    }
}
