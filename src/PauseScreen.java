import biuoop.DrawSurface;

import java.awt.Color;

/**
 * a class that responsible for pausing the game when needed.
 */
public class PauseScreen implements Animation {
    /**
     * a constructor.
     */
    public PauseScreen() {
    }

    /**
     * a method that draws on the drawsurface and checks if a key is pressed.
     *
     * @param d - the drawsurface.
     */
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLUE);
        d.drawText((d.getWidth() / 2) - 230, d.getHeight() / 2, "paused -- press space to continue", 32);
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