package week3_0403;

import java.util.*;
import java.io.*;

public class 진법_변환_한줄코드{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        String line = str.nextToken();
        int B = Integer.parseInt(str.nextToken());

        System.out.println(Integer.parseInt(line, B));
    }
}