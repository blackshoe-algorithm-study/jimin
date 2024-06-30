package week15_0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int MAX = 0;
    static class Node{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken()); // N: 행, M: 열
        M = Integer.parseInt(str.nextToken());
        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        dfs(0);
        System.out.print(MAX);
    }
    static void dfs(int wall){
        //벽이 3개인 경우
        if(wall == 3){
            bfs();
            return;
        }
        for(int i=0; i<N; i++){ //벽 3개를 0행0열부터 차례로 추가
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wall+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 2){
                    queue.add(new Node(i, j));
                }
            }
        }

        int[][] copy = new int [N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copy[i][j] = map[i][j];
            }
        }

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(copy[nx][ny] == 0){
                        queue.add(new Node(nx, ny));
                        copy[nx][ny] = 2;
                    }
                }
            }
        }
        safeZone(copy);
    }
    static void safeZone(int[][] copy){
        int safe = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copy[i][j] == 0){
                    safe++;
                }
            }
        }
        if(MAX < safe){
            MAX = safe;
        }
    }
}

/* 0행부터 순회, 0을 가장 많이 가지도록
 * 2주변을 1이 감싸도록 2주변에서 0 => 2, 1 => 1,
 * 1, 0, 2로 둘러싸인 영역에서 0의 개수
 */