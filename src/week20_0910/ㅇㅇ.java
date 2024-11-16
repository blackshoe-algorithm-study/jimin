package week20_0910;

import java.util.Arrays;

public class ㅇㅇ {
    public int solution(String num, int k) {
        int n = num.length();
        long[][] dp = new long[n + 1][k + 1];
        long MOD = 1000000007;

        // DP 초기화
        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        dp[0][0] = 0;

        // DP 채우기
        for (int i = 1; i <= n; i++) { // i는 현재까지 고려한 문자열 길이
            for (int j = 0; j <= k; j++) { // j는 사용한 + 기호의 개수
                for (int l = 1; l <= i; l++) { // l은 현재 잘라낼 문자열의 길이
                    if (j > 0 && dp[i - l][j - 1] != Long.MAX_VALUE) {
                        String sub = num.substring(i - l, i); // 부분 문자열
                        long value = Long.parseLong(sub); // 숫자로 변환
                        dp[i][j] = Math.min(dp[i][j], dp[i - l][j - 1] + value);
                    }
                }
            }
        }

        // 최종 결과
        return (int) (dp[n][k] % MOD);
    }

    public static void main(String[] args) {
        ㅇㅇ solver = new ㅇㅇ();

        // 예제 입력
        String num = "1234567";
        int k = 2;

        // 출력
        System.out.println(solver.solution(num, k)); // 예: 123 + 45 + 67 = 235
    }
}
