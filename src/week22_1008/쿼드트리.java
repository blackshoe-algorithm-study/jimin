package week22_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
    static int[][] map;
    static int N;
    static StringBuilder sb = new StringBuilder();
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
        dfs(0, 0, N);
        System.out.print(sb);
    }
    static void dfs(int x, int y, int size){
        if(divisible(x, y, size)){
            sb.append(map[x][y]);
            return;
        }
        int newSize = size/2;
        sb.append('(');
        dfs(x, y, newSize);
        dfs(x, y+newSize, newSize);
        dfs(x+newSize, y, newSize);
        dfs(x+newSize, y+newSize, newSize);
        sb.append(')');
    }
    static boolean divisible(int x, int y, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(map[x][y] != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}