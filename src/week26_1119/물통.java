package week26_1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 물통 {
    static List<Integer> list;

    static class Water {
        int a, b, c;

        Water(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static int A, B, C;
    static boolean[][][] visited = new boolean[201][201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        bfs();
        Collections.sort(list);
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    static void bfs() {
        Queue<Water> que = new LinkedList<>();
        que.add(new Water(0, 0, C));

        while (!que.isEmpty()) {
            Water now = que.poll();
            int a = now.a;
            int b = now.b;
            int c = now.c;

            if (a < 0 || b < 0 || c < 0 || a > A || b > B || c > C) continue;
            if (visited[a][b][c]) continue;

            visited[a][b][c] = true;
            if (a == 0) list.add(c);

            //A->B
            if (a + b > B) que.add(new Water(a - (B - b), B, c));
            else que.add(new Water(0, a + b, c));

            //A->C
            if (a + c > C) que.add(new Water(a - (C - c), b, C));
            else que.add(new Water(0, b, a + c));

            //B->A
            if (b + a > C) que.add(new Water(A, b - (A - a), c));
            else que.add(new Water(b + a, 0, c));

            //B->C
            if (b + c > C) que.add(new Water(a, b - (C - c), C));
            else que.add(new Water(a, 0, b + c));

            //C->A
            if (c + a > A) que.add(new Water(A, b, c - (A - a)));
            else que.add(new Water(a + c, b, 0));

            //C->B
            if (c + b > B) que.add(new Water(a, B, c - (B - b)));
            else que.add(new Water(a, b + c, 0));
        }
    }
}
