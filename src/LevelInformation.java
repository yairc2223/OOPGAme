import java.util.List;

/**
 * an iterface of levels information.
 */
public interface LevelInformation {
    /**
     * the number of balls.
     *
     * @return the number of balls.
     */
    int numberOfBalls();

    /**
     * The initial velocity of each ball.
     *
     * @return a list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * sets the paddle speed.
     *
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * sets the paddle width.
     *
     * @return the paddle width.
     */
    int paddleWidth();


    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    String levelName();


    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * The Blocks that make up this level, each block contains.
     * its size, color and location.
     *
     * @return a block list.
     */
    List<Block> blocks();

    /**
     * Number of levels that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the number of blocks.
     */
    int numberOfBlocksToRemove();
}