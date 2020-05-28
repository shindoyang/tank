import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by shindo on 2020/5/28.
 */
public class TanKFrame extends Frame {
    int x = 200, y = 200;

    public TanKFrame() {
        setSize(800, 600);
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

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x, y, 50, 50);
        x += 10;
        y += 10;

    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }


    }
}
