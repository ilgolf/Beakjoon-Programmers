package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Beak_13414 {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new LinkedHashSet<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            String gradeNum = br.readLine();
            set.remove(gradeNum);
            set.add(gradeNum);
        }

        StringBuilder result = new StringBuilder();
        int c = 0;
        for (String s : set) {
            if (c >= n) break;
            result.append(s).append('\n');
            c++;
        }

        System.out.println(result);
    }
}
