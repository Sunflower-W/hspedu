package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 使用OOP（面向对象编程）
 * 将各个功能对应一个方法
 */

public class SmallChangeSysOOP {

    //定义相关的变量
    boolean loop = true; //默认显示菜单
    Scanner scanner = new Scanner(System.in); //接收输入
    String key = "";

    //2. 完成零钱通明细（数组-无法动态扩容、对象、字符串拼接)
    //（1） 可以把收益入账和消费保存到数组；（2）使用对象；（3）简单的使用String换行拼接
    String details = "-----------------零钱通明细-----------------";

    //3. 完成收益入账
    // 定义新的变量
    double money = 0;//金额
    Date date = null;//时间 java.util.Data表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //用于日期格式化的对象
    double balance = 0;//余额

    //4. 消费
    //定义新变量，保存消费说明
    String note = "";

    //先完成显示菜单，并可以选择
    public void mainMenu(){
        do { //默认显示一次使用do while循环

            System.out.println("\n=================零钱通菜单OOP=================");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益入账");
            System.out.println("\t\t\t\t3 消费");
            System.out.println("\t\t\t\t4 退     出");

            System.out.print("请选择（1-4）：");
            key = scanner.next();

            //使用switch分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }

        } while (loop);
    }

    //完成零钱通明细
    public void detail(){
        System.out.println(details);
    }

    //完成收益入账
    public void income() {
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        //money的只的范围校验
        //编程思想：逆向思维，找出不正确金额的条件，给出提示，直接break。1) 不正确的特例更容易想到；2) 可扩展性，如果添加条件，添加一个判断即可
        if (money <= 0) {
            System.out.println("收益入账金额需要大于0 ");
            return;
        }
        balance += money;
        date = new Date(); //获取当前日期
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
        return;
    }

    //消费
    public void pay(){
            System.out.println("消费金额：");
            money = scanner.nextDouble();
            // money校验，不能超出余额
            if (money > balance || money <= 0) {
                System.out.println("消费金额应该在0-" + balance);
                return;
            }
            System.out.println("消费说明：");
            note = scanner.next();
            balance -= money;
            //拼接消费信息到details
            date = new Date();
            details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
            return;
        }
    //退出
    public void exit(){
        // (1)用户输入4退出时，给出"你确定要退出吗?y/n"，必须输入正确的y/n，否则循环输入指令，直到输入y或n
        String choice = "";// 定义变量
        // (2)使用 while + break 处理接收到的输入是y或n
        while (true) {
            System.out.println("你确定要退出吗?y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
        }
        // (3)退出while循环后，进行判断
        if (choice.equals("y")) {
            loop = false;
            System.out.println("---------------退出了零钱通项目--------------");
        }
        // (4)建议一段代码完成一个小功能
        return;
    }
}
