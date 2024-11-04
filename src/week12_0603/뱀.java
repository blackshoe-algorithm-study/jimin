package week12_0603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀 {
    static int N, K, L;
    static int[][] map;
    static Deque<int[]> snake;
    static class Time{
        int time;
        char direct;
        Time(int time, char direct){
            this.time = time;
            this.direct = direct;
        }
    }
    static Time[] times;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N][N];
        while(K-- > 0){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            map[r][c] = 1;
        }
        L = Integer.parseInt(br.readLine());
        times = new Time[L];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            times[i] = new Time(t, d);
        }

        snake = new ArrayDeque<>();
        snake.addLast(new int[] {0, 0});
        map[0][0] = 2;
        int dx = 0, dy = 1, limit = 0, idx = 0;

        while(true){
            limit++;
            int[] head = snake.peekLast();
            int headX = head[0], headY = head[1];
            int newX = headX + dx;
            int newY = headY + dy;

            if(newX<0 || newY<0 || newX>=N || newY>=N || map[newX][newY]==2) break;

            if(map[newX][newY] == 1){ // 새로운 방향에 사과가 있음
                snake.addLast(new int[] {newX, newY});
                map[newX][newY] = 2;
            }else if(map[newX][newY] == 0){ // 걍 새로운 장소
                int[] tail = snake.pollFirst();
                map[tail[0]][tail[1]] = 0;
                map[newX][newY] = 2;
                snake.addLast(new int[] {newX, newY});
            }

            if(idx<L && limit == times[idx].time){ //방향 변환이 있는 경우
                int[] newDirection = newDirect(dx, dy, times[idx].direct);
                dx = newDirection[0];
                dy = newDirection[1]; // 방향 갱신
                idx++;
            }
        }
        System.out.print(limit);
    }
    static int[] newDirect(int dx, int dy, char direct){
        int newDx = dx, newDy = dy;
        if(dx == 0 && dy == 1){
            if(direct == 'D'){
                newDx = 1;
                newDy = 0;
            }else{
                newDx = -1;
                newDy = 0;
            }
        }
        if(dx == 0 && dy == -1){
            if(direct == 'D'){
                newDx = -1;
                newDy = 0;
            }else{
                newDx = 1;
                newDy = 0;
            }
        }
        if(dx == 1 && dy == 0){
            if(direct == 'D'){
                newDx = 0;
                newDy = -1;
            }else{
                newDx = 0;
                newDy = 1;
            }
        }
        if(dx == -1 && dy == 0){
            if(direct == 'D'){
                newDx = 0;
                newDy = 1;
            }else{
                newDx = 0;
                newDy = -1;
            }
        }
        return new int[] {newDx, newDy};
    }
}
