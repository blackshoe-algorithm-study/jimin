package week8_0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙산 {
    static int N, M;
    static int[][] map, arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int year = 0;

        while(true){
            arr = new int[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] > 0){
                        countNearby(i, j);
                    }
                }
            }

            int area = 0;
            visited = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] > 0 && !visited[i][j]){
                        dfs(i, j);
                        area++;
                    }
                }
            }
            if (area >= 2) {
                System.out.print(year);
                return;
            }

            if (area == 0) {
                System.out.print(0);
                return;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        map[i][j] = Math.max(0, map[i][j] - arr[i][j]);
                    }
                }
            }
            year++;
        }
    }
    static void countNearby(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(map[nx][ny] == 0){
                arr[x][y] ++;
            }
        }
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            if(map[nx][ny]>0 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
}
