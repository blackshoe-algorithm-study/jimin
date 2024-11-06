package week13_0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정_거리의_도시_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 목표 거리
        int X = Integer.parseInt(st.nextToken()); // 시작 도시 번호

        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
        }

        // 거리 배열 초기화
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1); // -1로 초기화하여 미방문 표시
        dist[X] = 0; // 시작 도시의 거리는 0

        // BFS를 위한 큐 초기화
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        // BFS 실행
        while(!queue.isEmpty()) {
            int current = queue.poll();

            // 인접 도시 탐색
            for(int neighbor : graph.get(current)) {
                if(dist[neighbor] == -1) { // 미방문 도시인 경우
                    dist[neighbor] = dist[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // 거리 K인 도시를 출력
        boolean found = false;
        for(int i = 1; i <= N; i++) {
            if(dist[i] == K) {
                System.out.println(i);
                found = true;
            }
        }

        // 거리 K인 도시가 없으면 -1 출력
        if(!found) {
            System.out.println(-1);
        }
    }
}
