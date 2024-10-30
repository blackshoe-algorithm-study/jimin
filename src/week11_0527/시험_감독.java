package week11_0527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험_감독 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] stu = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            stu[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = 0;
        if(st.hasMoreTokens()){
            C = Integer.parseInt(st.nextToken());
        }
        long ans = N;
        for(int i=0; i<N; i++){
            int cur = stu[i] - B;
            if(cur <= 0) continue;
            ans += cur/C + (cur%C==0 ? 0 : 1);
        }
        System.out.print(ans);
    }
}
