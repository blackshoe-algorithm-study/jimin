package week28_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전_1 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] values = new int[n];

        for(int i=0; i<n; i++){
            values[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(values); // 오름차순 정렬

        int[] dp = new int[k+1];
        dp[0] = 1;

        for(int coin : values){
            for(int i=coin; i<=k; i++){
                dp[i] += dp[i-coin];
            }
        }

        System.out.print(dp[k]);
    }
}
