package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_1927_Ver2 {

    static class Heap {
        int[] arr;
        int index;

        public Heap(int size) {
            arr = new int[size];
        }

        // 삽입 연산
        public void insert(int val) {
            // 1. 마지막 위치에 노드 삽입
            arr[++index] = val;

            // 2. 추가된 노드 힙 조건 검사
            for (int i = index; i > 1; i/=2) {
                if (arr[i / 2] > arr[i]) {
                    // 만족하지 않는다면 swap
                    swap(i / 2, i);
                } else {
                    break;
                }
            }
        }

        // 삭제 연산
        public int poll() {

            // 아무것도 없다면 0 출력
            if (index == 0) return 0;

            // root 노드를 빼주고 마지막 노드를 루트 노드로 바꿔준다.
            int root = arr[1];
            arr[1] = arr[index];
            index --;

            // 바뀐 노드가 힙 조건에 만족하는 지 검사
            for (int i = 1; i * 2 <= index;) {
                // 만족한다면 탈출
                if (arr[i] < arr[i * 2] && arr[i] < arr[i * 2 + 1]) {
                    break;
                }
                
                // 왼쪽 노드와 오른쪽 노드를 비교 후 더 큰 값을 swap하여 준다.
                else if (arr[i * 2] < arr[i * 2 + 1]) {
                    swap(i, i * 2);
                    i = i * 2;
                } else {
                    swap(i, i * 2 + 1);
                    i = i * 2 + 1;
                }
            }

            return root;
        }

        // swap 로직
        private void swap(int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Heap heaps = new Heap(100001); // 1부터 시작

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());

            if (val == 0) {
                System.out.println(heaps.poll());
            } else {
                heaps.insert(val);
            }
        }
    }
}
