package week8_0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 알파벳 {
    static int R, C;
    static char[][] map;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[26];
        dfs(0, 0, 1);
        System.out.print(max);
    }
    static void dfs(int x, int y, int depth){
        visited[map[x][y] - 'A'] = true;
        max = Math.max(max, depth);
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
            if(!visited[map[nx][ny] - 'A']){
                dfs(nx, ny, depth+1);
            }
        }
        visited[map[x][y] - 'A'] = false;
    }
}
