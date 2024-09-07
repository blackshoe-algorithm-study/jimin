package week5_0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무_자르기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.print(lowerBound(arr[0], arr[N-1], arr, M));
    }
    private static int lowerBound(int low, int high, int[] arr, int K){
        int answer=high, l=low, r=high, mid;

        while(l <= r){
            mid = (l+r)/2; // 자를 나무의 길이
            int len = lengthSum(arr, mid);

            if(len < K){ // 자른 나무의 길이의 합이 원하는 것보다 작음, 기준이 될 값이 더 작아야함
                r = mid-1;
            }else{
                answer = mid;
                l = mid+1;
            }
        }

        return answer;
    }
    private static int lengthSum(int[] arr, int mid){
        int sum = 0;
        for(int i: arr){
            if(i > mid){
                sum += (i - mid);
            }
        }
        return sum;
    }
}

/* 구간: [최소값, 최대값]

* */