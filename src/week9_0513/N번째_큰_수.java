package week9_0513;

import java.io.*;
import java.util.*;

public class N번째_큰_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 숫자 N
        StringTokenizer str;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Long temp = Long.parseLong((str.nextToken()));
            pq.offer(temp);
        } // 먼저 0줄 우선순위 큐에 입력

        for(int i=1; i<N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                long compare = Long.parseLong(str.nextToken());
                if(pq.peek() < compare) {  // 추가
                    pq.poll();
                    pq.offer(compare);
                }
            }
        }

        System.out.println(pq.poll());
    }
}
