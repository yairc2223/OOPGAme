import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * a class that responsible for printing the appropriate message at the end of the game..
 */
public class EndScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private int score;
    private boolean win;
    private boolean close;

    /**
     * a constructor to ENDSCREEN.
     *
     * @param keyboardSensor the keyboard sensor.
     * @param win            boolean wether the player won.
     * @param score          the score of the player.
     */
    public EndScreen(KeyboardSensor keyboardSensor, boolean win, int score) {
        this.keyboard = keyboardSensor;
        this.win = win;
        this.stop = false;
        this.score = score;
        this.close = false;
    }

    /**
     * a method that draws on the drawsurface and checks if a key is pressed.
     *
     * @param d - the drawsurface.
     */
    public void doOneFrame(DrawSurface d) {
        if (this.win) {
            d.setColor(Color.MAGENTA);
            d.fillRectangle(0, 0, 1200, 800);
            d.setColor(Color.CYAN);
            d.drawText((d.getWidth() / 2) - 300, d.getHeight() / 2 - 100, "You Win ! ! !", 100);
            d.drawText((d.getWidth() / 2) - 500, d.getHeight() / 2, "You are the BEST", 120);
            d.drawText((d.getWidth() / 2) - 400, d.getHeight() / 2 + 100, "Your score is: " + this.score, 100);
        } else {
            d.setColor(Color.GRAY);
            d.fillRectangle(0, 0, 1200, 800);
            d.setColor(Color.red);
            d.drawText((d.getWidth() / 2) - 350, d.getHeight() / 2, "GAME OVER", 120);
            d.drawText((d.getWidth() / 2) - 400, d.getHeight() / 2 + 100, "Your score is: " + this.score, 100);
        }

    }

    /**
     * checks if the animation should stop.
     *
     * @return wether the animation should stop.
     */
    public boolean shouldStop() {
        return false;
    }

    /**
     * checks if the animation should close.
     *
     * @return wether the animation should close.
     */
    public boolean shouldClose() {
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.close = true;
        }
        return this.close;

    }

    /**
     * checks if the animation is finished.
     *
     * @return wether the animation is finished.
     */
    public boolean isFinished() {
        return false;
    }
}
