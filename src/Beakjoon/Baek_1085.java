package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int toZero = Math.min(Math.abs(w - x), Math.abs(h - y));
        int toMax = Math.min(x, y);

        System.out.println(Math.min(toMax, toZero));
    }
}
