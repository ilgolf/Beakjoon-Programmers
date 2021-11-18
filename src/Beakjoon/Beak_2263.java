package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_2263 {

    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] inOrder;
    static int[] inOrderIdx;
    static int[] postOrder;

    static void getPreOrder(int inStart, int inEnd, int pStart, int pEnd) {
        if (inStart > inEnd || pStart > pEnd) {
            return;
        }

        int root = postOrder[pEnd];
        sb.append(root).append(" ");

        int rootIdx = inOrderIdx[root];
        int left = rootIdx - inStart;

        // 좌측 자식 노드
        getPreOrder(inStart, rootIdx - 1, pStart, pStart + left - 1);

        // 우측 자식 노드드
       getPreOrder(rootIdx + 1, inEnd, pStart + left, pEnd - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        inOrder = new int[n + 1];
        postOrder = new int[n + 1];
        inOrderIdx = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            inOrderIdx[inOrder[i]] = i;
        }

        getPreOrder(0, n - 1, 0, n - 1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
