package week22_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 단지번호붙이기 {
    static int N;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0 , -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<input.length(); j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }
        visited = new boolean[N][N];
        list = new ArrayList<>();

        int idx = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    list.add(0);
                    dfs(i, j, list.size()-1);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int size: list){
            System.out.println(size);
        }
    }
    public static void dfs(int x, int y, int round){
        visited[x][y] = true;
        list.set(round, list.get(round)+1);

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && map[nx][ny]==1){
                dfs(nx, ny, round);
            }
        }
    }
}
