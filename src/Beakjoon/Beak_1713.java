package Beakjoon;

import java.io.*;
import java.util.*;

public class Beak_1713 {

    static class Candidate {
        int value;
        int suggestion;
        int index;

        public Candidate(int value, int suggestion, int index) {
            this.value = value;
            this.suggestion = suggestion;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int size = Integer.parseInt(br.readLine());

        List<Candidate> list = new ArrayList<>();
        int[] student = new int[101];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (student[val] > 0) {
                student[val] ++;

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).value == val) {
                        list.get(j).suggestion ++;
                        break;
                    }
                }
            } else {
                if (list.size() >= n) {
                    list.sort(((o1, o2) -> {
                        if (o1.suggestion == o2.suggestion) {
                            return o1.index - o2.index;
                        }
                        return o1.suggestion - o2.suggestion;
                    }));

                    int num = list.get(0).value;
                    student[num] = 0;
                    list.remove(0);
                }
                list.add(new Candidate(val, 1, i));
                student[val] = 1;
            }
        }

        list.sort(Comparator.comparingInt(o -> o.value));

        for (Candidate candidate : list) {
            System.out.print(candidate.value + " ");
        }
    }
}
