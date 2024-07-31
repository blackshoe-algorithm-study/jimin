package week18_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 세_용액 {
    static long[] liquids, pick;
    static long MAX = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //N개의 용액
        StringTokenizer st = new StringTokenizer(br.readLine());
        liquids = new long[N];
        pick = new long[3];
        for(int i=0; i<N; i++){
            liquids[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(liquids);

        for(int i=0; i<N-2; i++){
            binarySearch(i); // 하나의 용액을 지정하고 나머지 두개의 용액을 가변
        }
        Arrays.sort(pick);
        for(int i=0; i<3; i++){
            System.out.print(pick[i] + " ");
        }
    }
    static void binarySearch(int index){
        int left = index+1;
        int right = liquids.length-1;

        while(left < right){
            long sum = liquids[left] + liquids[right] + liquids[index];
            long abs = Math.abs(sum);
            if(abs < MAX){ //abs 가 더 0에 가까운 경우
                MAX = abs;
                pick[0] = liquids[left];
                pick[1] = liquids[right];
                pick[2] = liquids[index];
            }
            if(sum > 0){
                right --;
            }else{
                left ++;
            }
        }
    }
}

/* 산성 - 양의 정수, 알칼리성 - 음의 정수

* */