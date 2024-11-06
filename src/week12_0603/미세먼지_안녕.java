package week12_0603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미세먼지_안녕 {
    static int R, C, T;
    static int[][] map;
    static int calPosRow;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1){
                    calPosRow = i-1; // 최종적으로는 시계방향 부분의 위치 기억
                }
            }
        }

        while(T > 0){
            map = spreadDust();
            airSimulation();
            T--;
        }

        int temp = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0){
                    temp += map[i][j];
                }
            }
        }

        System.out.println(temp);
    }
    static int[][] spreadDust() {
        int[][] newMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1){
                    newMap[i][j] = -1;
                }
                if (map[i][j] > 0) {
                    int amount = map[i][j] / 5;
                    int spreadCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny]!=-1) {
                            newMap[nx][ny] += amount;
                            spreadCount++;
                        }
                    }
                    newMap[i][j] += map[i][j] - amount * spreadCount;
                }
            }
        }
        return newMap;
    }

    static void airSimulation() {
        int top = calPosRow;

        for (int x = top - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[top][y] = map[top][y - 1];
        }

        map[top][1] = 0;

        int bottom = calPosRow+1;

        for (int x = bottom + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[bottom][y] = map[bottom][y - 1];
        }

        map[bottom][1] = 0;
    }

}
