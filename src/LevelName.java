import biuoop.DrawSurface;

/**
 * a method that writes the level name on the screen.
 */
public class LevelName implements Sprite {
    private String levelName;

    /**
     * a constructor to level name.
     *
     * @param lName the level name.
     */
    public LevelName(String lName) {
        this.levelName = lName;
    }

    /**
     * draw the sprite to the screen.
     *
     * @param d the given draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.drawText(900, 20, ("Level Name: " + this.levelName), 20);
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
