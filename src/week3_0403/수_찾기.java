package week3_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수_찾기 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.parseInt(br.readLine()); // N 개의 첫 자연수
        int[] arrN = new int[N]; // 비교 당할 배열
        str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrN[i] = Integer.parseInt(str.nextToken());
        }
        int M = Integer.parseInt(br.readLine()); // M 개의 다음 자연수
        str = new StringTokenizer(br.readLine());
        int[] arrM = new int[M]; // 같이 비교할 대상
        for(int i=0; i<M; i++){
            arrM[i] = Integer.parseInt(str.nextToken());
        }

        find(arrN, arrM);
        System.out.print(sb);
    }
    public static void find(int[] arrN, int[] arrM){
        for(int i=0; i<arrM.length; i++){
            boolean flag = false;
            for(int j=0; j<arrN.length; j++){
                if(arrM[i]==arrN[j]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }
    }
}

// 범위가 2^31 => double
// N[] 에 M[] 이 있는지 -> 완탐 또는 재귀
// arraylist 반환해서 하니까 -> 시간 초과
// solution: sb 로 답안을 출력하도록 했음