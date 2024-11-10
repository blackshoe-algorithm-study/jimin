package week19_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 감소하는_수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N > 1022){
            System.out.print(-1);
            return;
        }

        Queue<Long> queue = new LinkedList<>();
        for(int i=0; i<=9; i++){
            queue.add((long)i);
        }

        int count = -1;
        long current = 0;

        while(!queue.isEmpty()){
            current = queue.poll();
            count ++;

            if(count == N){
                System.out.println(current);
                return;
            }

            for(int i=0; i<current%10; i++){
                queue.offer(current*10 + i);
            }
        }
    }
}
