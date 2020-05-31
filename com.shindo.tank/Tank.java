import java.awt.*;

/**
 * Created by shindo on 2020/5/31.
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private final static int SPEED = 5;

    private boolean moving = false;
    private TanKFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public Tank(int x, int y, Dir dir, TanKFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    protected void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        moving();

    }

    private void moving() {
        if (!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;

        }
    }

    public void fire() {
        tf.bullets.add(new Bullet(this.x, this.y, this.dir, tf));
    }
}