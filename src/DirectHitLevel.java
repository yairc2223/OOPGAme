

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * a class of the direct hit level.
 */
public class DirectHitLevel implements LevelInformation {
    /**
     * the number of balls.
     *
     * @return the number of balls.
     */

    public int numberOfBalls() {
        return 1;
    }

    /**
     * The initial velocity of each ball.
     *
     * @return a list of velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(3, -2));
        return velocities;
    }

    /**
     * sets the paddle speed.
     *
     * @return the paddle speed.
     */

    public int paddleSpeed() {
        return 12;
    }

    /**
     * sets the paddle width.
     *
     * @return the paddle width.
     */
    public int paddleWidth() {
        return 80;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        DirectHitLevelBG directHitLevelBG = new DirectHitLevelBG();
        return directHitLevelBG;
    }

    /**
     * The Blocks that make up this level, each block contains.
     * its size, color and location.
     *
     * @return a block list.
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(600 - 25, 300 - 25), 50, 50), 1, Color.red));
        return blocks;

    }

    /**
     * Number of levels that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the number of blocks.
     */
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
