package Programmers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet 사용
 *
 * I 숫자 -> put연산과 함께 들어간 순서(key)와 숫자(value) 저장
 * D 1 -> 큐에서 최댓값 삭제
 * D -1 -> 큐에서 최솟값 삭제
 *
 * Set 사이즈 0일 경우엔 {0, 0} return
 */

public class DoubleQueue {

    public static int[] solution(String[] operations) {
        TreeSet<Integer> set = new TreeSet<>();

        for (String op : operations) {
            if (op.startsWith("I")) {
                set.add(Integer.parseInt(op.split(" ")[1]));
            }
            else if (op.startsWith("D")) {
                boolean check = Integer.parseInt(op.split(" ")[1]) == 1;

                if (check) {
                    set.remove(set.last());
                }
                else {
                    set.remove(set.first());
                }
            }
        }

        if (set.isEmpty()) {
            return new int[] {0, 0};
        }

        return new int[] {set.last(), set.first()};
    }

    public static void main(String[] args) {
        String[] operations = {"I 7","I 5","I -5","D -1"};

        System.out.println(Arrays.toString(solution(operations)));
    }
}
