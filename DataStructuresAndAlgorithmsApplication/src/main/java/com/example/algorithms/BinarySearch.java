package com.example.algorithms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 二分查找
 * 需求:在有序数组A内，查找值target
 *  1.如果找到返回索引
 *  2.如果找不到返回-1
 * 前提:给定一个内涵n股份元素的有序数组A，满足A0<=A1<=A2....<=A(N-1),一个待查值target
 *  设置i=0,j=n-1
 *  如果i>j，结束查找，没找到
 *  设置m=floor((i+j)/2)，m为中间索引 ，floor是向下取整(<=(i+j)/2的最小整数) 取中间值
 *  如果target<Am设置j=m+1，跳到第二步
 *  如果Am<target,设置i=m+1,跳到第二步
 *  如果Am = target, 结束查找 找到了
 *
 * @author admin*/
public class BinarySearch {
    /**
     * java8 stream流进行初始化赋值
     * Stream.of(5,14,22,30,31,38,41,44).collect(Collectors.toList());
     */

    public static void main(String[] args) {
        int[] nums = new int[]{5,14,22,30,31,38,41,44};
        System.out.println(binarySearchBasic(nums,50));
    }

    /**
     * 问题1：为什么是i <= j 意味着区间内有未比较的元素 ，而不是 i<j ?
     * i == j 意味着 i和j 同时指向的元素也会参与比较
     * i < j 只意味着 m 指向的元素参与比较
     *
     * 问题2： (i + j) / 2 有没有问题？数太大的话会超过int的最大位数 ，会变成负数
     * java中的数最高位都是符号位 int装不下 变成了负数
     *  >>> 1 无符号右移一位 偶数为除2 奇数为除2取整数
     *
     */
    public static int binarySearchBasic(int[] nums,int target){
        // 设置指针和初始值
        int i = 0 , j = nums.length-1;
        // 范围内有元素
        while (i <= j){
//            int m = (i + j) / 2;
            int m = (i + j) >>> 1;
            // 如果target小于坐标m上的值，表示m及后面的值都不符合条件
            if(target < nums[m]){
                // 设置j等于坐标m减1
                j = m - 1;
            }
            // 如果target大于坐标m上的值，表示m及前面的值都不符合条件
            else if( target > nums[m]){
                // 设置i等于坐标m加1
                i = m + 1;
            }else {
                // 等于则返回坐标
                return m;
            }
        }
        return -1;
    }
}
