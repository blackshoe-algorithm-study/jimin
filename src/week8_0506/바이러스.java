package week8_0506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++) list.add(new ArrayList<>());
        while(L-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1);
        System.out.print(cnt);
    }
    static void dfs(int x){
        if(visited[x]) return;
        visited[x] = true;
        for(int y: list.get(x)){
            if(!visited[y]) cnt++;
            dfs(y);
        }
    }
}
