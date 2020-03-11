package com.hamill210.algorithm.march;

/**
 * 프로그래머스 : 가운데 글자 가져오기
 *
 * 문제 설명 :
 * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
 * 단어의 길이가 짝수라면 가운데 두 글자를 반환하면 됩니다.
 *
 * 제한 사항 :
 * s는 길이가 1이상, 100이하인 스트링입니다.
 */

public class TakeMiddleString {

    public String solution(String s) {
        String answer = "";
        if ((s.length() % 2) != 0) {
            int len = s.length() / 2;
            answer = s.substring(len, len+1);
        }

        if ((s.length() % 2) == 0) {
            int len = s.length() / 2;
            answer = s.substring(len-1,len+1);
        }

        return answer;
    }

    public String solution2(String s) {
        return s.substring((s.length()-1) / 2, s.length() / 2 + 1);
    }

    public static void main(String[] args) {
        TakeMiddleString tms = new TakeMiddleString();
        String s = "abcde";
        String s2 = "qwer";
        String s3 = "asdafawffwaaw";
        System.out.println(tms.solution2(s));
        System.out.println(tms.solution2(s2));
        System.out.println(tms.solution2(s3));
    }
}
