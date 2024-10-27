package week9_0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 중앙값_구하기 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int M = Integer.parseInt(br.readLine());
            arr = new int[M+1];
            if(M <= 10){
                st = new StringTokenizer(br.readLine());
                for(int i=1; i<=M; i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }else{
                int line = M/10; int idx = 1;
                for(int i=1; i<=line; i++){
                    st = new StringTokenizer(br.readLine());
                    while(st.hasMoreTokens()){
                        arr[idx++] = Integer.parseInt(st.nextToken());
                    }
                }
                st = new StringTokenizer(br.readLine());
                for(int i=idx; i<=M; i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }

            int count = (M+1)/2;
            sb.append(count).append("\n");
            if(count <= 10){
                for(int i=1; i<=M; i=i+2){
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    for(int j=1; j<=i; j++){
                        pq.offer(arr[j]);
                    }
                    sb.append(medium(pq, i)).append(" ");
                }
                sb.append("\n");
            }else{
                int idx = 0;
                for(int i=1; i<=M; i=i+2){
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    for(int j=1; j<=i; j++){
                        pq.offer(arr[j]);
                    }
                    idx++;
                    sb.append(medium(pq, i)).append(" ");
                    if(idx>=10){
                        idx=0;
                        sb.append("\n");
                    }
                }
            }

        }
        System.out.print(sb);
    }
    static int medium(PriorityQueue<Integer> pq, int idx){
        int target = (idx+1)/2;
        int num = 0;
        for(int i=1; i<=target; i++){
            num = pq.poll();
        }
        return num;
    }
}