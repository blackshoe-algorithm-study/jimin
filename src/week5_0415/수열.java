package week5_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수열 {
    static int N, K;
    static int[] arr;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 배열
        K = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = slidingWindow();
        System.out.print(ans);
    }
    private static int slidingWindow(){
        int sum = 0;
        int cnt = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<K; i++){
            sum += arr[i];
        } // 초기값 설정
        maxSum = sum;
        for(int i=K; i<N; i++){
            sum = sum+arr[i]-arr[i-K];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
