package week18_0731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //포켓몬 개수
        int M = Integer.parseInt(st.nextToken()); //문제 개수
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for(int i=1; i<=N; i++){
            String name = br.readLine();
            map1.put(i, name);
            map2.put(name, i);
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<M; j++){
            String question = br.readLine();
            if(isNumeric(question)){ //숫자인 경우 - 키
                int num = Integer.parseInt(question);
                sb.append(map1.get(num)+"\n");
            }else{
                sb.append(map2.get(question)+"\n");
            }
        }
        System.out.print(sb);
    }
    public static boolean isNumeric(String name){ //isAlphabetic
        for(char c: name.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}

/* 포켓몬 번호 -> 이름, 이름 -> 번호
N : 포켓몬 개수, M: 문제 개수
* */