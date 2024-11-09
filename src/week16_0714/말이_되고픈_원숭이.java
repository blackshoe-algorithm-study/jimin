package week16_0714;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이_되고픈_원숭이 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] hy = {-2, 2, -1, 1, -2, 2, -1, 1};
    static int K, W, H;
    static int[][] map;
    static int[][][] dist;
    static int INF = Integer.MAX_VALUE;
    static class State{
        int x, y, k, moves;
        State(int x, int y, int k, int moves){
            this.x = x;
            this.y = y;
            this.k = k;
            this.moves = moves;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist = new int[H][W][K+1];
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                Arrays.fill(dist[i][j], INF);
            }
        }

        bfs();

        int ans = INF;
        for(int i=0; i<=K; i++){
            ans = Math.min(ans, dist[H-1][W-1][i]);
        }

        System.out.print(ans==INF ? -1 : ans);
    }
    static void bfs(){
        Queue<State> q = new LinkedList<>();
        dist[0][0][K] = 0;
        q.add(new State(0, 0, K, 0));

        while(!q.isEmpty()){
            State current = q.poll();
            int x = current.x;
            int y = current.y;
            int k = current.k;
            int moves = current.moves;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
                if(map[nx][ny] == 0 && dist[nx][ny][k] > moves+1){
                    dist[nx][ny][k] = moves+1;
                    q.add(new State(nx, ny, k, moves+1));
                }
            }

            if(k>0){
                for(int i=0; i<8; i++){
                    int nx = x + hx[i];
                    int ny = y + hy[i];
                    if(nx<0 || ny<0 || nx>=H || ny>=W) continue;
                    if(map[nx][ny] == 0 && dist[nx][ny][k-1] > moves+1){
                        dist[nx][ny][k-1] = moves+1;
                        q.add(new State(nx, ny, k-1, moves+1));
                    }
                }
            }
        }
    }
}
