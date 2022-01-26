package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_3830 {

    static int n, m;
    static int[] parents;
    static long[] weightDiff;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();;

        while (true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            parents = new int[n + 1];
            weightDiff = new long[n + 1];

            for (int i = 0; i <= n; i++) {
                parents[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (cmd.equals("!")) {
                    int w = Integer.parseInt(st.nextToken());

                    // 부모 합치면서 무게도 같이 연산해주기
                    union(a, b, w);
                }
                else {
                    // 부모가 같다면 계산 가능하다.
                    if (find(a) == find(b)) {
                        result = weightDiff[b] - weightDiff[a];
                        sb.append(result).append('\n');
                    } else {
                        sb.append("UNKNOWN").append('\n');
                    }
                }
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b, int diff) {
        int aRoot = find(a);
        int bRoot = find(b);

        // 이미 같은 그룹이라면 연산이 되있음 종료
        if (aRoot == bRoot) return;

        // parent를 변경하고, 무게 차이를 갱신
        parents[bRoot] = aRoot;
        weightDiff[bRoot] = weightDiff[a] - weightDiff[b] + diff;
    }

    private static int find(int val) {
        if (parents[val] == val) {
            return val;
        }

        else {
            int parentsIdx = find(parents[val]);
            weightDiff[val] += weightDiff[parents[val]];
            return parents[val] = parentsIdx;
        }
    }
}
