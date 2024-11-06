package week12_0605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 오목 {
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 0, 1, -1};
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[20][20];
        for(int i=1; i<20; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<20; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int winner = 0;
        int winX = 0, winY = 0;
        outerLoop:
        for(int i=1; i<20; i++){
            for(int j=1; j<20; j++){
                if(board[i][j] != 0){
                    int color = board[i][j];
                    for(int k=0; k<4; k++){
                        int cnt = 1;

                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if(nx<1 || ny<1 || nx>=20 || ny>=20) continue;
                        while(board[nx][ny] == color){
                            cnt++;
                            nx += dx[k];
                            ny += dy[k];
                        }

                        if(cnt == 5){
                            int preX = i - dx[k];
                            int preY = j - dy[k];
                            if(preX>=1 && preY>=1 && preX<20 && preY<20 && board[preX][preY]==color) continue;
                            if(nx>=1 && ny>=1 && nx<20 && ny<20 && board[nx][ny]==color) continue;

                            winner = color;
                            winX = i;
                            winY = j;
                            break outerLoop;
                        }
                    }
                }
            }
        }

        if(winner != 0){
            System.out.println(winner);
            System.out.print(winX + " " + winY);
        }else{
            System.out.println(0);
        }
    }
}