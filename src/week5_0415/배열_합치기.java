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

        StringBuilder sb = new StringBuilder();
        Arrays.sort(ans);
        for(int i=0; i<ans.length; i++){
            sb.append(ans[i]).append(' ');
        }
        System.out.print(sb);
    }
}
