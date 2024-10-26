package week8_0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록_색약 {
    static char[][] map, anotherMap;
    static boolean[][] visited, anotherVisited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int i=0; i<n; i++){
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[n][n];
        int normal = countAreas(false);

        visited = new boolean[n][n];
        int blind = countAreas(true);

        System.out.print(normal + " " + blind);
    }
    static int countAreas(boolean isBlind){
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i, j, map[i][j], isBlind);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void dfs(int x, int y, char color, boolean isBlind){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
            if(!visited[nx][ny] && isSame(color, map[nx][ny], isBlind)){
                dfs(nx, ny, color, isBlind);
            }
        }
    }
    static boolean isSame(char color1, char color2, boolean isBlind){
        if (isBlind) {
            if ((color1 == 'R' || color1 == 'G') && (color2 == 'R' || color2 == 'G')) {
                return true;
            }
        }
        return color1 == color2;
    }
}
