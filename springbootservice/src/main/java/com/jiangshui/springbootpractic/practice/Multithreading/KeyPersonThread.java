package com.jiangshui.springbootpractic.practice.Multithreading;

/**
 * @author xujiangshui
 * @Date on 2018/7/3 0003
 */
public class KeyPersonThread extends Thread {
    @Override
    public void run(){
        System.out.println("登场");
        for(int i=0;i<2;i++){
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println("下场");
    }
}
