package week9_0515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Jewelry{
    int mass;
    int price;
    Jewelry(int mass, int price){
        this.mass = mass;
        this.price = price;
    }
}
public class 보석_도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewelry[] jewelrs = new Jewelry[N];
        int[] bags = new int[K];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelrs[i] = new Jewelry(u, v);
        }
        for(int i=0; i<K; i++){
            int weight = Integer.parseInt(br.readLine());
            bags[i] = weight;
        }
        Arrays.sort(bags);
        Arrays.sort(jewelrs, ((o1, o2) -> o1.mass - o2.mass));
        PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);

        long sum = 0; int idx = 0;
        for(int bag: bags){
            while(idx<N && jewelrs[idx].mass <= bag){
                pq.offer(jewelrs[idx]);
                idx++;
            }
            if(!pq.isEmpty()){
                sum += pq.poll().price;
            }
        }
        System.out.print(sum);
    }
}
