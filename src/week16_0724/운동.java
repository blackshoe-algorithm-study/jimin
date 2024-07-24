package week16_0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 운동 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); //v개의 마을
        int E = Integer.parseInt(st.nextToken()); //e개의 도로
        int[][] dp = new int[V+1][V+1];
        int INF = Integer.MAX_VALUE;
        for(int i=1; i<=V; i++){
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }
        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dp[u][v] = Math.min(w, dp[u][v]);
        }

        for(int k=1; k<=V; k++){
            for(int i=1; i<=V; i++){
                for(int j=1; j<=V; j++){
                    if(dp[i][k] != INF && dp[k][j] != INF){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        int length = Integer.MAX_VALUE;
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(dp[i][j] != INF && dp[j][i] != INF && i!=j){
                    length = Math.min(length, dp[i][j] + dp[j][i]);
                }
            }
        }

        if(length == INF){
            length = -1;
        }

        System.out.print(length);

    }
}

/* 도로: 일방통행(단방향)
운동을 한후 다시 시작점으로 돌아오는 사이클이 필요함 !!
* */