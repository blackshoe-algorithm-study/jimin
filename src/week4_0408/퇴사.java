package week4_0408;

import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CollationKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 퇴사 {
    static int cost;
    static ArrayList<Integer> subsum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.parseInt(br.readLine());
        int[][] plan = new int[N][N];
        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            plan[i][0] = Integer.parseInt(str.nextToken());
            plan[i][1] = Integer.parseInt(str.nextToken());
        }

        ArrayList<Integer> sum = new ArrayList<>();
        for(int i=0; i<N; i++){
            cost = 0;
            subsum = new ArrayList<>();
            find(cost, i, N, plan, subsum);
            Collections.sort(subsum, Collections.reverseOrder());
            sum.add(subsum.getFirst());
        }

        Collections.sort(sum, Collections.reverseOrder());
        System.out.println(sum.getFirst());
    }
    public static void find(int cost, int index, int N, int[][] plan, ArrayList<Integer> subsum){
        int i = index;
        while(i<N){
            if(i+plan[i][0] > N) {
                subsum.add(cost);
                break;
            }
            i+=plan[i][0];
            for(int j=i; j<N; j++){
                cost += plan[j][1];
                find(cost, j, N, plan, subsum);
            }
        }
    }
}

// Ti -> index + Ti
// Max