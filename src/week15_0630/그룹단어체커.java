package week15_0630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class 그룹단어체커 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        int cnt = 0;
        for(int i=0; i<T; i++){
            String input = br.readLine();
            char[] testArray = input.toCharArray();
            if(check(testArray)){
                cnt ++;
            }
        }
        System.out.print(cnt);
    }
    public static boolean check(char[] arr){
        HashMap<Character, ArrayList<Integer>> hmap = new HashMap<>();
        for(int i=0; i<arr.length; i++){ //hmap이 계속 새로운 걸 추가하다가
            if(hmap.containsKey(arr[i])){
                hmap.get(arr[i]).add(i);
            }else{
                hmap.put(arr[i], new ArrayList<Integer>());
                hmap.get(arr[i]).add(i);
            }
        }

        for(char key: hmap.keySet()){
            ArrayList<Integer> array = hmap.get(key);
            if(!isSequential(array)){
                return  false;
            }
        }
        return true;
    }
    public static boolean isSequential(ArrayList<Integer> array){
        if(array.size() < 2){
            return true;
        }
        for(int i=1; i<array.size(); i++){
            if(array.get(i) != array.get(i-1) + 1){
                return false;
            }
        }
        return true;
    }
}
