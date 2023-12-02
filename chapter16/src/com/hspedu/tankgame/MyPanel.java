package com.hspedu.tankgame;

import javax.swing.*;
import java.awt.*;

/**
 * 坦克大战的绘图区
 */

public class MyPanel extends JPanel {
    // 定义我的坦克
    Hero hero = null;
    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //填充矩形，默认黑色

        //画出坦克-封装方法
        draw(hero.getX(), hero.getY(), g, 0, 0);
    }

    //编写方法-画出坦克

    /**
     *
     * @param x 坦克的左上角x坐标
     * @param y 坦克的左上角y坐标
     * @param g 画笔
     * @param direct 坦克方向（上下左右）
     * @param type 坦克类型
     */
    public void draw(int x, int y, Graphics g, int direct, int type) {

        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //本方坦克
                g.setColor(Color.cyan);
                break;
            case 1: //敌人坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，绘制坦克
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false); //边缘突出显示
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 20, x + 20, y);

            default:
                System.out.println("暂时没有处理");
        }

    }
}
