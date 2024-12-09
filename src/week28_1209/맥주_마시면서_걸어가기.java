package week28_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 맥주_마시면서_걸어가기 {
    static boolean[] visited;
    static int n;
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static List<Point> locs;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            n = Integer.parseInt(br.readLine()); //편의점 개수
            locs = new ArrayList<>();

            for(int i=0; i<n+2; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                locs.add(new Point(x, y));
            }

            visited = new boolean[n+2];
            graph = new ArrayList<>();

            for(int i=0; i<n+2; i++){
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<n+2; i++){
                for(int j=i+1; j<n+2; j++){
                    if(distance(locs.get(i), locs.get(j)) <= 1000){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            sb.append(bfs() ? "happy" : "sad").append("\n");
        }

        System.out.print(sb);
    }
    static boolean bfs(){
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = true;

        while(!que.isEmpty()){
            int cur = que.poll(); // 현재 위치

            if(cur == n+1) return true; // 락페스티벌 도착

            for(int neighbor: graph.get(cur)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    que.offer(neighbor);
                }
            }
        }
        return false;

    }
    static int distance(Point a, Point b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}
