package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String str = br.readLine();

            if (set.contains(str)) {
                list.add(str);
            }
        }

        Collections.sort(list);

        if (list.size() == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(list.size());

        for (String strr : list) {
            System.out.println(strr);
        }
    }
}
