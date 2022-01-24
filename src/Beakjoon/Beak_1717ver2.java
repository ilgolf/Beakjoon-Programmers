package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1717ver2 {

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];

        // 1. 각 정점들을 생성해준다.
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            }
            else {
                if (checkFind(a, b)) {
                    sb.append("YES").append('\n');
                }
                else {
                    sb.append("NO").append('\n');
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean checkFind(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }

    // 2. 합치기 연산 : 같은 부모인가?
    private static void union(int a, int b) {
        // 부모 찾기
        a = find(a);
        b = find(b);

        // 서로 다른 값이니 부모를 바꿔 줌
        if (a != b) {
            parents[b] = a;
        }
    }

    private static int find(int a) {
        // 셀프 루프까지 찾기
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }
}
