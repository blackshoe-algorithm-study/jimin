package week19_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 타임머신 {
    static class Bus{
        int start, end, time;
        Bus(int start, int end, int time){
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
    static int N, M;
    static List<Bus> graph;
    static long[] dist;
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Bus(u, v, c));
        }

        dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            System.out.println(-1); // 음수 사이클이 존재하면 -1 출력
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
            System.out.print(sb);
        }


    }
    static boolean bellmanFord(){
        for(int i=1; i<=N; i++){
            for(Bus neighbor : graph){
                if(dist[neighbor.start] != INF && dist[neighbor.end] > dist[neighbor.start] + neighbor.time){
                    dist[neighbor.end] = dist[neighbor.start] + neighbor.time;
                }
            }
        }

        for(Bus neighbor : graph){
            if(dist[neighbor.start] != INF && dist[neighbor.end] > dist[neighbor.start] + neighbor.time){
                return true;
            }
        }
        return false;
    }

}
