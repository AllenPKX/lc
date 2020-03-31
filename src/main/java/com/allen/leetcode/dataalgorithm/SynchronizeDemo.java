package com.allen.leetcode.dataalgorithm;

/**
 * @author ：Allen pan
 * @date ：Created in 2020/3/8 21:37
 * @description :
 */
public class SynchronizeDemo {
    public void method(){
        synchronized (this){
            System.out.println("synchronized");
        }
    }
}
