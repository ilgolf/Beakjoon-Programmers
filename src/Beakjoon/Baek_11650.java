package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_11650 {

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Coordinate> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Coordinate(a, b));
        }

        list.sort((o1, o2) -> {
            if (o1.x == o2.x) return o1.y - o2.y;
            return o1.x - o2.x;
        });

        for (Coordinate cood : list) {
            System.out.println(cood.x + " " + cood.y);
        }
    }
}
