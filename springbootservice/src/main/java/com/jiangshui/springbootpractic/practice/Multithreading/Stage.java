package com.jiangshui.springbootpractic.practice.Multithreading;

/**
 * @author xujiangshui
 * @Date on 2018/7/3 0003
 */
public class Stage extends  Thread {
    @Override
    public void  run(){

        /* 开始启动了两个线程“水”和“江”
        *  然后“程”来了，停止两个线程。并启动线程“程”
        *  最后通过线程“程”通过join，使得线程“程”完成后才进行其他动作
        * */

        //这里调用了Runnable接口
        //先实例化，再实例化Thread，最后启动
        ArmyRunnable shui = new ArmyRunnable();
        ArmyRunnable jiang = new ArmyRunnable();

        Thread shuishui = new Thread(shui,"水军");
        Thread jiangjiang = new Thread(jiang,"江军");

        shuishui.start();
        jiangjiang.start();

        //给线程进行其他操作
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("中场");
        Thread cheng = new KeyPersonThread();
        cheng.setName("程");

        //停止进程
        shui.keepRunning=false;
        jiang.keepRunning=false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cheng.start();

//        其他进程停止，等待当前进程
        try {
            cheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


         System.out.println("结束");
    }
    public  static void  main(String[] args){
        //调用Thread，实例化后可以直接启动
        Thread stage = new Stage();
        stage.start();
    }
}
