package week15_0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주몽 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); //재료의 개수
        int M = Integer.parseInt(br.readLine()); //갑옷만드는데 필요한 수
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
//                if(arr)
            }
        }
    }
}
