package week28_1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문서_검색 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        String K = br.readLine();
        int lenK = K.length();

        int idx = 0;
        int cnt = 0;
        while(idx <= sentence.length() - lenK){
            String L = sentence.substring(idx, idx+lenK);
            if(L.equals(K)){
                cnt ++;
                idx += lenK;
            }else{
                idx ++;
            }
        }

        System.out.print(cnt);
    }
}
