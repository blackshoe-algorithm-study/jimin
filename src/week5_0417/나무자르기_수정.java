package week5_0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //나무 개수
        int M = Integer.parseInt(st.nextToken()); //전체 자른 나무 길이합
        st = new StringTokenizer(br.readLine());
        int[] branches = new int[N];
        for(int i=0; i<N; i++){
            branches[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(branches);

        System.out.print(binarySearch( branches, M, N));
    }
    private static int binarySearch( int[] arr, int K, int N){
        int l =0, r=1000000000;
        while(l < r){
            int m = (l+r+1)/2;
            long sum = 0;
            for(int i=0; i<N; i++) sum += arr[i] > m ? arr[i] - m : 0;
            if(sum >= K) l = m;
            else r = m-1;
        }
        return l;
    }
}
