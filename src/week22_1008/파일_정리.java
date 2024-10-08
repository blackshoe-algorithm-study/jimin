package week22_1008;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class 파일_정리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] files = new String[N][2];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            files[i][0] = input.split("\\.")[0];
            files[i][1] = input.split("\\.")[1];
        }
        TreeMap<String, Integer> tmap = new TreeMap<>();
        for(int i=0; i<files.length; i++){
            if(tmap.containsKey(files[i][1])){
                tmap.replace(files[i][1], tmap.get(files[i][1])+1);
            }else{
                tmap.put(files[i][1], 1);
            }
        }
        for(String key: tmap.keySet()){
            System.out.println(key + " " + tmap.get(key));
        }
    }
}
