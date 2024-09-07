package week6_0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //수열의 크기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int len = 0;
        for(int i=0; i<N; i++){
            int idx = 0;
            int[] dp = new int[N];
            dp[idx] = arr[i];
            for(int j=i+1; j<N; j++){
                if(dp[idx] < arr[j]){
                    dp[++idx] = arr[j];
                }
            }
            len = Math.max(len, idx+1);
        }
        System.out.print(len);
    }
}
