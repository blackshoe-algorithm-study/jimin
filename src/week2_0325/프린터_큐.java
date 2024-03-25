package week2_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터_큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        StringTokenizer str;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine()); //ex) 1 0
            int docs = Integer.parseInt(str.nextToken()); // 문서의 개수
            int want = Integer.parseInt(str.nextToken()); // 원하는 문서의 번호
            int[] arr = new int[docs]; // 문서의 중요도 순서


        }

    }
}
