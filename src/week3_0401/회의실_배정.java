package week3_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회의실_배정 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수
        StringTokenizer str;
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        Arrays.sort(arr); // 오름차순으로 정렬된 2차원 배열

        LinkedList<Integer> ans = new LinkedList<>(); // 정답을 넣는 배열

//        int i=0;
//        int count = 0;
//        while(i < N){
//            int compare = arr[i++][1];
//            if(compare <= arr[i][0]){
//                count ++;
//            }
//        }
        int count = 0;
        for(int i=0; i<N; i++){
            int compare = arr[i][1];
            int j=i+1;
            while(j<N){
                if(compare <= arr[j][0]) count ++;
            }
            ans.add(count);
        }
        Collections.sort(ans, Collections.reverseOrder());
        System.out.println(ans.get(0));
    }
}
