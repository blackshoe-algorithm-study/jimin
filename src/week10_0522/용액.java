package week10_0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class 용액 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine()); //전체 용액의 수
        int[] liquid = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0; int r = N-1;
        int[] ans = new int[2];
        int nearby = Integer.MAX_VALUE;
        while(l < r){
            int sum = liquid[l] + liquid[r];
            if(Math.abs(nearby) > Math.abs(sum)){
                nearby = sum;
                ans[0] = liquid[l];
                ans[1] = liquid[r];
            }

            if(sum > 0) {
                r--;
            }else if(sum < 0){
                l++;
            }else{
                ans[0] = liquid[l];
                ans[1] = liquid[r];
                break;
            }
        }

        System.out.print(ans[0] + " " + ans[1]);
    }
}
