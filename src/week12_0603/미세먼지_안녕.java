package week12_0603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미세먼지_안녕 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int rowPos;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(str.nextToken()); //R행
        int C = Integer.parseInt(str.nextToken()); //C열
        int T = Integer.parseInt(str.nextToken()); //T초
        int[][] map = new int[R][C];
        for(int i=0; i<R; i++){
            str = new StringTokenizer(br.readLine());
            List<Integer> arr = new LinkedList<>();
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
                if(map[i][j] == -1){ // 공기청정기 위치
                    rowPos = i; // 공기청정기 map[rowPos-1][0] map[rowPos][0]
                }
            }
        }
        for(int t=T; t>0; t--){
            for(int r=0; r<rowPos-1; r++){ //공기청정기 윗부분
                for(int c=0; c<C; c++){
                    Queue<Integer> Q = new LinkedList<>();
                    circulate(map, r, c, R, C, Q);
                }
            }
        }
    }
    private static void circulate(int[][] map, int r, int c, int R, int C, Queue<Integer> Q) { //r: 현재 행 c: 현재 열
        int cnt = 0; //방향 개수
        for (int i = 0; i < 4; i++) {
            if (r + dx[i] >= 0 && c + dy[i] >= 0 && r + dx[i] < rowPos-1 && c + dy[i] < C
                    && map[r + dx[i]][c + dy[i]] != -1) cnt++;
        }
        map[r][c] -= Math.floor(map[r][c]/5) * cnt;
       for(int j = 0 ; j<4; j++){
           if (r + dx[j] >= 0 && c + dy[j] >= 0 && r + dx[j] < rowPos-1 && c + dy[j] < C
                   && map[r + dx[j]][c + dy[j]] != -1){
               map[r+dx[j]][c+dy[j]] += Math.floor(map[r][c]/5);
           }
       }
    }
}

// 자기자신: 자기자신 - [자기자신/5]*(방향개수)
// 근처: [자기자신/5]*(방향개수)/(방향개수) = [자기자신/5]
// 1초동안 모든 칸에서 미세먼지 확산
