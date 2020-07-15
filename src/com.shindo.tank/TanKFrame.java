package com.shindo.tank;

import com.shindo.tank.Bullet;
import com.shindo.tank.Dir;
import com.shindo.tank.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shindo on 2020/5/28.
 */
public class TanKFrame extends Frame {
    Tank myTank = new Tank(200, 200, Dir.DOWN, this);
    List<Bullet> bullets = new ArrayList<Bullet>();

    //    Bullet bullet = new Bullet(300, 300, Dir.DOWN);
    final static int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    public TanKFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        //键盘事件的监听
        this.addKeyListener(new MyKeyListener());

        //窗口事件的监听
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /*
    游戏的概念：双缓冲
    解决屏幕闪烁的现象
     */
    Image offScreanImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreanImage == null) {
            offScreanImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScrean = offScreanImage.getGraphics();
        Color c = gOffScrean.getColor();
        gOffScrean.setColor(Color.black);
        gOffScrean.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScrean.setColor(c);
        paint(gOffScrean);
        g.drawImage(offScreanImage, 0, 0, null);
    }


    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量：" + bullets.size(), 10, 60);
        g.setColor(c);

        myTank.paint(g);

        //方法一
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        //集合内部的Itaretor，中途不允许在别的地方删除，会引发ConcurrentModificationException
        /*for (Bullet bullet : bullets) {
            bullet.paint(g);
        }*/

        //方法二
        /*for (Iterator<Bullet> it = bullets.iterator(); it.hasNext()) {
            Bullet b = it.next();
            if (!live) it.remove();
        }*/

    }

    class MyKeyListener extends KeyAdapter {

        boolean bl = false;
        boolean bu = false;
        boolean br = false;
        boolean bd = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }


        private void setMainTankDir() {
            if (!bl && !br && !bu && !bd) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bl) myTank.setDir(Dir.LEFT);
                if (br) myTank.setDir(Dir.RIGHT);
                if (bu) myTank.setDir(Dir.UP);
                if (bd) myTank.setDir(Dir.DOWN);
            }

        }
    }
}
