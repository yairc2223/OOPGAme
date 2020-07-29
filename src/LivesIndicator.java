/**
 * class lives indicator.
 */

import biuoop.DrawSurface;

/**
 * The class that tracks the life in the game.
 * implements sprite interface.
 */

public class LivesIndicator implements Sprite {
    private Rectangle rectangle;
    private Counter lives;

    /**
     * a constructor to LivesIndicator.
     *
     * @param rect     the rectangle of the lives.
     * @param numlives - the number of lives.
     */
    public LivesIndicator(Rectangle rect, Counter numlives) {
        this.rectangle = rect;
        this.lives = numlives;
    }

    /**
     * draws the object.
     *
     * @param d - the given surface.
     */
    public void drawOn(DrawSurface d) {

        String str = "";
        for (int i = 0; i < lives.getValue(); i++) {
            str = str + " # ";
        }
        d.drawText(10, 20, ("Lifes: " + this.lives.getValue() + " " + str), 20);

    }

    /**
     * geys the number of lives.
     *
     * @return the number of lives in the game.
     */
    public Counter getLives() {
        return this.lives;
    }

    /**
     * a method that notifies the object that the time has passed and makes it move.
     */
    public void timePassed() {
    }

    /**
     * a method that adds the object to the gameLevel.
     *
     * @param gameLevel - the given gameLevel
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
