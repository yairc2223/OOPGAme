
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Cohen
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private int numhits;
    private java.awt.Color color;
    private List<HitListener> hitListeners;

    /**
     * a constructor to block.
     *
     * @param rect    the rectangle of the block.
     * @param numhits the times the block got hit.
     * @param color   the color of the block.
     */
    public Block(Rectangle rect, int numhits, java.awt.Color color) {
        this.rect = rect;
        this.numhits = numhits;
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * gets the number of hits.
     *
     * @return - the number of hits.
     */
    public int getNumhits() {
        return this.numhits;
    }

    /**
     * gets the shape of the block.
     *
     * @return the shape.
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * Notify the object that we collided with it at collisionPoint with.
     * a given velocity.
     * The return is the new velocity expected after the hit (based on.
     * the force the object inflicted on us).
     *
     * @param hitter          - the ball that hits the block.
     * @param collisionPoint  the collision point.
     * @param currentVelocity the velocity of the object before the hit.
     * @return the new velocity after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double newdx = currentVelocity.getdx();
        double newdy = currentVelocity.getdy();
        //left
        if ((collisionPoint.getX() == this.rect.getUpperLeft().getX())
                && (collisionPoint.getY() >= this.rect.getUpperLeft().getY()
                && collisionPoint.getY() <= this.rect.getUpperLeft().getY() + this.rect.getHeight())) {
            newdx = -1 * newdx;

        }
        //low
        if (collisionPoint.getY() == this.rect.getUpperLeft().getY() + this.rect.getHeight()) {
            newdy = -1 * newdy;

        }
        //upper
        if ((collisionPoint.getY() == this.rect.getUpperLeft().getY())
                && (collisionPoint.getX() >= this.rect.getUpperLeft().getX()
                && collisionPoint.getX() <= this.rect.getUpperLeft().getX() + this.rect.getWidth())) {
            newdy = -1 * newdy;
        }
        if (collisionPoint.getX() == this.rect.getUpperLeft().getX() + this.rect.getWidth()) {
            newdx = -1 * newdx;
        }

        if (numhits > 0) {
            this.numhits--;
        }
        this.notifyHit(hitter);
        return new Velocity(newdx, newdy);
    }

    /**
     * draws the object.
     *
     * @param surface the given surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(), (int) this.rect.getWidth(), (int) this.rect.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(), (int) this.rect.getWidth(), (int) this.rect.getHeight());
        if (this.numhits > 0) {
            surface.setColor(this.color);
            surface.setColor(Color.white);
            int temp1 = (int) (this.rect.getUpperLeft().getX() + this.rect.getWidth() / 2);
            int temp2 = (int) ((this.rect.getUpperLeft().getY() + this.rect.getHeight() / 2));
            //surface.drawText(temp1, temp2, Integer.toString(numhits), 20);
        } else {
            surface.setColor(this.color);
            surface.setColor(Color.white);
            int temp3 = (int) (this.rect.getUpperLeft().getX() + this.rect.getWidth() / 2);
            //surface.drawText(temp3, (int) ((this.rect.getUpperLeft().getY() + this.rect.getHeight() / 2)), "X", 20);
        }

    }

    /**
     * returns the color of the object.
     *
     * @return the color of the object.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * a method that notifies the object that the time has passed and makes it move.
     */
    public void timePassed() {
    }

    /**
     * a method that adds the object to the gameLevel.
     *
     * @param gameLevel the given gameLevel
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
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
     * a method that sets the color of the blocks.
     *
     * @param c - the new color.
     */
    public void setColor(java.awt.Color c) {
        this.color = c;
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

    /**
     * a method that notifies and activates the hitevent method.
     *
     * @param hitter - the ball that hits.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}

