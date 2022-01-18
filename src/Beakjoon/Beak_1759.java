package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 체크인
 * 목적지 (길이가 4인가?)
 * 연결
 * 갈 수 있는가?  (1. 오름 차순  2. 이미 선택 했는가?)
 * 간다
 * 체크 아웃
 */

public class Beak_1759 {

    static int l, c;
    static String[] stArr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int depth, int length, String comb) {
        // 1. 체크인 - 생략 가능
        // 2. 목적지 인가? - 길이 + 자음, 모음 개수
        if (length == 0) {
            if (isPassword(comb)) {
                sb.append(comb).append('\n');
            }
            return;
        }

        if (depth == c) return;

        // 연결된 곳을 순회 - 나보다 높은 알파벳
        // 갈 수 있는가 생략 : 정렬된 상태 이므로 검색할 조건이 없다.
        dfs(depth + 1, length - 1, comb + stArr[depth]);

        dfs(depth + 1, length, comb);

        // 체크 아웃 생략 가능
    }

    // 모음 확인
    private static boolean isPassword(String comb) {
        if (comb.contains("a") || comb.contains("e") || comb.contains("i") ||
                    comb.contains("o") || comb.contains("u")) {
            comb = comb.replace("a", "");
            comb = comb.replace("e", "");
            comb = comb.replace("i", "");
            comb = comb.replace("o", "");
            comb = comb.replace("u", "");

            return comb.length() >= 2;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        stArr = new String[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < stArr.length; i++) {
            stArr[i] = st.nextToken();
        }

        Arrays.sort(stArr);

        dfs(0, l, "");

        System.out.println(sb);
    }
}
