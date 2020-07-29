import biuoop.DrawSurface;

/**
 * @author Yair Cohen
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d the given draw surface.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * a method that adds the object to gameLevel.
     *
     * @param gameLevel the given gameLevel.
     */
    void addToGame(GameLevel gameLevel);
}

