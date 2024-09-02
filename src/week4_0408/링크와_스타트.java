package week4_0408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 링크와_스타트 {
    static int[][] map;
    static int N;
    static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 총 N개의 수
        map = new int[N][N];
        for(int i=0; i<N; i++){ // map 채우기
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> team = new ArrayList<>();
        solution(team, 0);
        System.out.print(minSum);
    }
    private static void solution(ArrayList<Integer> team, int start) {
        if (team.size() >= 1 && team.size() <= N - 1) {
            minSum = Math.min(minSum, compareSum(team));
        }

        for (int i = start; i < N; i++) {
            team.add(i);
            solution(team, i + 1);
            team.remove(team.size() - 1);
        }
    }
    private static int compareSum(ArrayList<Integer> startTeam) {
        ArrayList<Integer> linkTeam = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!startTeam.contains(i)) {
                linkTeam.add(i);
            }
        }

        int startSum = calculateTeamAbility(startTeam);
        int linkSum = calculateTeamAbility(linkTeam);

        return Math.abs(startSum - linkSum);
    }

    private static int calculateTeamAbility(ArrayList<Integer> team) {
        int sum = 0;
        for (int i : team) {
            for (int j : team) {
                if (i != j) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
}
