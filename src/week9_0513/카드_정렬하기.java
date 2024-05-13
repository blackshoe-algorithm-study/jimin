package week9_0513;

import java.io.*;
import java.util.*;

public class 카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N개의 숫자카드
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            pq.offer(k);
        }

        int num = 0;
        while (pq.size() > 1) {
            int temp1 = pq.poll();
            int temp2 = pq.poll();
            num += temp1 + temp2;
            pq.offer(temp1+temp2);
        }
        System.out.println(num);
    }
}

// 가장 작은 두 숫자를 peek에서 뽑아내고
// 연속으로 더함