package week6_0424;

import java.io.*;
import java.util.StringTokenizer;

public class _1_로_만들기 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 주어진 수
        dp = new int[N + 1]; //1번부터 N번까지
        dp[0] = 0; dp[1] = 0;
        System.out.print(recur(N));
    }
    private static int recur(int N){
        if(dp[N] == 0 && N!=1){
            if(N%6 == 0){ // N이 6의 배수인 경우
                dp[N] = Math.min(recur(N/3), Math.min(recur(N/2), recur(N-1))) + 1;
            }else if(N%3 == 0){ //N이 3의 배수인 경우
                dp[N] = Math.min(recur(N/3), recur(N-1)) + 1;
            }else if(N%2 == 0){ //N이 2의 배수인 경우
                dp[N] = Math.min(recur(N/2), recur(N-1)) + 1;
            }else{ // 그 외의 경우
                dp[N] = recur(N-1) + 1;
            }
        }
        return dp[N];
    }
}

/* 재귀 호출하는 방식으로, 일단 N보다 이전 연산을 안다고 가정하자.
* */