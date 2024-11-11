package week19_0814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DSLR {
    static class Node{
        String path;
        int num;
        Node(String path, int num){
            this.path = path;
            this.num = num;
        }
    }
    static char[] DSLR = {'D', 'S', 'L', 'R'};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            String ans = bfs(A, B);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
    static String bfs(int A, int B){
        Queue<Node> que = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        que.add(new Node("", A));
        visited[A] = true;

        while(!que.isEmpty()){
            Node current = que.poll();
            String commands = current.path;
            int changed = current.num;

            if(changed == B){ // 바뀐값이 B면 현재 명령어 반환
                return commands;
            }

            for(int i=0; i<4; i++){
                int newNumber = command(DSLR[i], changed);
                if(!visited[newNumber]){
                    visited[newNumber] = true;
                    que.add(new Node(commands + DSLR[i], newNumber));
                }
            }

        }
        return "";
    }
    static int command(char x, int n) {
        if(x == 'D'){
            return (2*n) % 10000;
        }
        if(x == 'S'){
            return (n == 0) ? 9999 : n-1;
        }

        int d1 = n / 1000;
        int d2 = (n % 1000) / 100;
        int d3 = (n % 100) / 10;
        int d4 = n % 10;

        if(x == 'L'){
            return d2*1000 + d3*100 + d4*10 + d1;
        }
        if(x == 'R'){
            return d4*1000 + d1*100 + d2*10 + d3;
        }

        return -1;
    }

}
