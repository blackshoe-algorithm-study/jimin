package week5_0415;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class 소수의_연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] primeArr = getPrimesLessThan(n);

        int s=0, e=0;
        int curSum = primeArr.length == 0? 0 : primeArr[0];
        int cnt = 0;
        while(s<primeArr.length) {
            if(curSum == n) {
                cnt++;
                curSum-=primeArr[s];
                s++;
            } else if(curSum > n) {
                curSum-=primeArr[s];
                s++;
            } else {
                if(e>=primeArr.length-1) {
                    curSum-=primeArr[s];
                    s++;
                } else {
                    e++;
                    curSum+=primeArr[e];
                }
            }
        }
        System.out.print(cnt);
    }

    static int[] getPrimesLessThan(int n) {
        if(n==1) return new int[0];
        boolean[] prime = new boolean[n+1];
        int size = n-1;
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i=2; i*i<=n; i++) {
            if(!prime[i]) continue;
            for(int j=i*i; j<=n; j+=i) {
                if(prime[j]) {
                    prime[j] = false;
                    size--;
                }
            }
        }

        int[] result = new int[size];
        int idx = 0;
        for(int i=2; i<=n; i++) {
            if(prime[i]) result[idx++] = i;
        }
        return result;
    }
}

/*
* */