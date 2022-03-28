package com.rango;

/**
 * 找到转折点
 */
public class FindTurnPoint {

    public static void main(String[] args) {
        System.out.println(findTurnPoint(new int[]{1, 3, 4, 5, 6, 7, 8, 9, 2}));
    }

    public static int findTurnPoint(int[] arr) {
        if (arr.length == 0) return -1;

        //单调递减
        if (arr[0] > arr[1]) {
            return arr[0];
        }

        int i = 0, j = arr.length - 1;

        //单调递增
        if (arr[j] > arr[j - 1]) {
            return arr[j];
        }

        //二分
        while (i < j) {
            int mid = (i + j) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            //在左侧
            if (arr[mid] < arr[mid - 1]) {
                j = mid - 1;
            }
            //在右侧
            if (arr[mid] < arr[mid + 1]) {
                i = mid + 1;
            }
        }
        return -1;
    }
}
