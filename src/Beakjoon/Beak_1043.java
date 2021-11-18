package Beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beak_1043 {

    static int n, m;
    static int[] truth;
    static int[] parent;
    static List<int[]> partyList = new ArrayList<>();

    // 부모 테이블 제작
    static void init() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    // 부모 노드 찾기
    static int find(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }

    // 합집합을 만들어 준다.
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x; // 부모 노드 바꿔주기
    }

    static boolean check(int item) {
        item = find(item);

        for (int i : truth) {
            if (item == find(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int truthNumber = Integer.parseInt(st.nextToken());

        if (truthNumber == 0) {
            System.out.println(m);
            return;
        }

        truth = new int[truthNumber];

        for (int i = 0; i < truthNumber; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n + 1];
        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int partyNumber = Integer.parseInt(st.nextToken());
            if (partyNumber == 0) {
                partyList.add(new int[] {});
                continue;
            }

            int[] temp = new int[partyNumber];
            int val = Integer.parseInt(st.nextToken());
            temp[0] = val;

            for (int j = 1; j < partyNumber; j++) {
                int item = Integer.parseInt(st.nextToken());
                temp[j] = item;
                if (val < temp[j]) union(val, item);
                else union(item, val);
            }
            partyList.add(temp);
        }

        int answer = 0;

        for (int[] temp : partyList) {
            boolean flag = false;

            for (int i : temp) {
                if (!check(i)) {
                    flag = true;
                    break;
                }
            }

            if (!flag) answer ++;
        }

        System.out.println(answer);
    }
}
