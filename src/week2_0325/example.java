package week2_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class example{
    public static String solution(StringBuilder sb){
        String ans = sb.toString();
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String phonNum = br. readLine();
        char[] num = new char[phonNum.length()];
        for(int i=0; i<phonNum.length(); i++){
            num[i] = phonNum.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<phonNum.length(); k++){
            if(k<phonNum.length()-4) sb.append("*");
            else sb.append(num[k]);
        }
//        System.out.print(sb);
        solution(sb);
    }
}