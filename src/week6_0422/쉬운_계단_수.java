package week6_0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운_계단_수 {

    static long K = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10]; // 0번: 자릿수, 1번: 끝나는 숫자
        for(int i=1; i<10; i++){
            dp[1][i] = 1L; // 한자릿수일때는 가능한 모든 수가 1개이다.
        }
        for(int i=2; i<=N; i++){ // i => 몇자릿수?
            for(int j=0; j<10; j++){
                if(j == 0){
                    dp[i][0] = dp[i-1][1] % K;
                }else if(j == 9){
                    dp[i][9] = dp[i-1][8] % K;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % K;
                }
            }
        }
        long answer = 0L;
        for(int i=0; i<10; i++){
            answer += dp[N][i];
        }
        System.out.print(answer % K);
    }
}
/** 1~8: 2, 0-9: 1
 1) i 가 0 또는 9 일때
 dp[n][0] = dp[n-1][1]
 dp[n][9] = dp[n-1][8]
 2) i 가 그 외의 숫자일때
 dp[n][i] = dp[n-1][i-1] + dp[n-1][i+1]
 */
