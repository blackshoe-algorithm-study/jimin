package week6_0424;

import java.io.*;
import java.util.*;

class ex{
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = dp[1] = 0;
        System.out.print(recur(N));

    }
    public static int recur(int N){
        if(dp[N] == 0 && N!=1){
            if(N%6 ==0){
                dp[N] = Math.min(recur(N/3), Math.min(recur(N/2), recur(N-1))) + 1;
            }else if(N%3 == 0){
                dp[N] = Math.min(recur(N/3), recur(N-1)) + 1;
            }else if(N%2 == 0){
                dp[N] = Math.min(recur(N/2), recur(N-1)) + 1;
            }else{
                dp[N] = recur(N-1) + 1;
            }
        }
        return dp[N];
    }
}
