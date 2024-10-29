package week24_1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장_가까운_세_사람의_심리적_거리 {
    static int N;
    static Map<String, Integer> mbtiCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); // 학생 수
            mbtiCount = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String mbti = st.nextToken();
                mbtiCount.put(mbti, mbtiCount.getOrDefault(mbti, 0) + 1);
            }

            int ans = findMinDistance();
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static int findMinDistance() {
        for (int count : mbtiCount.values()) {
            if (count >= 3) {
                return 0;
            }
        }

        int minDistance = Integer.MAX_VALUE;
        List<String> mbtiTypes = new ArrayList<>(mbtiCount.keySet());

        for (int i = 0; i < mbtiTypes.size(); i++) {
            for (int j = i+1; j < mbtiTypes.size(); j++) {
                for (int k = j+1; k < mbtiTypes.size(); k++) {
                    String mbti1 = mbtiTypes.get(i);
                    String mbti2 = mbtiTypes.get(j);
                    String mbti3 = mbtiTypes.get(k);
                    int distance = calculateDistance(mbti1, mbti2) + calculateDistance(mbti2, mbti3) + calculateDistance(mbti3, mbti1);
                    minDistance = Math.min(minDistance, distance);
                }
            }
        }

        return minDistance;
    }

    static int calculateDistance(String mbti1, String mbti2) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if (mbti1.charAt(i) != mbti2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}

//ISTJ ISFJ ISTP