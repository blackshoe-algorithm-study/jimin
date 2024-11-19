package week29_1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주식 {
    static int[] days;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            days = new int[N];
            for (int i = 0; i < N; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            if (judgeArr()) {
                sb.append(0).append("\n");
                continue;
            }

            long res = func();
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    // 배열이 내림차순인지 판단 : T) 내림차순 F) 아님
    static boolean judgeArr() {
        for (int i = 0; i < N - 1; i++) {
            if (days[i] < days[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // 그리디 알고리즘
    static long func() {
        long maxProfit = 0; // 최대 이익
        int maxPrice = 0; // 지금까지 최대 주가

        for (int i = N - 1; i >= 0; i--) {
            if (days[i] > maxPrice) {
                maxPrice = days[i];
            } else {
                maxProfit += maxPrice - days[i];
            }
        }

        return maxProfit;
    }
}
