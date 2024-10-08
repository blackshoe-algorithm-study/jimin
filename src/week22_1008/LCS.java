package week22_1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();

        dp = new int[str1Char.length+1][str2Char.length+1];

        for(int i=1; i<=str1Char.length; i++){
            for(int j=1; j<=str2Char.length; j++){
                if(str1Char[i-1] == str2Char[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.print(dp[str1Char.length][str2Char.length]);
    }
}

/* dp[i] => Math.max(dp[i-1], 자기자신까지 합한 부분수열)
* */