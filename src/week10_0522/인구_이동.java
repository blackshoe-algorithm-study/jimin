package week10_0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 인구_이동 {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int border;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int moves = 0;
        while(true){
            visited = new boolean[N][N];
            boolean isMoved = false;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        int populationSum = bfs(i, j);
                        if(populationSum > 0){
                            isMoved = true;
                        }
                    }
                }
            }

            if(!isMoved) break;
            moves ++;
        }
        System.out.print(moves);
    }
    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        queue.offer(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = map[x][y];
        int count = 1;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(!visited[nx][ny]){
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if(diff>=L && diff<=R){
                        queue.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        sum += map[nx][ny];
                        count++;
                    }
                }
            }
        }
        if(count > 1){
            int newPopulation = sum / count;
            for(int[] pos: union){
                map[pos[0]][pos[1]] = newPopulation;
            }
            return sum;
        }
        return 0;
    }
}
