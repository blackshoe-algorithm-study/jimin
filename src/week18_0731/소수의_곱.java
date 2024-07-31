package week18_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 소수의_곱 {
    static long[] prime;
    static PriorityQueue<Long> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); //K개의 소수
        int N = Integer.parseInt(st.nextToken()); //N번째 소수
        st = new StringTokenizer(br.readLine());
        prime = new long[K];
        queue = new PriorityQueue<>();
        for(int i=0; i<K; i++){
            prime[i] = Long.parseLong(st.nextToken());
            queue.add(prime[i]);
        }
        long value = 0;
        while(N -- > 0){
            value = queue.poll();
            for (int i = 0; i < K; i++) {
                long nextValue = value * prime[i];
                if (nextValue >= (1L << 31)) { // 2^31을 초과하지 않도록 체크
                    break;
                }
                queue.add(nextValue);
                if (value % prime[i] == 0) {
                    break;
                }
            }
        }
        System.out.print(value);
    }
}
