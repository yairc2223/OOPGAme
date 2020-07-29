/**
 * @author Yair Cohen.
 * a class that defines a fileed circle wuth center point, radius and color.
 */

import biuoop.DrawSurface;


/**
 * this class defines an object that acts like a ball, with center point, size & color.
 * with the option to change direction when it hits a predefined border.
 */
public class Ball implements Sprite {
    // constructor
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;

    /**
     * a method that puts values in the constructor fields.
     *
     * @param center          - the center point of the ball.
     * @param r               the radius or size of the ball.
     * @param color           - the color of the ball.
     * @param v               - the velocity of the ball.
     * @param gameenvironment the game enviornment;
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity v, GameEnvironment gameenvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = v;
        this.gameEnvironment = gameenvironment;
    }

    /**
     * a method that puts values in the constructor fields.
     *
     * @param gameEnvi the game enviornment onw which we work on.
     * @param x        - the center point in x.
     * @param y        - the center point in y.
     * @param r        - the size of the ball
     * @param color    -  the color of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment gameEnvi) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvi;
    }

    /**
     * a method that allows access to the x value.
     *
     * @return the x of the center.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * a method that allows access to the y value.
     *
     * @return the y of the center.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * a method that allows access to the size value.
     *
     * @return the size of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * a method that allows access to the color.
     *
     * @return the color of the ball.
     */

    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * a method that sets the color of the ball.
     *
     * @param c - the new color.
     */
    public void setColor(java.awt.Color c) {
        this.color = c;
    }

    /**
     * a method tha draw the objects.
     *
     * @param surface - the draw surface on which we draw.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle((int) center.getX(), (int) center.getY(), this.getSize());

    }

    /**
     * a method in which we put the velocity value.
     *
     * @param newv - the velocity.
     */
    public void setVelocity(Velocity newv) {
        this.v = newv;
    }

    /**
     * a method in which we put the velocity value.
     *
     * @param dy - the change in y.
     * @param dx - the change in x.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * a method that allows access to the velocity.
     *
     * @return the velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * a method that allows the animation to move on the frame without getting out.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, (this.v.applyToPoint(this.center)));
        CollisionInfo collid = this.gameEnvironment.getClosestCollision(trajectory);
        if (collid == null) {
            this.center = trajectory.end();
        } else {
            this.setVelocity(collid.getCollidable().hit(this, collid.getIntresction(), this.getVelocity()));
        }
    }

    /**
     * a method that notifies the object that the time has passed and makes it move.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * a method that adds the object to the gameLevel.
     *
     * @param gameLevel the given gameLevel to which we add the object.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * a method that removes the ball from the given gameLevel.
     *
     * @param gameLevel - the given gameLevel.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
}