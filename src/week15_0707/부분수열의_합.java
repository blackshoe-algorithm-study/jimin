package week15_0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 부분수열의_합 {
    static HashSet<Integer> sums;
    static int[] arr;
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        sums = new HashSet<>();
        dfs(0, 0);

        int ans = 1;
        while(sums.contains(ans)){
            ans ++;
        }
        System.out.println(ans);
    }
    public static void dfs(int index, int sum){
        if(index == N){
            sums.add(sum);
            return;
        }
        dfs(index +1, sum+arr[index]);
        dfs(index+1, sum);
    }
}

/* 우선순위 큐? -> 1부터 pop 해서 연속된 숫자가 아닌 경우 종료, 연속된 숫자가 아닌 지점
* 배열 순회하면서 큐에 수열의 합 삽입
* */