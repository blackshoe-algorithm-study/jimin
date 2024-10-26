package week8_0506;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class 효율적인_해킹 {
    static List<ArrayList<Integer>> list;
    static int ans[];
    static int n, m;
    static boolean visit[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[n+1];

        list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        for(int i=1; i<=n;i++) {
            visit = new boolean[n+1];
            Queue<Integer> q = new LinkedList<Integer>();
            visit[i] = true;
            q.add(i);

            while(!q.isEmpty()) {
                int now = q.poll();

                for(int a : list.get(now)) {
                    if(!visit[a]) {
                        visit[a] =true;
                        ans[now]++;
                        q.add(a);
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        //최댓값 찾기
        for(int i=1; i<=n;i++) {
            max = Math.max(max, ans[i]);
        }
        StringBuilder sb = new StringBuilder();

        for(int i=1; i <=n ; i++) {
            if(ans[i]==max) {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb);
    }

}
