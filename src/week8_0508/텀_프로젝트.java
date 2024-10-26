package week8_0508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀_프로젝트 {
    static boolean[] visited, pathVisited;
    static int[] arr;
    static int n, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n+1]; // 1번부터 n번까지
            pathVisited = new boolean[n+1];
            arr = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            cnt = 0;
            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    dfs(i);
                }
            }
            int ans = n - cnt;
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int x){
        visited[x] = true;
        pathVisited[x] = true;

        int next = arr[x];
        if(!visited[next]){
            dfs(next);
        }else if(pathVisited[next]){
            int cycle = next;
            cnt++;
            while(cycle != x){
                cnt++;
                cycle = arr[cycle];
            }
        }
        pathVisited[x] = false;
    }
}
