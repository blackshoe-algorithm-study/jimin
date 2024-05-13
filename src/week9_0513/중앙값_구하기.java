package week9_0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 중앙값_구하기 {
    static StringBuilder sb;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //테스트케이스 개수
        sb = new StringBuilder();
        StringTokenizer str;

        // 한줄에 10개씩 입력받음
        for(int i=0; i<T; i++){
            int num = Integer.parseInt(br.readLine()); //배열개수
            PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            if(num<=10) { // 한줄인 경우
                str = new StringTokenizer(br.readLine());
                for(int j=0; j<num; j++){
                    int temp = Integer.parseInt(str.nextToken());
                    max.offer(temp);
                    min.offer(temp);
                    single(max, min, j);
                }
            }else{ // 여러 줄인 경우
                int row = num / 10 + 1;
                int col = num % 10;
                for(int r=0; r<row; r++){
                    str = new StringTokenizer(br.readLine());
                    for(int c=0; c<col; c++){
                        int temp = Integer.parseInt(str.nextToken());
                        max.offer(temp);
                        min.offer(temp);
                    }
                }
            }
        }
        System.out.println(sb);
    }
    // 인덱스가 커질수록 비교하는 함수
    static void single(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int index){
        //size: 전체 pq크기 , index: 현재 인덱스
        while(!min.isEmpty()){
            if(max.peek() > min.peek()){
                int temp1 = max.poll();
                int temp2 = max.poll();
                max.offer(temp2);
                min.offer(temp1);
            }
        }
        if(index %2 != 0){
            sb.append(max.peek()+"\n");
        }
    }
    // 전체 입력받은 후 중앙값
    static void all(PriorityQueue<Integer> pq, int size){

    }
}

// 입력할때마다 가운데값
// 우선순위 큐의 가운데값
// pq.size/2 -> 1~인덱스만큼 poll