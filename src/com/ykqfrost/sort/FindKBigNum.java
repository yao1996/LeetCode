package com.ykqfrost.sort;

/**
 * @author ykq
 * @date 2020/9/25
 * 在O(n)时间内找到第K大的元素
 * 通过快排思想
 */
public class FindKBigNum {

    public static int findKBigNum(int[] array, int k) {
        return quickSort(array, 0, array.length, k);
    }

    private static int quickSort(int[] array, int start, int end, int k) {
        int q = array[end - 1];
        int i = start, j = start;
        while (j < end - 1) {
            if (array[j] < q) {
                if (i != j) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                i++;
                j++;
            } else {
                j++;
            }
        }
        array[end - 1] = array[i];
        array[i] = q;
        if (array.length - i == k) {
            return q;
        } else if (array.length - i > k) {
            return quickSort(array, i + 1, end, k);
        } else {
            return quickSort(array, start, i, k);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 9, 4, 3, 5, 10};
        int i = findKBigNum(array, 6);
        System.out.println(i);
    }
}
