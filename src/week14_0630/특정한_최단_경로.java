package week14_0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정한_최단_경로 {
    static class Node{
        int vertex;
        int cost;
        Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    static List<List<Node>> graph;
    static int INF = 200000000;
    static int N, E, v1, v2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int a1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int a2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        int ans = Math.min(a1, a2);
        if(ans >= INF){
            System.out.print(-1);
        }else{
            System.out.print(ans);
        }

    }
    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            if(currentCost > dist[currentVertex]) continue;
            for(Node neighbor: graph.get(currentVertex)){
                int newDist = currentCost + neighbor.cost;
                if(newDist < dist[neighbor.vertex]){
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }
        return dist[end];
    }
}
