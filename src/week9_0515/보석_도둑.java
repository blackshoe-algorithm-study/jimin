package week9_0515;

import java.io.BufferedReader;
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
    static int N, K;
    static Jewelry[] jewels;
    static int[] bags;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        jewels = new Jewelry[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); //무게
            int v = Integer.parseInt(st.nextToken()); //가격
            jewels[i] = new Jewelry(u, v);
        }
        bags = new int[K];
        for(int i=0; i<K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대힙

    }
}
