package week10_0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int mass = Integer.parseInt(st.nextToken());
            people[i][0] = height; people[i][1] = mass;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int rank = 1;
            for(int j=0; j<N; j++){
                if(i == j) continue;
                if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) rank++;
            }
            sb.append(rank).append("\n");
        }
        System.out.print(sb);
    }
}
