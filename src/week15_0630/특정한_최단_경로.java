package week15_0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정한_최단_경로 {
    static class Node{
        int x, y, v;
        public Node(int x, int y, int v){
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //N개의 정점
        int E = Integer.parseInt(st.nextToken()); //E개의 간선
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<E; i++){ //간선을 큐에 저장
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            q.add(new Node(a, b, v));
        }
        st = new StringTokenizer(br.readLine()); //반드시 지나야 하는 정점
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());


    }
}

/* 1번 정점 -> N번 정점
* a b c => c: a~b의 거리
* */