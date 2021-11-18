package Programmers;

public class ChangeBinary {
    public int[] solution(String s) {

        int zeroCount = 0;
        int round = 0;

        while(!s.equals("1")) {
            int num = s.length();
            s = s.replace("0", "");
            int c = s.length();
            zeroCount += (num - c);
            s = Integer.toBinaryString(c);
            round ++;
        }
        return new int[] {round, zeroCount};
    }
}