package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_1149 {

    static int n;
    static int[][] house;
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        house = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            house[i][RED] = Integer.parseInt(st.nextToken());
            house[i][GREEN] = Integer.parseInt(st.nextToken());
            house[i][BLUE] = Integer.parseInt(st.nextToken());
        }
        
        int min = 0;

        for (int i = 1; i < n; i++) {
            house[i][RED] += Math.min(house[i - 1][GREEN], house[i - 1][BLUE]);
            house[i][GREEN] += Math.min(house[i - 1][RED], house[i - 1][BLUE]);
            house[i][BLUE] += Math.min(house[i - 1][RED], house[i - 1][GREEN]);
        }

        System.out.println(Math.min(house[n - 1][RED], Math.min(house[n - 1][GREEN], house[n - 1][BLUE])));
    }
}
