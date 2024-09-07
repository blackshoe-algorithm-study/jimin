package week6_0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치_수 {
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        System.out.print(downDP(n));

    }
    private static int downDP(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        return downDP(n-1) + downDP(n-2);
    }
    private static int upDP(int n){
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

/* n개의 개수가 있는것
* */