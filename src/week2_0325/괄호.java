package week2_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력받을 문자열 개수
        StringBuilder sb = new StringBuilder();
        String[] ans = new String[N+1];
        int i=0;

        while(i<N){
            String line = br.readLine();
            char[] vps = new char[line.length()];
            Stack<Integer> stack = new Stack<>();

            for(int j=0; j<line.length(); j++){
                vps[j] = line.charAt(j);
                if(vps[j] == '('){
                    stack.push(1); // '('가 보이면 1을 넣음
                }else{
                    if(!stack.empty()) { // 스택이 비어있지 않으면 1을 뺌
                        stack.pop();
                    }else{
                        ans[i] = "NO";
                        i++;
                        break;
                    }
                }
            }
            System.out.println(i);
            if(ans[i].isBlank()){
                if(stack.empty()){
                    ans[i] = "YES";
                }else{
                    ans[i] = "NO";
                }
            }
            i++;
        }

        for(int j=0; j<ans.length; j++){
//            System.out.println(ans[i]);
        }
    }
}

//( 얘가 보이면 스택에 push, ) 얘가 보이면 pop,
// size == 0 이 아니면 no
//) 얘가 먼저 보이면 pop 해야 하는데 has no elements => no