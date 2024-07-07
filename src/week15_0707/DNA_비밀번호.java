package week15_0707;

import java.io.*;
import java.util.*;

public class DNA_비밀번호 {
    static int S, P;
    static int[] length;
    static char[] s_dna;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        str = new StringTokenizer(br.readLine());
        S = Integer.parseInt(str.nextToken()); // 임의의 문자열길이
        P = Integer.parseInt(str.nextToken()); // 부분 문자열 길이
        String line = br.readLine();
        s_dna = line.toCharArray(); // 주어진 임의의 문자열
        str = new StringTokenizer(br.readLine());
        length = new int[4];
        for(int i=0; i<4; i++){
            length[i] = Integer.parseInt(str.nextToken()); // A, C, G, T 제한개수
        }
        int cnt = 0;
        for(int j=0; j<=S-P; j++){
            String made = line.substring(j, j+P); //j번째 인덱스부터 P 만큼
            char[] madeArr = made.toCharArray();
            if(analyze(madeArr)){
                cnt ++;
            }
        }
        System.out.print(cnt);
    }
    private static boolean analyze(char[] arr){
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!hmap.containsKey(arr[i])){
                hmap.put(arr[i], 1);
            }else{
                int value = hmap.get(arr[i]);
                hmap.put(arr[i], value+1);
            }
        }
        char[] target = {'A', 'C', 'G', 'T'};
        for(int j=0; j<4; j++){
            if(hmap.getOrDefault(target[j],0) != length[j]){
                return false;
            }
        }
        return true;
    }
}

/* 민호가 만든 DNA 문자열, 부분문자열 길이, {A, C, G, T}가 몇번 이상 등장 => 비밀번호 종료의 수
*
* */