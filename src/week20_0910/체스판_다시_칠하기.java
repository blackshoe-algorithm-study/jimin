package week20_0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class 체스판_다시_칠하기 {
    static Map<String, Integer> categoryMap = new HashMap<>();
    static Map<Integer, String[]> formMap = new HashMap<>();
    static Map<String, int[]> deadLine = new HashMap<>();
    public String[] solution(String[] category, String[] form, String[] record){
        String[] answer = new String[record.length];

        for(int i=0; i<category.length; i++){
            String name = category[i].split(" ")[0];
            int deadDay = Integer.parseInt(category[i].split(" ")[1]);
            categoryMap.put(name, deadDay);
        }

        for(int i=0; i<form.length; i++){
            String[] kinfOfForm = form[i].split(" ");
            formMap.put(i+1, kinfOfForm);
        }

        for(int i=0; i<record.length; i++){
            String[] dayStream = record[i].split(" ")[0].split("\\.");
            int[] days = new int[3];
            for(int j=0; j<3; j++){
                days[j] = Integer.parseInt(dayStream[j]);
            }
            int formNum = Integer.parseInt(record[i].split(" ")[1]);
            answer[i] = decision(days, formNum);
        }

        return answer;
    }

    static String decision(int[] days, int form) {
        List<String> expiredCategories = new ArrayList<>();
        String[] relatedCategories = formMap.get(form);

        for (String category : relatedCategories) {
            int[] newDeadline = calculateNewDeadline(days, categoryMap.get(category));

            if (deadLine.containsKey(category)) {
                int[] currentDeadline = deadLine.get(category);
                if (isEarlier(newDeadline, currentDeadline)) {
                    expiredCategories.add(category);
                }
            } else {
                expiredCategories.add(category);
            }

            deadLine.put(category, newDeadline);
        }

        if (expiredCategories.isEmpty()) {
            return "None";
        }

        Collections.sort(expiredCategories);
        return String.join(" ", expiredCategories);
    }

    static int[] calculateNewDeadline(int[] days, int addMonths) {
        int year = days[0];
        int month = days[1] + addMonths;
        int day = days[2] - 1;

        if (day < 1) {
            month -= 1;
            day = 28; // 모든 달이 28일까지만 있다고 가정
        }
        if (month > 12) {
            year += (month - 1) / 12;
            month = (month - 1) % 12 + 1;
        }

        return new int[]{year, month, day};
    }

    static boolean isEarlier(int[] newDate, int[] currentDate) {
        for (int i = 0; i < 3; i++) {
            if (newDate[i] < currentDate[i]) return true;
            if (newDate[i] > currentDate[i]) return false;
        }
        return false;
    }
}
