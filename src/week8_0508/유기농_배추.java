package week8_0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농_배추 {
    static int[][] map;
    static int m, n, k;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); //열
            n = Integer.parseInt(st.nextToken()); //행
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()); // 열
                int v = Integer.parseInt(st.nextToken()); // 행
                map[v][u] = 1;
            }
            int cnt = 0;
            for(int o=0; o<n; o++){
                for(int p=0; p<m; p++){
                    if(!visited[o][p] && map[o][p]==1){
                        dfs(o, p);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
            if(!visited[nx][ny] && map[nx][ny]==1){
                dfs(nx, ny);
            }
        }
    }
}
