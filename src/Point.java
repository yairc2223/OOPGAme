/**
 * @author Yair Cohen.
 * the class of point means an object of x and y.
 */
public class Point {
    private double y, x;

    // constructor

    /**
     * @param newx - the x of the point.
     * @param newy - the y of the point
     */
    public Point(double newx, double newy) {
        this.x = newx;
        this.y = newy;
    }

    /**
     * calculates the distance between 2 points.
     *
     * @param other - the other point on which we should calculate the distance.
     * @return the distance between the two points.
     */
    // distance -- return the distance of this point to the other point
    public double distance(Point other) {
        double x2 = other.getX();
        double y2 = other.getY();
        double distance = Math.sqrt((this.x - x2) * (this.x - x2) + (this.y - y2) * (this.y - y2));
        return distance;
    }

    /**
     * returns if the points are equal.
     *
     * @param p2 - the other point on which we should tell if they are equal.
     * @return the distance between the two points.
     */
    // equals -- return true is the points are equal, false otherwise
    public boolean equals(Point p2) {
        if ((this.x == (p2.getX())) && (y == (p2.getY()))) {
            return true;
        }
        return false;
    }

    /**
     * Return the x and y values of this point.
     *
     * @return the x of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * sets a new value to x.
     *
     * @param nx the new x value.
     */
    public void setX(double nx) {
        this.x = nx;
    }

    /**
     * sets a ne value to y.
     *
     * @param ny the new value.
     */
    public void setY(double ny) {
        this.y = ny;
    }

    /**
     * @return the y of the point.
     */
    public double getY() {
        return this.y;
    }

}
