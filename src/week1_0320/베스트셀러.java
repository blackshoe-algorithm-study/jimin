package week1_0320;

import java.io.*;
import java.util.*;

public class 베스트셀러 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> tmap = new TreeMap<>();
        int N = Integer.parseInt(br.readLine()); // 입력받을 테스트케이스 개수
        for(int i=0; i<N; i++){
            String book = br.readLine();
            if(!tmap.containsKey(book)){
                tmap.put(book,0);
            }
            tmap.replace(book, tmap.get(book)+1);
        }
        int max = 0;
        String ans = new String();
        for(String book: tmap.keySet()){
            if(max < tmap.get(book)){
                max = tmap.get(book);
                ans = book;
            }
        }
        System.out.println(ans);
    }
}
