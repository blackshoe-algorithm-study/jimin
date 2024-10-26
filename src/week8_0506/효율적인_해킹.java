package week8_0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 효율적인_해킹 {
    static int N, M;
    static List<Integer>[] graph;
    static int[] hackingResult;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // 역방향으로 간선을 저장 (B -> A)
            graph[B].add(A);
        }

        hackingResult = new int[N + 1]; // 해킹 가능 컴퓨터 수 저장
        max = 0;

        // 각 노드에서 DFS 탐색하여 해킹 가능한 컴퓨터 수를 구함
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            hackingResult[i] = dfs(i);
            max = Math.max(max, hackingResult[i]);  // 최대 해킹 가능한 컴퓨터 수 갱신
        }

        // 최대 해킹 가능한 컴퓨터 수를 가진 노드들을 출력
        for (int i = 1; i <= N; i++) {
            if (hackingResult[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb);
    }

    // DFS를 이용한 해킹 가능한 컴퓨터 수 계산
    private static int dfs(int node) {
        visited[node] = true;
        int count = 1; // 자기 자신도 포함해서 해킹 가능한 컴퓨터 수

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next);  // 연결된 노드에 대해 재귀적으로 탐색
            }
        }

        return count;
    }

}
