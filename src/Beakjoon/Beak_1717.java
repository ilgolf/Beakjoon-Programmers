package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_1717 {

    static int n,m;
    static int[] parentTable; // 부모 테이블

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) parentTable[a] = b;
    }

    static int find(int x) {
        if (x == parentTable[x]) return x;

        return parentTable[x] = find(parentTable[x]);
    }

    static boolean checkFind(int x, int y) {
        x = find(x);
        y = find(y);

        return x == y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parentTable = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parentTable[i] = i;
        }

        StringBuilder result = new StringBuilder();
        while (m -- > 0) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            }
            else if (op == 1) {
                result.append((checkFind(a, b) ? "YES" : "NO")).append('\n');
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
