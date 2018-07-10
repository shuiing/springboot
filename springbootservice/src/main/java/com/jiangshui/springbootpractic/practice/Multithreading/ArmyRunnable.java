package com.jiangshui.springbootpractic.practice.Multithreading;

/**
 * @author xujiangshui
 * @Date on 2018/7/3 0003
 */
public class ArmyRunnable implements Runnable {

    //volatile保证了线程可以正确的读取其他线程写入的值
    //volatile 可见性ref JMM,happens-before。需要自己去看看
    volatile boolean keepRunning = true;

    @Override
    public void run(){
        while (keepRunning){
            for(int i=0;i<2;i++){
                System.out.println(Thread.currentThread().getName()+"进攻"+i);
                //让出处理器，是的不同的线程能随机运行。
                Thread.yield();
            }
        }
    }
}
