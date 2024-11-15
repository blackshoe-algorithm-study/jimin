package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                min = Math.min(min, getRepaintCount(map, i, j));
            }
        }

        System.out.print(min);
    }

    static int getRepaintCount(char[][] board, int x, int y) {
        int countWStart = 0; // 왼쪽 위가 W인 체스판
        int countBStart = 0; // 왼쪽 위가 B인 체스판

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char currentColor = board[x + i][y + j];
                char expectedColorW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedColorB = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (currentColor != expectedColorW) {
                    countWStart++;
                }
                if (currentColor != expectedColorB) {
                    countBStart++;
                }
            }
        }

        return Math.min(countWStart, countBStart);
    }
}
