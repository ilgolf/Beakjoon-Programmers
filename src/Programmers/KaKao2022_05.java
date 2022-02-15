package Programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS 문제 양의 갯수가 늑대의 갯수 보다 적으면 멈추기
 */
public class KaKao2022_05 {

    static class Pasture {
        int node;
        int kind; // 0 : 양, 1 : 늑대

        public Pasture(int node, int kind) {
            this.node = node;
            this.kind = kind;
        }
    }

    static List<ArrayList<Pasture>> tree = new ArrayList<>();
    static boolean[][][] checked;
    static int[] infos;
    static int max = 0;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        infos = info.clone();
        checked = new boolean[info.length][info.length + 1][info.length + 1];

        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }

        tree.get(0).add(new Pasture(0, 0));

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            tree.get(a).add(new Pasture(b, info[i + 1]));
            tree.get(b).add(new Pasture(a, info[i + 1]));
        }

        dfs(0, 0, 0);

        return answer;
    }

    private void dfs(int depth, int sheep, int wolf) {
        // 1. 체크인
        int temp = -1;

        if (infos[depth] != -1) {
            if (infos[depth] == 0) {
                temp = 0;
                sheep ++;
            }
            else {
                temp = 1;
                wolf ++;
            }
        }

        // 2. 목적지 인가? 양 < 늑대 일 경우 종료
        if (sheep <= wolf) {
            return;
        } else {
            max = Math.max(max, sheep);
        }

        // 3. 연결된 곳을 순회
        for (int i = 0; i < tree.get(depth).size(); i++) {
            int next = tree.get(depth).get(i).node;

            // 4. 갈 수 있는가?
            if (checked[next][sheep][wolf]) continue;

            infos[depth] = -1;

            checked[depth][sheep][wolf] = true;
            dfs(next, sheep, wolf);
            infos[depth] = temp;

            // 5. 체크 아웃
            checked[depth][sheep][wolf] = false;
        }
   }
}
