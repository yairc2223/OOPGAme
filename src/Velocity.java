/**
 * @author Yair Cohen.
 * This class is defining the velocity of objets, how much they move in DX and DY or in what angel and speed.
 * // Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    // constructor
    private double dx, dy;

    /**
     * put values in the object values.
     *
     * @param dx - dx the change in X.
     * @param dy - dy the change in y.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * converts the array of strings from strings to an array of integers.
     *
     * @param angle - angle represents the angle of which the object moves.
     * @param speed - hoe fast the object moves.
     * @return velocity - returns the velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.cos((angle - 90) / 180 * 3.141592653589793) * speed;
        double dy = Math.sin((angle - 90) / 180D * 3.141592653589793) * speed;
        return new Velocity(dx, dy);
    }
    /**
     * a method that allows access to the dx value.
     *
     * @return the dx.
     */
    public double getdx() {
        return this.dx;
    }

    /**
     * sets new value to dx.
     *
     * @param newdx -the change in x.
     */
    public void setdx(double newdx) {
        this.dx = newdx;
    }

    /**
     * sets new value to dy.
     *
     * @param newdy - the change in y.
     */

    public void setdy(double newdy) {
        this.dy = newdy;
    }

    /**
     * a method that allows access to the dy value.
     *
     * @return the dy.
     */
    public double getdy() {
        return this.dy;
    }

    /**
     * // Take a point with position (x,y) and return a new point.
     * // with position (x+dx, y+dy).
     *
     * @param p - the current point of the object.
     * @return velocity - the new point after changing its location.
     */
    public Point applyToPoint(Point p) {
        Point newp = new Point((p.getX() + dx), (p.getY() + dy));
        return newp;
    }

    /**
     * a method in which we put the velocity value.
     *
     * @param newdy - the change in y.
     * @param newdx - the change in x.
     */
    public void setVelocity(double newdx, double newdy) {
        this.setdy(newdy);
        this.setdx(newdx);
    }
}