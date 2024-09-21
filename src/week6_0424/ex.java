package week6_0424;

import java.io.*;
import java.util.*;

class ex{
    static int[][] home;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 집의 개수
        home = new int[N][3];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N+1]; //0번: 몇번째 줄인지, 1번: 처음 시작하는 수
        for(int i=0; i<3; i++){
            dp[1]=i; // dp[1]은 정해짐

        }

    }
    private static void recur(int N){ //재귀 호출로 dp 값 채워넣기
        for(int i=2; i<=N; i++){
            for(int j=0; j<3; j++){

            }
        }
    }
}

/*
i=1 => dp[2]가 아닌 index 중 Math.min 값
i=N => dp[N-1]가 아닌 index 중 Math.min 값
* */