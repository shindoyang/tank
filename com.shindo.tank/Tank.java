import java.awt.*;

/**
 * Created by shindo on 2020/5/31.
 */
public class Tank {
    int x, y;
    Dir dir = Dir.DOWN;

    private final static int SPEED = 10;

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    protected void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);

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
}