package week15_0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 설탕_배달 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int div = test/5;
        int cnt = 0;
        for(int i=div; i>=0; i--){
            if((test-5*i)%3 == 0){
                cnt = cnt + i + (test-5*i)/3;
                break;
            }
        }
        if(cnt == 0){
            cnt = -1;
        }
        System.out.print(cnt);
    }
}

/* 요구사항:3kg | 5kg + 최대한 적은 봉지
* (test) - 5*a % 3 == 0 인지 확인 => a는 최대한 크게
* a => (test)/5 , a--, 만약 a=0이 될때까지 안되면 -1 반환
* */