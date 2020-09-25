package com.ykqfrost.sort;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/9/25
 */
public class QuickSort {

    public static void sort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int q = array[end - 1];
        int i = start;
        int j = start;
        for (; j < end - 1; ) {
            if (array[j] < q) {
                if (i != j) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                i++;
                j++;
            }
            if (array[j] >= q) {
                j++;
            }
        }
        array[end - 1] = array[i];
        array[i] = q;
        sort(array, start, i);
        sort(array, i + 1, end);
    }

    public static void main(String[] args) {
        int[] array = {1, 9, 4, 3, 5, 10};
        sort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }

}
