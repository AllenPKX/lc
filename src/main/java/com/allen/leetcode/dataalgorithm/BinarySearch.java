package com.allen.leetcode.dataalgorithm;

import java.util.Random;

/**
 * @author ：Allen pan
 * @date ：Created in 2020/3/8 10:53
 * @description : 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
//        double random = Math.random();
        Random random = new Random(10);

        int n = 100;
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
//            array[i] = 1000*random;
            array[i] = random.nextInt(200);
            System.out.println("第" + i + "个:" + array[i]);
        }
        int a = 117;
        System.out.println(array[34]);
        int abc = biSearch(array, a);
        System.out.println(abc);
    }

    /**
     * 二分查找
     *
     * @param array
     * @param a
     * @return
     */
    public static int biSearch(int[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;//中间位置
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) { //向右查找
                lo = mid + 1;
            } else { //向左查找
                hi = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 冒泡排序
     *
     * @param a
     * @param n
     */
    public static void bubbleSort1(int[] a, int n) {
        int i, j;
        for (i = 0; i < n; i++) {//表示n 次排序过程。
            for (j = 1; j < n - i; j++) {
                if (a[j - 1] > a[j]) {//前面的数字大于后面的数字就交换
                    // 交换a[j-1]和a[j]
                    int temp;
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
//插入的数
            int insertVal = arr[i];
//被插入的位置(准备和前一个数比较)
            int index = i - 1;
//如果插入的数比被插入的数小
            while (index >= 0 && insertVal < arr[index]) {
//将把arr[index] 向后移动
                arr[index + 1] = arr[index];
//让index 向前移动
                index--;
            }
//把插入的数放入合适位置
            arr[index + 1] = insertVal;
        }
    }

    /**
     * 快速排序
     *
     * @param a
     * @param low
     * @param high
     */
    public void sort2(int[] a, int low, int high) {
        int start = low;
        int end = high;

        int key = a[low];
        while (end > start) {
//从后往前比较
            while (end > start && a[end] >= key) {
                //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            }


            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
//从前往后比较
            while (end > start && a[start] <= key) {
//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            }
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
//此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
//递归
        if (start > low) {
            sort2(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        }
        if (end < high) {
            sort2(a, end + 1, high);//右边序列。从关键值索引+1 到最后一个
        }
    }


    /**
     * 希尔排序
     * @param a
     */
    private void shellSort(int[] a) {
        int dk = a.length/2;
        while( dk >= 1 ){
            ShellInsertSort(a, dk);
            dk = dk/2;
        }
    }
    private void ShellInsertSort(int[] a, int dk) {
//类似插入排序，只是插入排序增量是1，这里增量是dk,把1 换成dk 就可以了
        for(int i=dk;i<a.length;i++){
            if(a[i]<a[i-dk]){
                int j;
                int x=a[i];//x 为待插入元素
                a[i]=a[i-dk];
                for(j=i-dk; j>=0 && x<a[j];j=j-dk){
//通过循环，逐个后移一位找到要插入的位置。
                    a[j+dk]=a[j];
                }
                a[j+dk]=x;//插入
            }
        }
    }
}
