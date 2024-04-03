package week3_0401;

import java.io.*;
import java.util.*;

public class 잃어버린_괄호 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer str = new StringTokenizer(line, "-");

        int len = str.countTokens();
        int[] sum = new int[len];

        for(int i=0; i<len; i++){
            String[] arr = str.nextToken().split("\\+");
            for(int j=0; j<arr.length; j++){
                sum[i] += Integer.parseInt(arr[j]);
            }
        }

        int ans = sum[0];
        for(int i=1; i<len; i++){
            ans -= sum[i];
        }

        System.out.println(ans);
    }
}

// - 를 기준으로 + 들 먼저 계산
