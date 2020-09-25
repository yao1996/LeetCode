package com.ykqfrost.sort;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/9/24
 * 冒泡排序
 * 优化1：结束标志改为最后一次遍历时无数字交换
 * 优化2：内部循环的结束位置，改为最后一次交换点
 */
public class BubbleSort {

    public void sort(int[] array) {
        int lastSwapPos = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            int k = lastSwapPos;
            for (int j = 0; j < k; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    lastSwapPos = j;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 9, 2, 3, 5, 10};
        BubbleSort sort = new BubbleSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
