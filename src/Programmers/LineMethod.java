package Programmers;

import java.util.ArrayList;
import java.util.List;

public class LineMethod {

    public int[] solution(int n, long k) {
        List<Integer> idxList = new ArrayList<>();
        int[] answer = new int[n];

        int fn = 1;

        for (int i = 1; i <= n; i++) {
            fn *= i;
            idxList.add(i);
        }

        k --;

        int idx = 0;
        while (n > 0) {
            fn /= n;
            answer[idx ++] = idxList.get((int)(k / fn));
            idxList.remove((int)(k / fn));
            k %= fn;
            n--;
        }

        return answer;
    }
}
