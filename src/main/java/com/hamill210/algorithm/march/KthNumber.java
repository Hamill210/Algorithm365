package com.hamill210.algorithm.march;

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {
        KthNumber kth = new KthNumber();
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(kth.solution(array, commands)));
        System.out.println(Arrays.toString(kth.solution2(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        int n = 0;
        int[] ret = new int[commands.length];

        while (n < commands.length) {
            int m = commands[n][1] - commands[n][0] + 1;


            if (m == 1) {
                ret[n] = array[commands[n++][0] - 1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for (int i = commands[n][0]-1; i < commands[n][1]; i++) {
                a[j++] = array[i];
            }

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

        return ret;
    }

    void sort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr) {
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if (left < pr) sort(a, left, pr);
        if (right > pl) sort(a, pl, right);
    }
}

