package week3_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<Integer, Integer> hmap = new HashMap<>(); //max 값과 그 인덱스를 넣는게 나으려나
        int i=1;
        arr[0] = Integer.parseInt(str.nextToken());
        int temp = arr[0]; // 첫번째 비교대상 (0번)
        while(i<W){ // 0 1 2
            arr[i] = Integer.parseInt(str.nextToken()); //(1번)

            if(temp != arr[i]){ //temp가 그대로인 경우

            }
        }


    }
}

// 세로: H, 가로: W
// 0번 인덱스부터 "정점"에 위치하고 내림차순일때 -> 골짜기 생성 -> "정점"보다 크거나 같은 수가 나타남
// 골짜기는 여러개 생성될 수 있음!
// 물의 깊이는 두 "정점" 중 (작은 수) - (정점 사이 수)