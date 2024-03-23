package week1_0320;

import java.io.*;

public class 문자열_반복 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test = Integer.parseInt(br.readLine()); // 처음 입력받는 테스트케이스 개수
        for(int i=0; i<test; i++){
            String line = br.readLine();
            String[] arr = line.split(" ");

            int r = Integer.parseInt(arr[0]); // 테스트 케이스 각각의 반복횟수 r
            String word = arr[1]; // 반복할 단어
            for(int j=0; j<word.length(); j++){
                String A = "" + word.charAt(j);
                sb.append(A.repeat(r));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
