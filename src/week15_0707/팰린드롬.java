package week15_0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 팰린드롬 {
    static int N, M;
    static int[] hong;
//    static int[][] que;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); //칠판에 적은 개수
        hong = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            hong[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine()); //질문 개수
        for(int j=0; j<M; j++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(answer(start,end));
            sb.append('\n');
        }
        System.out.print(sb);
    }
    private static int answer(int start, int end){
        while(start<end){
            if(hong[start] != hong[end]){
                return 0;
            }
            start ++;
            end --;
        }
        return 1;
    }
}

/* 홍준이: 자연수 N개, 질문 M번
질문: S~E 까지의 수가 팰린드롬? -> 답변: Y, N
S-1번째 index ~ E-1번째 index 까지
* */