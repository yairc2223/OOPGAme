import biuoop.DrawSurface;

import java.awt.Color;

/**
 * a method that draws the background ot the GREEN3level.
 */
public class Green3LevelBG implements Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the given draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.GREEN.darker());
        d.fillRectangle(0, 0, 1200, 800);
        d.setColor(Color.BLACK);
        d.fillRectangle(90, 400, 100, 400);
        d.setColor(Color.WHITE);
        for (int i = 1; i <= 30; i++) {
            for (int j = 1; j <= 9; j++) {
                d.fillRectangle(87 + j * 10, 390 + i * 20, 7, 9);
            }
        }
        d.setColor(Color.GRAY);
        d.fillRectangle(120, 300, 40, 100);
        d.setColor(Color.GRAY.darker());
        d.fillRectangle(130, 200, 20, 100);

        d.setColor(Color.ORANGE.brighter());
        d.fillCircle(139, 185, 15);

        d.setColor(Color.RED.darker());
        d.fillCircle(139, 185, 10);

        d.setColor(Color.WHITE);
        d.fillCircle(139, 185, 5);

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
