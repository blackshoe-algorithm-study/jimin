package week3_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(str.nextToken()); // 세로길이
        int W = Integer.parseInt(str.nextToken()); // 가로길이

        str = new StringTokenizer(br.readLine());
        int[] arr = new int[W]; // 2세계 배열
        //한쪽 비교가 아니라 양쪽비교라 힘들듯
        for(int i=0; i<W; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        //좌우 비교
        int sum = 0;
        for(int i=1; i<W-1; i++){ //처음과 마지막은 제외
            int left=0; int right=0;
            for(int j=0; j<i; j++){
                left = Math.max(arr[j], left);
            }
            for(int j=i+1; j<W; j++){
                right = Math.max(arr[j], right);
            }
            if(arr[i]<left && arr[i]<right) sum += Math.min(left, right) - arr[i];
        }

        System.out.println(sum);
    }
}

// 세로: H, 가로: W
// 0번 인덱스부터 "정점"에 위치하고 내림차순일때 -> 골짜기 생성 -> "정점"보다 크거나 같은 수가 나타남
// 골짜기는 여러개 생성될 수 있음!
// 물의 깊이는 두 "정점" 중 (작은 수) - (정점 사이 수)
// 양옆의 값들중 큰 값이면..