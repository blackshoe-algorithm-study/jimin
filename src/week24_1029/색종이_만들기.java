package week24_1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_만들기 {
    static int N;
    static int[][] map;
    static int white = 0;  // 흰색 개수
    static int blue = 0;   // 파란색 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countColors(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    static void countColors(int size, int x0, int y0) {
        if (allOneColor(size, x0, y0, map[x0][y0])) {
            if (map[x0][y0] == 1) {
                blue++;
            } else {
                white++;
            }
        } else {
            int newSize = size / 2;
            countColors(newSize, x0, y0);
            countColors(newSize, x0, y0 + newSize);
            countColors(newSize, x0 + newSize, y0);
            countColors(newSize, x0 + newSize, y0 + newSize);
        }
    }

    static boolean allOneColor(int size, int x0, int y0, int color) {
        for (int i = x0; i < x0 + size; i++) {
            for (int j = y0; j < y0 + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
