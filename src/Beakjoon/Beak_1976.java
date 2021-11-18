package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_1976 {

    static int[] parentTable;
    static int n, m;

    static int find(int x) {
        if (x == parentTable[x]) return x;

        return parentTable[x] = find(parentTable[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parentTable[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        parentTable = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parentTable[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (start != find(now)) {
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
        }

        bw.write("YES");
        bw.flush();
        bw.close();
    }
}
