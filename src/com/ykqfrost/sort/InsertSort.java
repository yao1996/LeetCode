package com.ykqfrost.sort;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/9/24
 */
public class InsertSort {

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 9, 2, 3, 5, 10};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
