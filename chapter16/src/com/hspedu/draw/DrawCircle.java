package com.hspedu.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 演示如何在面板上画出圆形
 */

public class DrawCircle extends JFrame { //JFrame对应窗口，是一个画框

    //定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle() { //构造器
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口（画框）
        this.add(mp);
        //设置窗口的大小
        this.setSize(400, 300);
        //当点击窗口的叉，程序真正退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//可以显示
    }
}
//1.先定义一个面板MyPanel, 继承JPanel类，用于画图形
class MyPanel extends JPanel {

    //说明：
    //1. MyPanel 对象是一个画板
    //2. Graphics g 是一支画笔
    //3. Graphics 提供了很多绘图的方法
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类方法
        //画出一个圆形，
//        g.drawOval(10,10, 100, 100);

        //演示绘制不同的图形
//        g.drawLine(10, 10, 100, 100);//画直线
//        g.drawRect(10, 10, 100, 100);//画矩形边框
//
//        g.setColor(Color.blue); //设置画笔颜色
//        g.fillRect(10, 10, 100, 100);//画填充矩形
//        g.fillOval(10, 10, 100, 100);//填充椭圆
//
//        Image image = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bg.png"));//获取图片资源
//        g.drawImage(image, 10, 10, 175, 221, this);//画图片
        g.setFont(new Font("隶书", Font.BOLD, 50));//设置画笔的字体
        g.drawString("北京欢迎你", 100, 100);//画字符串（坐标左下角，此上均是左上角）

    }
}