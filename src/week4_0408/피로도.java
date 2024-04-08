package week4_0408;

import java.io.*;
import java.util.*;

public class 피로도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(str.nextToken());
        int B = Integer.parseInt(str.nextToken());
        int C = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        int fatigue = 0;
        int work = 0;

        for (int i = 0; i < 24; i++) {
            fatigue += A;
            work += B;
            if (fatigue > M) { //쉬는시간
                fatigue = fatigue - A - C; // 첫번째 쉬는시간
                work -= B;

                if(fatigue < 0) {
                    fatigue = 0;
                }
            }
        }
        System.out.print(work);
    }
}

//1시간 -> 피로)A 일)B 쉼)-C <=M (24시간) 0<= <=24
// A B C M