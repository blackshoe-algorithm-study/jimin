package week7_0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
//    static int[] pos = new int[100001];
    static int visited[] = new int[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 수빈이가 있던 자리
        int K = Integer.parseInt(str.nextToken()); // 동생이 있던 자리
        int result = bfs(N, K);
        System.out.println(result);
    }
    public static int bfs(int N, int K){
        Queue<Integer> pos = new LinkedList<>();
        int index = N;
        int n = 0;
        pos.add(N);
        visited[index] = 1;
        while(!pos.isEmpty()){
            n = pos.remove();
            if(n==K){
                return visited[n]-1;
            }
            if(n-1>=0 && visited[n-1] == 0){
                visited[n-1] = visited[n]+1;
                pos.add(n-1);
            }
            if(n+1<=100000 && visited[n+1] == 0){
                visited[n+1] = visited[n]+1;
                pos.add(n+1);
            }
            if(n*2<=100000 && visited[n*2] == 0){
                visited[n*2] = visited[n]+1;
                pos.add(2*n);
            }
        }
        return -1;
    }
}

// 5*2 -1 *2 -1
// 어떤 큐가 있어서 그 위치를 수빈이가 채움, 갔던 곳은 변경되지 않고
// 배열로 수빈 ~ 동생이 있는 자리