package week16_0724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 역사 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사건의 개수
        int k = Integer.parseInt(st.nextToken()); // 사건전후 관계의 개수
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(dp[i], 0);
        }

        for(int i=1; i<=k; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            dp[u][v] = -1; // u가 v 보다 먼저 일어남
            dp[v][u] = 1; // v가 u 보다 먼저 일어남
        }

        for(int m=1; m<=n; m++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dp[i][m] == -1 && dp[m][j] == -1){
                        dp[i][j] = -1;
                    }
                    if(dp[i][m] == 1 && dp[m][j] == 1){
                        dp[i][j] = 1;
                    }
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a][b] + "\n");
        }

        System.out.print(sb);

    }
}

/* [i][j] = 1
[i][m]
[j][i] = -1
[j][m] = 1
[m][i]
[m][j] = -1

j i
m j

*
* */