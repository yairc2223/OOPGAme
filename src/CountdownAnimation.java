/**
 * a class that is responsible fo counting down before every level starts.
 */

import biuoop.DrawSurface;
import biuoop.Sleeper;


/**
 * a class that is responsible fo counting down before every level starts.
 */

public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;

    /**
     * a constructor to countdown animation.
     *
     * @param numOfSeconds - number of seconds before every count.
     * @param countFrom    - from what number to count from.
     * @param gameScreen   the game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
    }

    /**
     * a method that draws the countdown.
     *
     * @param d the given draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        if (this.countFrom >= 0) {
            if (this.countFrom >= 0) {
                sleeper.sleepFor(2000);
                d.drawText(((d.getWidth() / 2) - 430) + 400 - this.countFrom * 50, d.getHeight() / 2,
                        "" + this.countFrom + "", 70);
            }
            if (this.countFrom == 0) {
                d.drawText(((d.getWidth() / 2) - 430) + 450 - this.countFrom * 50, d.getHeight() / 2,
                        "GO", 70);
            }
            this.countFrom = this.countFrom - 1;
        }

    }

    /**
     * checks if the animation should stop.
     *
     * @return wether the animation should stop.
     */
    public boolean shouldStop() {
        if (this.countFrom < 0) {
            this.stop = true;
        }
        return this.stop;
    }

    /**
     * checks if the animation should close.
     *
     * @return wether the animation should close.
     */
    public boolean shouldClose() {
        return false;
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