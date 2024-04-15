package week5_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수열 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 정수 개수
        int K = Integer.parseInt(str.nextToken()); // 연속할 수 개수
        int[] arr = new int[N];
        str= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int sum = 0;
            if(i+K < N){
                for(int j=i; j<i+K; j++){
                    sum += arr[j];
                }
                queue.offer(sum);
            }
            if(!queue.isEmpty()) {
                int numA = queue.poll();
                max = Math.max(numA, max);
            }
        }
        System.out.println(max);

    }
}
