package Programmers;

public class TargetNumber {

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }

    private void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) answer ++;

            return;
        }

        sum += numbers[depth];
        dfs(numbers, target, depth + 1, sum);
        sum -= numbers[depth];

        sum += (-1 * numbers[depth]);
        dfs(numbers, target, depth + 1, sum);
    }
}
