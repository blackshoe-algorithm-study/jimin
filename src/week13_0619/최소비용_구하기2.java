package week13_0619;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 최소비용_구하기2 {
    static int n, m;
    static int[] dist, prev;
    static List<List<City>> graph;
    static PriorityQueue<City> pq;
    static int start, end;
    static int INF = Integer.MAX_VALUE;
    static class City{
        int vertex;
        int cost;
        City(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new City(v, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        prev = new int[n+1];
        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dijkstra();

        System.out.println(dist[end]);

        List<Integer> path = new ArrayList<>();
        for(int at=end; at!=-1; at=prev[at]){
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for(int node: path){
            System.out.print(node + " ");
        }

    }
    static void dijkstra(){
        pq = new PriorityQueue<>(Comparator.comparingInt(city -> city.cost));
        pq.add(new City(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            City current = pq.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            if(currentCost > dist[currentVertex]) continue;

            for(City neighbor : graph.get(currentVertex)){
                int newDist = currentCost + neighbor.cost;

                if(newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    prev[neighbor.vertex] = currentVertex;
                    pq.add(new City(neighbor.vertex, newDist));
                }
            }
        }
    }
}
