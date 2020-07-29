/**
 * The class of the score indicator.
 */

import biuoop.DrawSurface;


/**
 * The class of the score indicator.
 */

public class ScoreIndicator implements Sprite {
    private Rectangle rect;
    private Counter score;
    private java.awt.Color color;

    /**
     * a constructor to scoreindicator.
     *
     * @param rect  the rectangle of the score.
     * @param score the score of the game.
     * @param color the color of the rectangle.
     */
    public ScoreIndicator(Rectangle rect, Counter score, java.awt.Color color) {
        this.rect = rect;
        this.score = score;
        this.color = color;
    }

    /**
     * gets the score of the game.
     *
     * @return the score of the game.
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * draws the object on the screen.
     *
     * @param d the given draw surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(), (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.setColor(this.color.darker().darker());
        d.drawRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(), (int) this.rect.getWidth(), (int) this.rect.getHeight());
        d.drawText(550, 20, "Score: " + this.score.getValue(), 20);
    }

    /**
     * a method that notifies the object that the time has passed and makes it move.
     */
    public void timePassed() {

    }

    /**
     * a method that adds the object to the gameLevel and to the sprites.
     *
     * @param gameLevel - the given gameLevel.
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }
}
