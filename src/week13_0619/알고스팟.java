package week13_0619;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알고스팟 {
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 열
        M = Integer.parseInt(st.nextToken()); // 행
        map = new int[M][N];
        visited = new boolean[M][N];
        for(int i=0; i<M; i++){
            String input = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        dfs(0, 0, 0);
        visited[0][0] = true;
        System.out.print(ans);
    }

    static void dfs(int x, int y, int cnt){
        if(x==M-1 && y==N-1){
            ans = Math.min(ans, cnt);
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=M || ny>=N || visited[nx][ny]) continue;
            if(map[nx][ny] == 0){
                visited[nx][ny] = true;
                dfs(nx, ny, cnt);
                visited[nx][ny] = false;
            }else{
                map[nx][ny] = 0;
                visited[nx][ny] = true;
                dfs(nx, ny, cnt+1);
                map[nx][ny] = 1;
                visited[nx][ny] = false;
            }
        }
    }
}
