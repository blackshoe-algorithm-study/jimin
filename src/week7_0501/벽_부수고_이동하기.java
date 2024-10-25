package week7_0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기 {
    static int N, M;
    static int[][] map;
    static int[][][] dist;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dist = new int[N][M][2];
        dist[0][0][0] = dist[0][0][1] = 1;
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        queue.add(new int[] {0, 0, 0}); // 시작점 + 벽부숨?
        bfs();
        int result = 1;
        if(dist[N-1][M-1][0]!=0 && dist[N-1][M-1][1]!=0){
            result = Math.min(dist[N-1][M-1][0], dist[N-1][M-1][1]);
        }else if( dist[N-1][M-1][0]!=0){
            result = dist[N-1][M-1][0];
        }else{
            result = dist[N-1][M-1][1];
        }
        System.out.print(result);
    }
    static void bfs(){
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0]; int y = now[1]; int current = now[2];
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(map[nx][ny]==0 && dist[nx][ny][current]==0){
                    dist[nx][ny][current] = dist[x][y][current] + 1;
                    queue.add(new int[] {nx, ny, current});
                }
                if(map[nx][ny]==1 && dist[nx][ny][1]==0 && current==0){
                    dist[nx][ny][1] = dist[x][y][current] + 1;
                    queue.add(new int[] {nx, ny, 1});
                }
            }
        }
    }
}
