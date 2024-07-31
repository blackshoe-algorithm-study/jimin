package week18_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 랜선_자르기 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        int MAX = 0;
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            MAX = Math.max(MAX, arr[i]);
        }

        System.out.print(binarySearch(1, MAX));
    }
    public static int binarySearch(int low, int high){
        int result = 0;
        while(low < high){
            int mid = (low + high) / 2;
            if(N <= check(mid)){ // mid 값으로 자른 개수가 더 많거나 같은 경우
                result = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
    public static int check(int key){
        int cnt =0;
        for(int i=0; i<arr.length; i++){
            cnt += arr[i]/key;
        }
        return cnt;
    }
}

/* N: 만들어야하는 랜선개수 K: 오영식이 자체적으로 가지고 있는 랜선개수
K -> N 개의 같은 길이의 랜선
이분탐색을 해서 찾아지는 key값으로 나눈 Math.floor 값들의 합이 11보다 크거나 같은 경우 => true
* */
