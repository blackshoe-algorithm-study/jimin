package week5_0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 배열_합치기 {
    static int[] tmp;
    static int[] ans;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 배열A의 크기
        int M = Integer.parseInt(str.nextToken()); // 배열B의 크기
        ans = new int[N+M];
        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num1 = Integer.parseInt(str.nextToken());
            ans[i] = num1;
        }
        str = new StringTokenizer(br.readLine());
        for(int j=0; j<M; j++){
            int num2 = Integer.parseInt(str.nextToken());
            ans[N+j] = num2;
        }

        tmp = new int[N];
        mergeSort(0, N);
        for(int i=0; i< ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
    public static void mergeSort( int l, int r){
        if(r-l == 1) return;// 연속된 배열인 경우 반환
        int m = (l+r)/2;
        mergeSort( l, m);
        mergeSort( m, r);

        int lp = l, rp = m;
        for(int i=l; i<r; i++){
            if(rp == r || (lp < m && ans[lp] < ans[rp])) tmp[i] = ans[lp++];
            else tmp[i] = ans[rp++];
        }
        for(int i=l; i<r; i++) ans[i] = tmp[i];
    }

}

//