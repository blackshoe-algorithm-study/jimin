package week16_0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //n개의 도시
        int M = Integer.parseInt(br.readLine()); //m개의 버스
        int[][] dp = new int[N+1][N+1];
        int INF = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++){
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dp[u][v] = Math.min(w, dp[u][v]);
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(dp[i][k] != INF && dp[k][j] != INF){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(dp[i][j] == INF){
                    dp[i][j] = 0;
                }
                sb.append(dp[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
