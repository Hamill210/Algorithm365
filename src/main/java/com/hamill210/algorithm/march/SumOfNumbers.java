package com.hamill210.algorithm.march;

import com.sun.javafx.css.CalculatedValue;

import java.util.Calendar;
import java.util.Locale;

/**
 * 프로그래머스 : 2016년
 *
 * 문제 설명 :
 * 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
 * 두 수 a,b를 입력 받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수,
 * solution을 완성하세요. 요일의 이름은 일요일부터 토요일까지 각각
 * SUN, MON, TUE, WED, THU, FRI, SAT 입니다.
 * 예를 들어, a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를
 * 반환하세요.
 *
 * 제한 조건 :
 * 2016년은 윤년입니다.
 * 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일
 * 같은 날짜는 주어지지 않습니다.)
 */

public class SumOfNumbers {

    public String getDayName(int month, int day) {
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2016, month - 1, day).build();
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
    }

    public String solution(int a, int b) {
        String monthStr = "";
        String dayStr = "";

        monthStr = a < 10 ? "0" + a : Integer.toString(a);
        dayStr = b < 10 ? "0" + b : Integer.toString(b);


        String startDate = "2016"+monthStr+dayStr;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(startDate.substring(0,4)));
        cal.set(Calendar.MONTH, Integer.parseInt(startDate.substring(4,6))-1);
        cal.set(Calendar.DATE, Integer.parseInt(startDate.substring(6,8)));

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        String answer = "";
        switch(dayOfWeek) {
            case 1:
                answer = "SUN";
                break;
            case 2:
                answer = "MON";
                break;
            case 3:
                answer = "TUE";
                break;
            case 4:
                answer = "WED";
                break;
            case 5:
                answer = "THU";
                break;
            case 6:
                answer = "FRI";
                break;
            case 7:
                answer = "SAT";
                break;
        }

        return answer;
    }

    public static void main(String[] args) {
        SumOfNumbers son = new SumOfNumbers();
        int a = 5;
        int b = 24;
        int c = 2;
        int d = 29;
        System.out.println(son.solution(a,b));
        System.out.println(son.solution(c,d));
        System.out.println(son.getDayName(a,b));


    }
}
