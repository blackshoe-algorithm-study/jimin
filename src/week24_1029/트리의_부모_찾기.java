package week24_1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 트리의_부모_찾기 {
    static ArrayList<ArrayList<Integer>> node;
    static int[] parents;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        node = new ArrayList<>();
        for(int i=0; i<=N; i++) node.add(new ArrayList<>());
        for(int i=1; i<=N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node.get(u).add(v);
            node.get(v).add(u);
        }
        parents = new int[N+1];
        visited = new boolean[N+1];
        dfs(1);
        for(int i=2; i<=N; i++){
            System.out.println(parents[i]);
        }
    }
    static void dfs(int x){
        visited[x] = true;
        for(int child: node.get(x)){
            if(!visited[child]){
                parents[child] = x;
                dfs(child);
            }
        }
    }
}
