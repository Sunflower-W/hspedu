package com.hspedu.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * 坦克大战的绘图区
 */

public class MyPanel extends JPanel implements KeyListener {
    // 定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;
    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
//        hero.setSpeed(5);
        //敌人坦克放入Vector，考虑多线程问题，敌人坦克同时动
        for(int i = 0; i < enemyTankSize; i ++ ) {
            EnemyTank enemyTank = new EnemyTank((i + 1) * 100, 0);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); //填充矩形，默认黑色

        //画出坦克-封装方法
        draw(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        for(int i = 0; i < enemyTanks.size(); i ++) {//为何不能i<3，因为敌人坦克可能被销毁
            EnemyTank enemyTank = enemyTanks.get(i);
            draw(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
        }
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
            case 0: //敌人坦克
                g.setColor(Color.cyan);
                break;
            case 1: //本方坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，绘制坦克
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false); //边缘突出显示
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false); //边缘突出显示
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false); //边缘突出显示
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false); //边缘突出显示
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
//            hero.setY(hero.getY() - 1);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
