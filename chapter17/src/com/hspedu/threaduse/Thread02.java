package com.hspedu.threaduse;

/**
 * 通过实现接口Runnable来开发线程
 * 底层使用了设计模式[代理模式] => 代码模拟
 */

public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
//        dog.start();//这里不能调用start
        //创建Thread对象，把dog对象(实现Runnable)，放入Thread
//        Thread thread = new Thread(dog);
//        thread.start();

        Tiger tiger = new Tiger();//实现了Runnable接口
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Animal {}
class Tiger extends Animal implements Runnable {
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫");
    }
    //Tiger类继承了Animal类，Java是单继承的，不能再直接继承ThreadProxy
    //让Tiger实现Runnable接口，Tiger的对象实例target是可以直接赋给构造器


}

//线程代理类，模拟了一个极简的Thread
class ThreadProxy implements Runnable { //可以把ThreadProxy类当作Thread

    private Runnable target = null;//属性，类型是Runnable

    @Override
    public void run() {
        if(target != null){
            target.run();//动态绑定（运行类型Tiger）
        }

    }

    //构造器中接收了一个实现了Runnable接口的对象
    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0();//真正实现多线程的方法
    }

    public void start0() {
        run();
    }
}



class Dog implements Runnable { //通过实现Runnable接口开发线程

    @Override
    public void run() {
        int count = 0;
        while(true) {
            System.out.println("小狗汪汪叫..hi" + count++ + Thread.currentThread().getName());
            try {
                Thread.sleep(1000); // 休眠1s
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(count == 10) {
                break;
            }
        }
    }
}