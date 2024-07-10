package week4_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 퇴사 {
    static int[] Ti, Pi;
    static int pay=0;
    static LinkedList<Integer> list = new LinkedList<>();
    public  static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        int N = Integer.parseInt(br.readLine()); // N일까지
        Ti = new int[N+1];
        Pi = new int[N+1];
        for(int i=1; i<=N; i++){
            str = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(str.nextToken());
            Pi[i] = Integer.parseInt(str.nextToken());
        }
        dfs(1, 0);
    }
    static void dfs(int startDay, int payment){
        if(startDay > 7){
            list.add(payment);
            return;
        }
        dfs(startDay + Ti[startDay], payment + Pi[startDay]);
        startDay ++;
        payment = 0;
        dfs(startDay + Ti[startDay], payment + Pi[startDay]);

    }
}

/* di = di T[di] => 바로 일할 수 있는 날짜
* price = price + P[di]
* 만약 (업데이트되는) di > 7 => 못함
* */