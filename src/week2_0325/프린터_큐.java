package week2_0325;

import java.util.*;
import java.io.*;

public class 프린터_큐 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //테스트케이스 개수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int docs = Integer.parseInt(st.nextToken()); //문서 개수
            int want = Integer.parseInt(st.nextToken()); // 궁금한 문서 번호

            StringTokenizer str = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            PriorityQueue<Integer> ranks = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙으로 생성

            // 큐, 최대 힙에 숫자를 넣어줌
            for (int j = 0; j < docs; j++) {
                int num = Integer.parseInt(str.nextToken());
                q.offer(num);
                ranks.offer(num);
            }

            int rank = 1;
            while (!q.isEmpty() && !ranks.isEmpty()) { // 정답을 찾을 때까지 반복
                int num = q.poll();

                // 가장 중요도가 높은 문서인 경우
                if (num == ranks.peek()) {
                    // 정답을 찾은 경우
                    if (want == 0) {
                        System.out.println(rank);
                        break;
                    }
                    // 우선순위 큐에서도 제거
                    ranks.poll();
                    rank++;
                }

                // 젤 높은 중요도가 아닌경우 뒤로
                q.offer(num);
                // 원하는 번호 업데이트
                want--;
                if (want < 0) {
                    // 맨 뒤로 이동하는 경우
                    want = q.size() - 1;
                }
            }
        }
    }
}