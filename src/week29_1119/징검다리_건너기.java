package week29_1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 징검다리_건너기 {
    static int N, K;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // 1번부터 (N-1)번 돌까지의 작은 에너지, 큰 에너지
        arr = new int[Math.max(4, N)][2];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());

        dp = new int[Math.max(4, N+1)][2];
        for (int i = 0; i <dp.length; i++) Arrays.fill(dp[i], 10000);

        dp[0][0] = dp[0][1] = dp[1][0] = dp[1][1] = 0;
        // 2번까지 오는데 소비한 에너지
        dp[2][0] = arr[1][0];
        // 3번까지 오는데 소비한 에너지
        dp[3][0] = Math.min(dp[2][0] + arr[2][0], arr[1][1]);


        for (int i = 4; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + arr[i - 1][0], dp[i - 2][0] + arr[i - 2][1]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][1] + arr[i - 1][0], dp[i - 2][1] + arr[i - 2][1]), dp[i - 3][0] + K);
        }


        int res = Math.min(dp[N][0], dp[N][1]);
        System.out.print(res);
    }
}
