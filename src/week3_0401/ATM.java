package week3_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //n명의 사람들
        int[] arr = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(arr); //작은 수부터 정렬
        int k = N;
        int sum = 0;
        for(int j=0; j<N; j++){
            sum = sum + arr[j] * (k--);
        }

        System.out.println(sum);
    }
}

// n명의 사람들 (1~n)
// 1~n 에 해당하는 번호 p1~pn
// 전체 시간합의 최솟값
// 작은 수대로 정렬 한담에 *5 *4 ~