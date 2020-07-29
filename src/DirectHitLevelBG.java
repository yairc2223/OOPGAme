import biuoop.DrawSurface;

import java.awt.Color;

/**
 * a class that draws the background to DirectHitLevel.
 */
public class DirectHitLevelBG implements Sprite {
    /**
     * a constructor.
     */
    public DirectHitLevelBG() {

    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the given draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 1200, 800);
        d.setColor(Color.red);
        d.drawCircle(d.getWidth() / 2, d.getHeight() / 2 - 95, 70);
        d.drawCircle(d.getWidth() / 2, d.getHeight() / 2 - 95, 60);
        d.drawCircle(d.getWidth() / 2, d.getHeight() / 2 - 95, 50);
        d.drawLine(d.getWidth() / 2, d.getHeight() / 2 - 180, d.getWidth() / 2, d.getHeight() / 2);
        d.drawLine(d.getWidth() / 2 - 90, d.getHeight() / 2 - 95, d.getWidth() / 2 + 90, d.getHeight() / 2 - 95);
    }

    /**
     * notify the sprite that time has passed.
     */
    public void timePassed() {

    }

    /**
     * a method that adds the object to gameLevel.
     *
     * @param gameLevel the given gameLevel.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
