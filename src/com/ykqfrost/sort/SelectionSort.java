package com.ykqfrost.sort;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/9/24
 */
public class SelectionSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int max = array[0];
            int maxPos = 0;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > max) {
                    max = array[j];
                    maxPos = j;
                }
            }
            array[maxPos] = array[array.length - 1 - i];
            array[array.length - 1 - i] = max;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 9, 2, 3, 5, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
