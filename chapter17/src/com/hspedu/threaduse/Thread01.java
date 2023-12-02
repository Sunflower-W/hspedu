package com.hspedu.threaduse;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException{

        //创建一个Cat对象，可以当线程使用
        Cat cat = new Cat();

        //读源码
        /*
            (1)
            public void start(){
                start0();
            }
            (2)
            //start0() 是本地方法，是JVM调用，底层是c/c++
            //真正实现多线程效果的是start0()，而不是run方法
            //start()通过JVM机调用start0()方法后，该线程并不一定会立马执行，只是将线程变成了可运行状态。具体什么时候执行，取决于CPU，由CPU统一调度
            根据不同的操作系统来实现，取决于CPU资源、内存资源、IO资源
            private native void start0();

         */
        cat.start();//启动线程->最终执行run方法
//        cat.run();//run方法就是一个普通的方法，并没有真正启动一个新的线程，阻塞在此，串行执行完成才往下执行，这时是main线程
        //当mian线程启动一个子线程Thread-0，主线程不会阻塞，会继续执行
        //这时主线程和子线程是交替并发执行的
        System.out.println("主线程继续执行" + Thread.currentThread().getName());
        for(int i = 0; i < 60; i++ ){
            System.out.println("主线程 i=" + i);
            // 让主线程休眠
            Thread.sleep(1000);
        }
    }
}


//1.当一个类继承了Thread类，该类就可以当作线程
//2.我们会重写run方法，写上自己的业务代码
//3.run Thread 类 实现了 Runnable 接口的 run 方法
/*
@Override
    public void run() {
        Runnable task = holder.task;
        if (task != null) {
            task.run();
        }
    }
 */

class Cat extends Thread {

    int times;
    @Override
    public void run() {
        super.run();//重写run方法，写上自己的业务逻辑

        while (true) {
            //该线程每隔1秒，在控制台输出"喵喵，我是小猫咪"
            System.out.println("喵喵，我是小猫咪" + times++ +"线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);//1000ms=1s
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times == 80){
                break;//退出while，退出循环
            }
        }
    }
}