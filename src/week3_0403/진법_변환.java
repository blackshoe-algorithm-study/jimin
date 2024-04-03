package week4_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법_변환 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        String line = str.nextToken(); //B 진법 수
        int B = Integer.parseInt(str.nextToken());



        for(int i=line.length()-1; i>=0; i--){
            //문자면 - 'A'
            //숫자면 그대로
            char want = line.charAt(i);
            if(Character.isDigit(want)){ // 문자면
                int num = want - 'A';
                System.out.println(num);

            }else{
                int num = want - '0';
                System.out.println(num);
            }
        }

    }
}

// 주어진 수를 B 진법으로 변환하여 출력
// 마지막 index 부터 차근차근 36 의 진법으로