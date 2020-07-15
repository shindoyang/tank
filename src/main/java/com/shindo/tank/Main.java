package com.shindo.tank;
/**
 * Created by shindo on 2020/5/28.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello");
        TanKFrame tank = new TanKFrame();
        while (true) {
            Thread.sleep(50);
            tank.repaint();
        }
    }

}
