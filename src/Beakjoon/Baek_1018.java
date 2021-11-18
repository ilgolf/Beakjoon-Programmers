package Beakjoon;

import java.io.*;
import java.util.*;

/**
 *
 * 브르투 포스 문제
 * 0부터 한칸 씩 8 * 8의 배열을 추출하여 올바른 색인지 확인
 * 매 값마다 갱신해주면서 탐색 완료 후 갱신된 최솟값을 출력
 *
 */

public class Baek_1018 {

    static boolean[][] checked; // W : true  B : false
    static int min = 64; // 최대 64개 칠해야 하므로 리터럴 값 64로 설정

    static void find(int x, int y) {
        boolean color = checked[x][y];
        int count = 0;
        int nX = x + 8, nY = y + 8;


        for (int i = x; i < nX; i++) {
            for (int j = y; j < nY; j++) {
                if(color != checked[i][j]) {
                    count ++;
                }

                color = (!color);
            }

            color = !color;
        }

        // 반대색을 색칠했을 때의 경우의 수를 살펴 봐야한다.
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        checked = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int j = 0;
            for (char ch : line.toCharArray()) {
                checked[i][j++] = ch == 'W';
            }
        }

        int row = n - 7;
        int col = m - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }
}
