package week11_0527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] city = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(city);
        int M = Integer.parseInt(br.readLine());
        int l = 0; int r = city[N-1];
        int limit = 0;
        while(l<=r){
            int sum = 0;
            int mid = (l+r)/2;
            for(int budget : city){
                sum += Math.min(budget, mid);
            }
            int diff = M - sum;
            if(diff == 0){
                limit = mid;
                break;
            }else if(diff > 0){
                limit = Math.max(limit, mid);
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        System.out.print(limit);
    }
}
