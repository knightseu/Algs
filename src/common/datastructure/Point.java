package common.datastructure;

/**
 * Created by xuanlin on 2/22/17.
 */
public class Point {
    public int x, y;
    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }

    public int distanceTo(Point b) {
        return (this.x - b.x) * (this.x - b.x) + (this.y - b.y) * (this.y - b.y);
    }
}
