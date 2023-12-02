package com.hspedu.ticket;

/**
 * 使用多线程，模拟三个窗口同时售票
 */

public class SellTicket {
    public static void main(String[] args) {

//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//        //这里会出现超卖
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

        System.out.println("===使用实现接口的方法===");
        SellTicket02 sellTicket02 = new SellTicket02();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();
        new Thread(sellTicket02).start();

    }
}

//使用Thread方式
class SellTicket01 extends Thread {

    private static int ticketNum = 100;//多个线程共享num 用static变量

    @Override
    public void run() {
        while (true) {

            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + "售出一张票" + " 剩余票数 = " + ticketNum--);

        }
    }
}

// 实现接口方式
class SellTicket02 implements Runnable{

    private static int ticketNum = 100;//多个线程共享num 用static变量

    @Override
    public void run() {
        while (true) {

            if(ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + "售出一张票" + " 剩余票数 = " + ticketNum--);

        }
    }
}