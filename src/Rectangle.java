import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Cohen
 */
class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft the x y of the left above corner.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Return a (possibly empty) List of intersection
     * points with the specified line.
     *
     * @param line the lines.
     * @return we get list of points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> pointList = new ArrayList<>();
        double x = upperLeft.getX();
        double y = upperLeft.getY();
        Line up = new Line(x, y, (x + width), y);
        Line down = new Line(x, (y + height), x + width, y + height);
        Line left = new Line(x, y, x, y + height);
        Line right = new Line(x + width, y, x + width, y + height);
        if (line.isIntersecting(up)) {
            pointList.add(line.intersectionWith(up));
        }
        if (line.isIntersecting(down)) {
            pointList.add(line.intersectionWith(down));
        }
        if (line.isIntersecting(right)) {
            pointList.add(line.intersectionWith(right));
        }
        if (line.isIntersecting(left)) {
            pointList.add(line.intersectionWith(left));
        }
        return pointList;
    }

    /**
     * Return the width and height of the rectangle.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * sets a new value to new dx.
     *
     * @param nwidth the new value for x.
     */
    public void setWidth(double nwidth) {
        this.width = nwidth;
    }

    /**
     * gets the height of the rectangle.
     *
     * @return the
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * sets a new value to height.
     *
     * @param nheight the new value for height.
     */
    public void setHeight(double nheight) {
        this.height = nheight;
    }

    /**
     * sets new value to location.
     *
     * @param nupperLeft the new value to location.
     */
    public void setUpperLeft(Point nupperLeft) {
        this.upperLeft = nupperLeft;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return the upper left.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}