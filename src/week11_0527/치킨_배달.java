package week11_0527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
    int x, y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class 치킨_배달 {
    static int N, M;
    static int[][] city;
    static List<Pos> chicken, home;
    static boolean[] open;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        chicken = new ArrayList<>();
        home = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                if(city[i][j] == 1){
                    home.add(new Pos(i, j));
                }else if(city[i][j] == 2){
                    chicken.add(new Pos(i, j));
                }
            }
        }
        open = new boolean[chicken.size()];
        ans = Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.print(ans);
    }
    static void dfs(int start, int cnt){
        if(cnt == M){
            int res = 0;
            for(int i=0; i<home.size(); i++){
                int distance = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++){
                    if(open[j]){
                        int compare = Math.abs(chicken.get(j).x - home.get(i).x) + Math.abs(chicken.get(j).y - home.get(i).y);
                        distance = Math.min(distance, compare);
                    }
                }
                res += distance;
            }
            ans = Math.min(res, ans);
        }
        for(int i=start; i<chicken.size(); i++){
            open[i] = true;
            dfs(i+1, cnt+1);
            open[i] = false;
        }
    }
}
