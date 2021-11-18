package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_6064 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t -- > 0) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String s = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                switch (s) {
                    case "I" :
                        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                        break;
                    case "D" :
                        if (treeMap.isEmpty()) break;
                        if (num == -1) {
                            int min = treeMap.firstKey();
                            if (treeMap.get(min) == 1) {
                                treeMap.remove(min);
                            } else {
                                treeMap.put(min, treeMap.get(min) - 1);
                            }
                        } else {
                            int max = treeMap.lastKey();
                            if (treeMap.get(max) == 1) {
                                treeMap.remove(max);
                            } else {
                                treeMap.put(max, treeMap.get(max) -  1);
                            }
                        }
                        break;
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(treeMap.lastKey()).append(' ').append(treeMap.firstKey()).append('\n');
            }
        }

        System.out.println(sb);
    }
}
