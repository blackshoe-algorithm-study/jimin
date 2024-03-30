package week2_0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 최소_힙 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //입력받을 연산 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //입력값을 넣을 큐

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine()); //입력받은 숫자
            if(num>0){
                pq.offer(num);
            }

            if(pq.size()>0 && num == 0){
                int print = pq.poll();
                System.out.println(print);
            }else if(pq.size()==0 && num == 0){
                System.out.println(0);
            }
        }

    }

}

// 최소힙 -> 우선순위큐
// x가 자연수 : 배열에 x 추가
// x가 0 : 배열에서 가장 작은 값 출력 + 제거