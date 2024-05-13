package week7_0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] arr;
    static int[][] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 행
        int M = Integer.parseInt(str.nextToken()); // 열
        arr = new char[N+1][M+1]; // (1,1) 부터 시작
        visited = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=0; j<line.length(); j++){
                arr[i][j+1] = line.charAt(j);
            }
        }
        int result = bfs(N, M);
        System.out.println(result);
    }
    public static int bfs(int N, int M){
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{1, 1});  // 시작점
        visited[1][1] = 1;  // 시작점 방문 표시
        while(!list.isEmpty()){
            int[] current = list.remove();
            int x = current[0];
            int y = current[1];

            if (x == N && y == M) {
                return visited[x][y] - 1;
            }

            for (int i = 0; i < 4; i++) {  // 네 방향 모두 확인
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx <0 || ny<0 || nx>=M || ny>=N) continue;
                if(arr[nx][ny] == 1 && visited[nx][ny]==0){
                    list.add(new int[] {nx, ny});
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }
        return -1;
    }
}

// x가 갈 수 있는칸 : (0,1) (0,-1) (1,0) (-1,0) =>(-1, 0) 은 보류