package Programmers;

/**
 *
 * 분할 정복, arr 배열을 분할하여 각 1이 될때까지 쪼갠 후 1이 되면 해당 값에 따라 answer 배열에 더해줌
 * 재귀 방식으로 풀이이 *
 *
 */

public class QuadTree {
    static int[] answer;

    static void quad(int n, int x, int y, int[][] arr) {
        if(isBlock(n, x, y, arr)) {
            answer[arr[x][y]]++;
            return;
        }

        quad(n/2, x, y, arr);
        quad(n/2, x + n/2, y, arr);
        quad(n/2, x, y + n/2, arr);
        quad(n/2, x + n/2, y + n/2, arr);
    }

    static boolean isBlock(int n, int x, int y, int[][] arr) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr.length, 0, 0, arr);
        return answer;
    }
}
