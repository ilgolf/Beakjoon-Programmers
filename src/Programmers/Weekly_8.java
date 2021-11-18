package Programmers;

import java.util.Arrays;

public class Weekly_8 {
    public int solution(int[][] sizes) {
        return Arrays.stream(sizes).reduce((a, b) -> new int[] {
                Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        }).map(it -> it[0] * it[1]).get();
    }
}
