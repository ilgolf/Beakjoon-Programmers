package Programmers;

public class VisitLength {

    static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // U : 0, D : 1, R : 2, L : 3
    static boolean[][][][] checked = new boolean[11][11][11][11];
    public int solution(String dir) {
        int answer = 0;

        int x = 0, y = 0;
        int nx  = 5, ny = 5;

        int idx = 0;

        for(char d : dir.toCharArray()) {
            x = nx;
            y = ny;

            if(d == 'U') idx = 0;
            else if(d == 'D') idx = 1;
            else if(d == 'R') idx = 2;
            else if(d == 'L') idx = 3;

            nx += moving[idx][0];
            ny += moving[idx][1];

            if(nx < 0 || ny < 0 || nx > 10 || ny > 10) {
                nx -= moving[idx][0];
                ny -= moving[idx][1];
                continue;
            }

            if(!checked[x][y][nx][ny] &&  !checked[nx][ny][x][y]) {
                checked[x][y][nx][ny] = true;
                checked[nx][ny][x][y] = true;
                answer ++;
            }
        }
        return answer;
    }
}
