package week9_0515;

import java.io.*;
import java.util.*;

public class 문제집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 문제 개수
        int M = Integer.parseInt(st.nextToken()); // 의존 관계 수

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            inDegree[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        // 위상 정렬 수행
        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");

            // 현재 문제의 후속 문제들의 진입 차수를 감소시키기
            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    pq.offer(neighbor);
                }
            }
        }

        // 최종 위상 정렬 결과 출력
        System.out.print(sb.toString().trim());
    }
}
