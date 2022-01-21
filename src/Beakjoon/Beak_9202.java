package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_9202 {

    static class Trie {
        Trie[] child = new Trie[26];
        boolean isHit = false;
        boolean isEnd = false;

        // insert
        void insert(String str) {
            Trie current = root;

            for (char ch : str.toCharArray()) {
                int next = ch - 'A';

                if (current.child[next] == null) {
                    current.child[next] = new Trie();
                }
                current = current.child[next];
            }
            current.isEnd = true;
        }

        boolean hasChild(char c) {
            return child[c - 'A'] != null;
        }

        Trie getChild(char c) {
            return child[c - 'A'];
        }

        void clearHit() {
            isHit = false;
            for (int i = 0; i < child.length; i++) {
                if (child[i] != null) {
                    child[i].clearHit();
                }
            }
        }
    }

    static int w, b, sum, count;
    static String answer;
    static Trie root = new Trie();
    static boolean[][] checked;
    static char[][] map;
    static StringBuilder sb;
    static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
    static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
    static StringBuilder resultSb = new StringBuilder();

    static void dfs(int x, int y, int length, Trie node) {
        // 1. 체크인
        checked[x][y] = true;
        sb.append(map[x][y]);
        // 2. 목적지인가? isEnd O, isHit X
        if (node.isEnd && !node.isHit) {
            node.isHit = true;

            // 추가 답 처리
            sum += score[length];
            count ++;
            String foundWord = sb.toString();
            if (compare(answer, foundWord) > 0) {
                answer = foundWord;
            }
        }

        // 3. 연결된 곳 순회
        for (int i = 0; i < 8; i++) {
            int nx = x + moving[i][0];
            int ny = y + moving[i][1];

            // 4. 갈 수 있는가?
            if (nx >= 0 && ny >= 0 && nx < 4 && ny < 4) {
                if (!checked[nx][ny] && node.hasChild(map[nx][ny])) {
                    // 5. 간다
                    dfs(nx, ny, length + 1, node.getChild(map[nx][ny]));
                }
            }
        }
        // 6. 체크 아웃
        checked[x][y] = false;
        sb.deleteCharAt(length - 1);
    }

    private static int compare(String answer, String foundWord) {
        int result = Integer.compare(foundWord.length(), answer.length());

        if (result == 0) {
            return answer.compareTo(foundWord);
        } else {
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        w = Integer.parseInt(br.readLine());

        for (int i = 0; i < w; i++) {
            root.insert(br.readLine());
        }

        br.readLine();

        b = Integer.parseInt(br.readLine());

        while (b-- > 0) {
            checked = new boolean[4][4];
            map = new char[4][4];
            answer = "";
            sum = 0;
            count = 0;
            sb = new StringBuilder();


            for (int i = 0; i < 4; i++) {
                String line = br.readLine();
                for (int j = 0; j < 4; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    // 출발 가능 조건 -> root가 해당 child를 가지면
                    if (root.hasChild(map[i][j])) {
                        dfs(i, j, 1, root.getChild(map[i][j]));
                    }
                }
            }

            resultSb
                    .append(sum)
                    .append(" ")
                    .append(answer)
                    .append(" ")
                    .append(count)
                    .append('\n');

            root.clearHit();
            if (b != 0) {
                br.readLine();
            }
        }

        System.out.println(resultSb);
    }
}
