package week13_0619;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟 {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static class Map{
        int x, y, wallCount;
        Map(int x, int y, int wallCount){
            this.x = x;
            this.y = y;
            this.wallCount = wallCount;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 열
        M = Integer.parseInt(st.nextToken()); // 행
        map = new int[M][N];
        for(int i=0; i<M; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        int[][] dist = new int[M][N];
        int INF = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = 0;
        PriorityQueue<Map> pq = new PriorityQueue<>((p1, p2) -> p1.wallCount - p2.wallCount);
        pq.add(new Map(0, 0, 0));

        while(!pq.isEmpty()){
            Map current = pq.poll();
            int x = current.x;
            int y = current.y;
            if(x==M-1 && y==N-1){
                System.out.print(current.wallCount);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=M || ny>=N ) continue;
                int newDist = current.wallCount + map[nx][ny];
                if(newDist < dist[nx][ny]){
                    dist[nx][ny] = newDist;
                    pq.add(new Map(nx, ny, newDist));
                }
            }
        }

    }
}
