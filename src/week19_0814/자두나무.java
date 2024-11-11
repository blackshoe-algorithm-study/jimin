package week19_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 자두나무 {
    static int T, W;
    static class Plum{
        int pos, time, limit;
        Plum(int pos, int time, int limit){
            this.pos = pos;
            this.time = time;
            this.limit = limit;
        }
    }
    static int[] arr;
    static int[][] dist;
    static int sum = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[T+1]; // 1초부터 시작
        for(int i=1; i<=T; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        dist = new int[T+1][W+1];
        for(int i=0; i<=T; i++){
            Arrays.fill(dist[i], Integer.MIN_VALUE);
        }

        bfs();

        System.out.print(sum);
    }
    static void bfs(){
        Queue<Plum> que = new LinkedList<>();
        que.add(new Plum(1, 0, W));
        dist[0][W] = 0; // 개수

        while(!que.isEmpty()){
            Plum current = que.poll();
            int pos = current.pos;
            int time = current.time;
            int limit = current.limit;
            int curCount = dist[time][limit];

            if(time + 1 > T) continue;

            // 자리 이동을 하지 않는 경우
            int getPlum = (pos == arr[time+1]) ? 1 : 0;
            if(dist[time+1][limit] < curCount + getPlum){
                dist[time+1][limit] = curCount + getPlum;
                que.add(new Plum(pos, time+1, limit));
                sum = Math.max(sum, curCount + getPlum);
            }

            // 자리 이동을 하는 경우
            if(limit > 0){
                int newPos = (pos == 1) ? 2 : 1;
                getPlum = (newPos == arr[time+1]) ? 1 : 0;
                if(dist[time+1][limit-1] < curCount + getPlum){
                    dist[time+1][limit-1] = curCount + getPlum;
                    que.add(new Plum(newPos, time+1, limit-1));
                    sum = Math.max(sum, curCount + getPlum);
                }
            }
        }

    }
}
