package week8_0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전_영역 {
    static int[][] map, dist;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int limit = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                limit = Math.max(limit, map[i][j]);
            }
        }
        int area = 1;
        for(int j=0; j<=limit; j++){
            area = Math.max(area, bfs(j));
        }
        System.out.print(area);
    }
    static int bfs(int h){
        dist = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] <= h) dist[i][j] = -1;
            }
        }

        int safe = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(dist[i][j] == 0){
                    safe++;
                    bfsFrom(i, j);
                }
            }
        }
        return safe;
    }
    static void bfsFrom(int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        dist[startX][startY] = 1;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0]; int y = current[1];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(dist[nx][ny] == 0){
                    dist[nx][ny] = 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}
