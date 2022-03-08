package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Camera {

    /**
     * [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
     * [-20,-15], [-18,-13], [-14,-5],  [-5,-3]
     *
     * start = - 15 -> ... -> start = -5
     */
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int start = routes[0][1];

        for (int i = 1; i < routes.length; i++) {

            if (start < routes[i][0]) {
                answer ++;
                start = routes[i][1];
            }
        }

        return answer;
    }
}
