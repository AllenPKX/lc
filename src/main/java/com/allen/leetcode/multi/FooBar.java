package com.allen.leetcode.multi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ：Allen pan
 * @date ：Created in 2020/3/30 17:34
 * @description :
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-foobar-alternately
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FooBar {
        private int n;
        private CountDownLatch a;
        private CyclicBarrier barrier;// 使用CyclicBarrier保证任务按组执行
        public FooBar(int n) {
            this.n = n;
            a = new CountDownLatch(1);
            barrier = new CyclicBarrier(2);// 保证每组内有两个任务
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            try {
                for (int i = 0; i < n; i++) {
                    printFoo.run();
                    a.countDown();// printFoo方法完成调用countDown
                    barrier.await();// 等待printBar方法执行完成
                }
            } catch(Exception e) {}
        }

        public void bar(Runnable printBar) throws InterruptedException {

            try {
                for (int i = 0; i < n; i++) {
                    a.await();// 等待printFoo方法先执行
                    printBar.run();
                    a = new CountDownLatch(1); // 保证下一次依旧等待printFoo方法先执行
                    barrier.await();// 等待printFoo方法执行完成
                }
            } catch(Exception e) {}
        }

}
