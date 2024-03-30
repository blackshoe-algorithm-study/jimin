package week2_0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 전화번호_목록 {
    static int flag = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        Queue<Integer> q;
        ArrayList<Queue<Integer>> list;

        for(int t=0; t<T; t++){ //테스트 케이스 동안
            int N = Integer.parseInt(br.readLine()); //전화번호의 수
            list = new ArrayList<>();
            for(int i=0; i<N; i++){ //전화번호 입력받을 동안
                String numString = br.readLine();
                // 숫자를 문자열로, 문자를 숫자열로
                // 나눌 생각을 하지말고 숫자를 문자열로 바꿔서 해보자.
                q = new LinkedList<>();
                for(int j=0; j<numString.length(); j++){
                    char numChar = numString.charAt(j);
                    int num = numChar - '0';
                    q.offer(num);
                }
                list.add(q);
            }
            // list 넣어서 하나하나 보면서 q사이즈가 0이 되는 순간
            find(list);
            if(flag>0){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
    public static void find(ArrayList<Queue<Integer>> list ){
        flag = 0;

        for(int i=0; i<list.size()-1; i++){
            Queue<Integer> qi = list.get(i);
            for(int j=i+1; j<list.size(); j++){
                Queue<Integer> qj = list.get(j);
                while(!qi.isEmpty() && !qj.isEmpty()){
                    if(qi.peek() == qj.peek()){
                        qi.poll();
                        qj.poll();
                    }else{
                        break;
                    }
                }
                if(qi.isEmpty() || qj.isEmpty()){
                    flag++;
                }
            }
        }
    }
}

// 한번호가 다른 번호의 앞부분이면 -> 전화 못걺 (일관성 x)
// 모두 큐에 저장해서 큐가 먼저 바닥난게 있으면 -> no