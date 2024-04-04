package week3_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법_변환 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        String line = str.nextToken();
        char[] num = line.toCharArray(); // 위에서 입력받은 애를 char 배열로
        int B = Integer.parseInt(str.nextToken());

        int sum = 0;
        int temp = 0;
        for(int i=num.length-1; i>=0; i--){
            if(num[i] - 65 >= 0){ // 대문자인 경우
                int k = num[i] - 55;
                sum += k * (int)Math.pow(B, temp);
            }else{ // 숫자인 경우
                int k = num[i] - '0';
                sum += k * (int)Math.pow(B, temp);
            }
            temp ++;
        }

//        System.out.println(Integer.parseInt(line, B));
        System.out.println(sum);
    }
}

// 주어진 수를 B 진법으로 변환하여 출력
// 마지막 index 부터 차근차근 36 의 진법으로
// 아스키코드 상에서 A=65 -> 10 (-55), a=97
// 오른쪽부터