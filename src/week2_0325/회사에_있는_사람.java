package week2_0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 회사에_있는_사람 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //회사에 있는 사람 수
        TreeSet<String> tset = new TreeSet<>();
        StringTokenizer str;
        for(int i=0; i<N; i++){
            str = new StringTokenizer(br.readLine());
            String name = str.nextToken();
            String state = str.nextToken();
            if(state.equals("enter")){
                tset.add(name);
            }else{
                tset.remove(name);
            }
        }
        Iterator<String> iter = tset.descendingIterator();

        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}

//자유로운 출퇴근 (9시부터 6시까지) - 원할때 출근, 퇴근
// map 이용해서 삭제, 있는것만 출력 key들