package Programmers;

import java.util.*;

public class HIndex {

    public int solution(int[] citations) {

        Integer[] cita = new Integer[citations.length];

        for (int i = 0; i < citations.length; i++) {
            cita[i] = citations[i];
        }

        Arrays.sort(cita, Collections.reverseOrder());

        for (int i = 0; i < cita.length; i++) {
            int count = 0;

            for (Integer integer : cita) {
                if (count == cita[i]) {
                    return i;
                }

                if (cita[i] <= integer) {
                    count++;
                }
            }
        }

        return 0;
    }
}
