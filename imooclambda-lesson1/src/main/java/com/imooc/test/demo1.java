package com.imooc.test;

public class demo1 {
    public static void main(String[] args) {
        // 1.传统模式下，新线程的创建
        new Thread(new Runnable() {
            public void run() {
                System.out.println("threading..."+Thread.currentThread().getId());
            }
        }).start();
        // 2.jdk8新特性，lambda表达式优化线程模式
        new Thread(()->{
            System.out.println("lambda threading..."+Thread.currentThread().getId());
        }).start();
    }
}
