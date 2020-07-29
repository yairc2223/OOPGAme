import biuoop.DrawSurface;

/**
 * an interface of all the animations in the game.
 */
public interface Animation {
    /**
     * a method that draws on the drawsurface and checks if a key is pressed.
     *
     * @param d - the drawsurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * checks if the animation should stop.
     *
     * @return wether the animation should stop.
     */
    boolean shouldStop();

    /**
     * checks if the animation should close.
     *
     * @return wether the animation should close.
     */
    boolean shouldClose();

    /**
     * checks if the animation is finished.
     *
     * @return wether the animation is finished.
     */
    boolean isFinished();
}