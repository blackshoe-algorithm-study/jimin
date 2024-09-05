package week5_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 소수의_연속합 {
    static int size;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] primes = primesArray(N);
        int right = size-1; int left = 0;
        int sum = 0;
        for(int i=0; i<size; i++){
            sum += primes[i]; // 초기 소수의 전체 배열의 합
            System.out.print(primes[i] + " ");
        }
        System.out.print("\n");
        int cnt = 0;
        for(int i=size-1; i>0; i--){
            int partSum = sum;
            for(int j=0; j<=i; j++){
                partSum -= primes[j];
                if(partSum == N){
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
    private static int[] primesArray(int N){ //소수인 수만 따로 넣는 배열 - 에라토스테네스의 체
        if(N==1) return new int[0];
        boolean[] arr = new boolean[N+1]; // 1번 index부터 N번 index까지
        Arrays.fill(arr, true); // 초기값: 모두 true
        arr[0] = arr[1] = false;
        size = N-1;
        for(int i=2; i*i<=N; i++){
            if(!arr[i]) continue;
            for(int j=i*i; j<=N; j+=i){
                if(arr[j]){
                    arr[j] = false;
                    size--;
                }
            }
        }
        int[] ans = new int[size];
        int idx = 0;
        for(int i=2; i<=N; i++){
            if(arr[i]) ans[idx++] = i;
        }
        return ans;
    }
}

/*
* */