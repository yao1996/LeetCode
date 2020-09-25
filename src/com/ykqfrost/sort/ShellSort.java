package com.ykqfrost.sort;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/9/24
 */
public class ShellSort {

    public static void sort(int[] array) {
        int step = array.length / 2;
        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                int temp = array[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (array[j] > array[i]) {
                        array[j + step] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + step] = temp;
            }
            step = step / 2;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 9, 2, 3, 5, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }


}
