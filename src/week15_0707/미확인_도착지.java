package week15_0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 미확인_도착지 {
    static class Node {
        int vertex, length;
        Node(int vertex, int length){
            this.vertex = vertex;
            this.length = length;
        }
    }
    static List<Node>[] graph;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); //교차로 개수
            int m = Integer.parseInt(st.nextToken()); //도로 개수
            int t = Integer.parseInt(st. nextToken()); //목적지 후보 개수
            graph = new ArrayList[n+1];
            for(int j=0; j<m; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

            }
        }
    }
}

/* 예술가 2명이 이동중 (s에서 출발) -> 목적지 후보중 하나 : 최단거리
* */