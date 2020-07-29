import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.List;

/**
 * @author Yair Cohen.
 */
public class Paddle implements Sprite, Collidable, HitNotifier {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private int speed;
    private List<HitListener> hitListeners;

    /**
     * creates the paddle.
     *
     * @param gui  gets the gui.
     * @param rect the shape of the paddle.
     * @param speed the speed of the game.
     */
    public Paddle(GUI gui, Rectangle rect, int speed) {
        this.keyboard = gui.getKeyboardSensor();
        this.rectangle = rect;
        this.speed = speed;
    }

    /**
     * moves the paddle to the left.
     */
    public void moveLeft() {
        this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() - speed,
                this.rectangle.getUpperLeft().getY()));
    }

    /**
     * moves the paddle to the right.
     */
    public void moveRight() {
        this.rectangle.setUpperLeft(new Point(this.rectangle.getUpperLeft().getX() + speed,
                this.rectangle.getUpperLeft().getY()));
    }

    /**
     * a method that notifies the object that the time has passed and makes it move.
     * the object is controlled through the keyboard sensor.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }

    }

    /**
     * draws the object on the screen.
     *
     * @param d the given draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.MAGENTA.brighter());
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * gets the rectangle.
     *
     * @return the rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * chenges the velocity size and direction after the hit.
     *
     * @param hitter          - the ball that hits the block.
     * @param collisionPoint  the collision point.
     * @param currentVelocity the current velocity of the object.
     * @return the new velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double location;
        location = ((collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) * 5)
                / this.rectangle.getWidth();
        double v = Math.sqrt((currentVelocity.getdx()) * (currentVelocity.getdx())
                + (currentVelocity.getdy()) * (currentVelocity.getdy()));
        if (location >= 0 && location < 1) {
            return currentVelocity.fromAngleAndSpeed(300, v);
        }
        if (location >= 1 && location < 2) {
            return currentVelocity.fromAngleAndSpeed(330, v);
        }
        if (location >= 2 && location < 3) {
            currentVelocity.setdx(0.001);
            currentVelocity.setdy(-v);
            return currentVelocity;
        }
        if (location >= 3 && location < 4) {
            return currentVelocity.fromAngleAndSpeed(30, v);
        }
        if (location >= 4 && location <= 5) {
            return currentVelocity.fromAngleAndSpeed(60, v);
        } else {
            return currentVelocity;
        }

    }


    /**
     * a method that adds the object to the game and to the sprites and collidables.
     *
     * @param g - the given game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * a method that removes the object from the gameLevel.
     *
     * @param gameLevel the given gameLevel
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    /**
     * a method that adds a given Hit listener to the list of hit listeners.
     *
     * @param hl - a given Hit listener to add to the list of hit listeners.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * a method that removes a given Hit listener to the list of hit listeners.
     *
     * @param hl - a given Hit listener to remove from the list of hit listeners.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}