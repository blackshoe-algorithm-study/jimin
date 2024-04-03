package week3_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실_배정 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //회의 개수
        StringTokenizer str;
        int[][] arr = new int[N][2]; //회의 시작시간과 종료시간 담은 2차원 배열

        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(str.nextToken()); // 시작시간 입력
            arr[i][1] = Integer.parseInt(str.nextToken()); // 종료시간 입력
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1]; // 종료 시간을 기준으로 오름차순 정렬
            } else {
                return o1[0] - o2[0]; // 시작 시간을 기준으로 오름차순 정렬
        } }); // 종료시간을 기준으로 오름차순 정렬


        int i=0;
        int cnt = 1;
        int end = arr[i][1];

        for (i = 1; i < N; i++) {
            if(end <= arr[i][0]) {
                end = arr[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
