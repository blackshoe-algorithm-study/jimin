package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 빙고 {
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[5][5];

        int cnt = 0;
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                cnt ++;
                int num = Integer.parseInt(st.nextToken());
                int[] idx = bingoFound(num);
                visited[idx[0]][idx[1]] = true;
                if(bingoCheck()){
                    System.out.print(cnt);
                    return;
                }
            }
        }
    }
    static int[] bingoFound(int num){

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(map[i][j] == num){
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {};
    }
    static boolean bingoCheck() {
        int bingo = 0;

        // 행 체크
        for (int i = 0; i < 5; i++) {
            boolean rowBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    rowBingo = false;
                    break;
                }
            }
            if (rowBingo) bingo++;
        }

        // 열 체크
        for (int i = 0; i < 5; i++) {
            boolean colBingo = true;
            for (int j = 0; j < 5; j++) {
                if (!visited[j][i]) {
                    colBingo = false;
                    break;
                }
            }
            if (colBingo) bingo++;
        }

        // 왼쪽 위 -> 오른쪽 아래 대각선 체크
        boolean mainDiagonalBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][i]) {
                mainDiagonalBingo = false;
                break;
            }
        }
        if (mainDiagonalBingo) bingo++;

        // 오른쪽 위 -> 왼쪽 아래 대각선 체크
        boolean antiDiagonalBingo = true;
        for (int i = 0; i < 5; i++) {
            if (!visited[i][4 - i]) {
                antiDiagonalBingo = false;
                break;
            }
        }
        if (antiDiagonalBingo) bingo++;

        // 빙고가 3줄 이상이면 true 반환
        return bingo >= 3;
    }
}
