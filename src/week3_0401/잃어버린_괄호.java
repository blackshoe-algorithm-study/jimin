package week3_0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 잃어버린_괄호 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> num = new LinkedList<>(); // 숫자 넣는 큐
        Queue<Character> opr = new LinkedList<>(); // 연산자 넣는 큐
        String input = br.readLine(); // 입력받음
        char[] inputs = new char[input.length()];
        //자바 split | 기호가 or 연산 수행
        //split 에서 + regex 은 앞에 \\
        String[] numString = input.split("\\+|-");
        for(int i=0; i<numString.length; i++){
            int number = Integer.parseInt(numString[i]);
            num.offer(number);
        }

        for(int i=0; i<input.length(); i++){
            inputs[i] = input.charAt(i);
            if(inputs[i] == '+' || inputs[i] == '-') opr.offer(inputs[i]);
        }

        ArrayList<Integer> ans = new ArrayList<>(); // 정답 넣는 연결리스트
        while(!num.isEmpty()){
            int sum = 0;
            if(opr.peek()=='+') sum += num.poll();
            else if (opr.peek()=='-') sum -= num.poll();



        }
    }
}

// 양수, +, -, 괄호 -> 이후 괄호를 모두 지움 -> 괄호를 쳐서 식의 최솟값
// 55-(50+40) = -35
// + 만 있는 경우는 상관없지만 최소로 만드려면 - 뒤에 +인 경우 -(+) 이런식으로 해야함
// 아니면 괄호가 가능한 부분에 모두 한담에 최솟값을 넣으면 되나?
// 괄호 ( -> 숫자앞에서 시작 , 괄호 ) -> 숫자 뒤에서 끝남
// flag를 1로 뒀다가 끝나면 0이 되게끔 해야 하나?