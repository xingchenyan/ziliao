package com.example.laogong.threadcode.createThreadMeothd;

public class BothRunnableThread {
    public static void main(String[] args) {
        /**
         * run方法源码中先判断runnable对象是否为空，后调用runnable的run，这里thread类重写的run方法 所以走thread
         * TODO 亮点：准确讲，创建线程只有thread一种方式，实现线程的执行单元有两种方法：
         * TODO  1.实现runnable接口的run方法，然后把runnable实例传给thread类
         * TODO  2.继承thread，重写run方法
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();

    }
}
