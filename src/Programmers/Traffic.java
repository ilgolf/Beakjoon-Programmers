package Programmers;

public class Traffic {

    static int[] startTimes;
    static int[] endTimes;
    static int answer = 0;

    public int solution(String[] lines) {
        int n = lines.length;

        startTimes = new int[n];
        endTimes = new int[n];

        getTime(lines);

        answer = Math.max(getAnswer(n, startTimes), getAnswer(n, endTimes));

        return answer;
    }

    private int getAnswer(int n, int[] Times) {
        for (int time : Times) {
            int count = 0;
            int section = time + 1000;

            for (int j = 0; j < n; j++) {
                if (startTimes[j] >= time && startTimes[j] < section) {
                    count ++;
                }
                else if (endTimes[j] >= time && endTimes[j] < section) {
                    count ++;
                }
                else if (startTimes[j] <= time && endTimes[j] >= section) {
                    count ++;
                }
            }

            answer = Math.max(answer, count);
        }
        return answer;
    }

    private void getTime(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            String[] log = lines[i].split(" ");
            String[] responseTime = log[1].split(":");

            int processingTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
            int startTime, endTime = 0;

            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
            endTime += (int)(Double.parseDouble(responseTime[2]) * 1000);

            startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
