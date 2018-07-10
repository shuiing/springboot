package com.jiangshui.springbootpractic.practice.Multithreading;

/**
 * @author xujiangshui
 * @Date on 2018/7/3 0003
 */


/**
 *
 */
public class Actor extends Thread {

    @Override
    public void run(){

        System.out.println();
        int count = 0;
        while (count<10) {
            System.out.println(getName() + "登场" + (++count));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public  static void  main(String[] args){
        Thread actor = new Actor();
        actor.setName("张三");
        actor.start();

        Thread actress = new Thread(new Actress(),"李四");
        actress.start();
    }
}

/**
 * 测试Thread线程内容共享
 */
class Actress implements Runnable{
    @Override
    public void run(){

        System.out.println();
        int count = 0;
        while (count<10) {
            System.out.println(Thread.currentThread().getName() + "登场" + (++count));

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}