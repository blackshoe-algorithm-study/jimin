package week6_0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운_계단_수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = 1000000000;
        int[] dp = new int[101];
        dp[1] = 9;

    }
}
/** 1 ~ 9 : 9
 *  10 12 21 23 32 34 ... 98 => 2*9-1 = 17
 *  10(1) 12(2)... 98(2)
 *  0=>1, 1=>2, ..., 8=>2, 9=>1
 * dp[n] : 길이가 N인 계단수의 개수
 */
