package week24_1029;

import java.io.*;
import java.util.*;

public class 가장_가까운_세_사람의_심리적_거리 {
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(br.readLine());
       StringBuilder sb = new StringBuilder();

       while(T-- > 0){
           int N = Integer.parseInt(br.readLine());
           String[] mbti = new String[N];
           StringTokenizer st = new StringTokenizer(br.readLine());
           for(int i=0; i<N; i++){
               mbti[i] = st.nextToken();
           }
           if(N>32) {
               sb.append(0).append("\n");
               continue;
           }
           int min = Integer.MAX_VALUE;

           for(int i=0; i<N; i++){
               for(int j=i+1; j<N; j++){
                   for(int k=j+1; k<N; k++){
                       int sum = 0;
                       for(int l=0; l<4; l++){
                           if(mbti[i].charAt(l) != mbti[j].charAt(l)) sum ++;
                           if(mbti[j].charAt(l) != mbti[k].charAt(l)) sum ++;
                           if(mbti[k].charAt(l) != mbti[i].charAt(l)) sum++;
                       }
                       min = Math.min(min, sum);
                       if(min == 0) break;
                   }
               }
           }
           sb.append(min).append("\n");
       }
       System.out.print(sb);
   }
}