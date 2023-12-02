package com.hspedu.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 演示小球通过键盘控制上下左右的移动-> 讲解Java的事件控制
 */
public class BallMove extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400, 300);
        //窗口JFrame对象可以监听到面板上发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//画板，可以画出小球
//KeyListener 监听器，监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以移动，将球的左上角坐标设置为变量
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);


    }

    //有字符输出时，该方法被触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //System.out.println(e.getKeyChar() + "被按下");
        //根据用户按下的不同健，来处理小球的移动（上下左右键）
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {//java中给每一个键分配一个int值，VK_DOWN对应向下键
            y ++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y --;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x --;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x ++;
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}