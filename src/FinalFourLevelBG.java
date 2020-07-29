import biuoop.DrawSurface;

import java.awt.Color;

/**
 * a method that draws the background ot the final four level.
 */
public class FinalFourLevelBG implements Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the given draw surface.
     */
    public void drawOn(DrawSurface d) {

        d.setColor(Color.CYAN.darker());
        int x = 350;
        int y = 70;
        d.fillRectangle(0, 0, 1200, 800);
        d.setColor(Color.GRAY.brighter());
        d.fillCircle(200, 600, 40);
        d.fillCircle(160, 590, 40);
        d.fillCircle(170, 560, 40);
        d.fillCircle(230, 585, 40);
        d.fillCircle(250, 560, 40);
        d.fillCircle(240, 550, 50);
        for (int i = 1; i <= 30; i++) {
            d.drawLine(120 + i * 5, 600, 70 + i * 5, 770);
        }


        d.fillCircle(200 + x, 600 - y, 40);
        d.fillCircle(160 + x, 590 - y, 40);
        d.fillCircle(170 + x, 560 - y, 40);
        d.fillCircle(230 + x, 585 - y, 40);
        d.fillCircle(250 + x, 560 - y, 40);
        d.fillCircle(240 + x, 550 - y, 50);
        for (int i = 1; i <= 30; i++) {
            d.drawLine(120 + i * 5 + x, 600 - y, 70 + i * 5 + x, 770);
        }
        x = x + 250;

        d.fillCircle(200 + x, 600 + y, 40);
        d.fillCircle(160 + x, 590 + y, 40);
        d.fillCircle(170 + x, 560 + y, 40);
        d.fillCircle(230 + x, 585 + y, 40);
        d.fillCircle(250 + x, 560 + y, 40);
        d.fillCircle(240 + x, 550 + y, 50);
        for (int i = 1; i <= 30; i++) {
            d.drawLine(120 + i * 5 + x, 600 + y, 70 + i * 5 + x, 770);
        }
        x = x + 200;
        y = y + 70;

        d.fillCircle(200 + x, 600 - y, 40);
        d.fillCircle(160 + x, 590 - y, 40);
        d.fillCircle(170 + x, 560 - y, 40);
        d.fillCircle(230 + x, 585 - y, 40);
        d.fillCircle(250 + x, 560 - y, 40);
        d.fillCircle(240 + x, 550 - y, 50);
        for (int i = 1; i <= 30; i++) {
            d.drawLine(130 + i * 5 + x, 570 - y, 70 + i * 5 + x, 770);
        }

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
