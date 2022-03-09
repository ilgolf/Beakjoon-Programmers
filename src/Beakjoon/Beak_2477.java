package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2477 {

    static final int SIX = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] hexagon = new int[SIX][2];

        int n = Integer.parseInt(br.readLine());

        int widthIdx = 0;
        int heightIdx = 0;

        int widthMax = 0;
        int heightMax = 0;

        for (int i = 0; i < SIX; i++) {
            st = new StringTokenizer(br.readLine());

            hexagon[i][0] = Integer.parseInt(st.nextToken());
            hexagon[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < SIX; i++) {
            if (hexagon[i][0] == 1 || hexagon[i][0] == 2) {
                if (widthMax < hexagon[i][1]) {
                    widthMax = hexagon[i][1];
                    widthIdx = i;
                }
            }

            else if (hexagon[i][0] == 3 || hexagon[i][0] == 4) {
                if (heightMax < hexagon[i][1]) {
                    heightIdx = i;
                    heightMax = hexagon[i][1];
                }
            }
        }

        int w = getLength(hexagon, widthIdx);
        int h = getLength(hexagon, heightIdx);

        int subSquare = w * h;
        System.out.println((widthMax * heightMax - subSquare) * n);
    }

    private static int getLength(int[][] hexagon, int idx) {
        if (idx == 0) {
            return Math.abs(hexagon[5][1] - hexagon[idx + 1][1]);
        }
        else if (idx == 5) {
            return Math.abs(hexagon[idx - 1][1] - hexagon[0][1]);
        }
        else {
            return Math.abs(hexagon[idx - 1][1] - hexagon[idx + 1][1]);
        }
    }
}
