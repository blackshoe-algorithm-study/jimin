package week15_0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미확인_도착지 {
    static class Node{
        int vertex, cost;
        Node(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    static int n, m, t;
    static int start, g, h;
    static int[] dist;
    static List<List<Node>> graph;
    static int INF = Integer.MAX_VALUE;
    static int[] endList;
    static List<Integer> ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //교차로
            m = Integer.parseInt(st.nextToken()); //도로
            t = Integer.parseInt(st.nextToken()); //목적지후보
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.get(u).add(new Node(v, c));
                graph.get(v).add(new Node(u, c));
            }
            endList = new int[t];
            for(int i=0; i<t; i++){
                endList[i] = Integer.parseInt(br.readLine());
            }

            ans = new ArrayList<>();
            for(int end: endList){
                int a1 = dijkstra(start, g) + dijkstra(g, h) + dijkstra(h, end);
                int a2 = dijkstra(start, h) + dijkstra(h, g) +dijkstra(g, end);
                int a3 = dijkstra(start, end);
                int result = Math.min(a1, a2);
                if(result >= INF) continue;
                if(a3 == result) ans.add(end);
            }

            Collections.sort(ans);
            for(int r : ans){
                sb.append(r).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        dist = new int[n+1];
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

