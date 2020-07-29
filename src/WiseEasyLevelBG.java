import biuoop.DrawSurface;

import java.awt.Color;

/**
 * a class that draws the background to Wide easy level.
 */
public class WiseEasyLevelBG implements Sprite {
    /**
     * a constructor.
     */
    public WiseEasyLevelBG() {

    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the given draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 1200, 800);
        d.setColor(Color.YELLOW);
        for (int i = 1; i <= 100; i++) {
            d.drawLine(150, 150, 12 * i, 350);
        }
        d.setColor(Color.ORANGE.brighter());
        d.fillCircle(150, 150, 70);
        d.setColor(Color.YELLOW.darker());
        d.fillCircle(150, 150, 60);
        d.setColor(Color.YELLOW);
        d.fillCircle(150, 150, 50);

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
