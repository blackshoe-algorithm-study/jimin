package week9_0513;

import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Road{
    int start, end, time;
    Road(int start, int end, int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

public class 파티 {
    static int N, M, X;
    static ArrayList<ArrayList<Road>> roads;
    static int time;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        roads = new ArrayList<>();
        for(int i=0; i<=N; i++) roads.add(new ArrayList<>());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            roads.get(u).add(new Road(u, v, t));
        }
        int maxStudent = 0;
        int[] studentTime = new int[N+1];
        for(int i=1; i<=N ;i++){ // 1) 학생 -> X 2) X -> 학생
            boolean[] visited = new boolean[N+1];
            time = 0;
            goTo(i, visited);
            studentTime[i] = time;
        }

        System.out.print(maxStudent);
    }
    static void goTo(int start,  boolean[] visited){ // 1) 학생 -> X
        if(start == X){
            return;
        }
        visited[start] = true;
        for(Road next : roads.get(start)){
            if(!visited[next.start]){
                time += next.time;
                goTo(next.start, visited);
            }
        }
    }
    static void goBack(int start, int end,boolean[] visited){ // 2) x -> 학생


    }

}
