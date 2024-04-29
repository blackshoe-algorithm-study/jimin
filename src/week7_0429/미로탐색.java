package week7_0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[] dx = {0, 1, 0};
    static int[] dy = {1, 0, -1};
    static char[][] arr;
    static int[][] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 행
        int M = Integer.parseInt(str.nextToken()); // 열
        arr = new char[N+1][M+1]; // (1,1) 부터 시작
        visited = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=0; j<line.length(); j++){
                arr[i][j+1] = line.charAt(j);
            }
        }
        int result = bfs(N, M);
        System.out.println(result);
    }
    public static int bfs(int N, int M){
        Queue<Integer[]> list = new LinkedList<>();
        int x=1; int y=1;
        list.add(new Integer[]{x, y});
        visited[x][y] = 1;
        while(!list.isEmpty()){
            Integer[] want = list.remove();
            x = want[0];
            y = want[1];
            if(x == N && y == M){
                return visited[x][y]-1;
            }
            if(y+1<=M && arr[x][y+1]=='1' && visited[x][y+1] == 0){
                visited[x][y+1] = visited[x][y]+1;
                list.add(new Integer[]{x, y+1});
            }
            if(y-1>=1 && arr[x][y-1]=='1' && visited[x][y-1] == 0){
                visited[x][y-1] = visited[x][y]+1;
                list.add(new Integer[]{x, y-1});
            }
            if(x+1<=N && arr[x+1][y]=='1' && visited[x+1][y] == 0) {
                visited[x + 1][y] = visited[x][y]+1;
                list.add(new Integer[]{x + 1, y});
            }
        }
        return -1;
    }
}

// x가 갈 수 있는칸 : (0,1) (0,-1) (1,0) (-1,0) =>(-1, 0) 은 보류