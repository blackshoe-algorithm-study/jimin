package week15_0707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DNA_비밀번호 {
    static char[] DNA = {'A', 'C', 'G', 'T'};
    static HashMap<Character, Integer> hmap, pwMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] arr = new char[S];
        String input = br.readLine();
        for(int i=0; i<S; i++){
            arr[i] = input.charAt(i);
        }
        st = new StringTokenizer(br.readLine());
        hmap = new HashMap<>();
        pwMap = new HashMap<>();

        for(int i=0; i<4; i++){
            int num = Integer.parseInt(st.nextToken());
            hmap.put(DNA[i], num);
            pwMap.put(DNA[i], 0);
        }

        for(int i=0; i<P; i++){
            for(Character key : hmap.keySet()){
                if(arr[i] == key){
                    pwMap.put(arr[i], pwMap.get(arr[i]) + 1);
                }
            }
        }

        int cnt = 0;
        if(analyze()) cnt ++;
        int idx = 0;
        while(idx < S-P){
            pwMap.put(arr[idx], Math.max(pwMap.get(arr[idx])-1, 0)); //첫 인덱스 --
            idx++;
            pwMap.put(arr[idx+P-1], pwMap.getOrDefault(arr[idx+P-1], 0)+1); //마지막 인덱스 ++
            if(analyze()) cnt++;
        }
        System.out.print(cnt);
    }
    static boolean analyze(){
        boolean flag = false;
        for(Character key: hmap.keySet()){
            if(pwMap.containsKey(key) && pwMap.get(key) >= hmap.get(key)){
                flag = true;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
