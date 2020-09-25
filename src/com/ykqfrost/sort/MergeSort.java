package com.ykqfrost.sort;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/9/25
 */
public class MergeSort {

    public static void sort(int[] array, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int mid = (end + start) / 2;
        sort(array, start, mid);
        sort(array, mid, end);
        merge(array, start, end);
    }

    private static void merge(int[] array, int start, int end) {
        System.out.println(start + " " + end);
        if (end - start == 1) {
            return;
        }
        int[] result = new int[end - start];
        int mid = (end + start) / 2;
        int i = start, j = mid;
        int index = 0;
        for (; i < mid && j < end; ) {
            if (array[i] <= array[j]) {
                result[index] = array[i];
                i++;
            } else {
                result[index] = array[j];
                j++;
            }
            index++;
        }
        if (i >= mid) {
            for (; j < end; j++) {
                result[index] = array[j];
                index++;
            }
        }
        if (j >= end) {
            for (; i < mid; i++) {
                result[index] = array[i];
                index++;
            }
        }
        for (i = 0; i < result.length; i++) {
            array[start + i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 1, 2, 3, 5, 10};
        sort(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
}
