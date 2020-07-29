import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * a class of the WideEasyLevel.
 */

public class WideEasyLevel implements LevelInformation {
    /**
     * the number of balls.
     *
     * @return the number of balls.
     */
    public int numberOfBalls() {
        return 10;
    }

    /**
     * The initial velocity of each ball.
     *
     * @return a list of velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(new Velocity(5, 7));
        }
        return velocities;
    }

    /**
     * sets the paddle speed.
     *
     * @return the paddle speed.
     */
    public int paddleSpeed() {
        return 5;
    }

    /**
     * sets the paddle width.
     *
     * @return the paddle width.
     */
    public int paddleWidth() {
        return 800;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        WiseEasyLevelBG wiseEasyLevelBG = new WiseEasyLevelBG();
        return wiseEasyLevelBG;
    }

    /**
     * The Blocks that make up this level, each block contains.
     * its size, color and location.
     *
     * @return a block list.
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color color = Color.red;
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            switch (i) {
                case 0:
                    color = Color.MAGENTA;
                    break;
                case 1:
                    color = Color.MAGENTA;
                    break;
                case 2:
                    color = Color.RED;
                    break;
                case 3:
                    color = Color.RED;
                    break;
                case 4:
                    color = Color.ORANGE;
                    break;
                case 5:
                    color = Color.ORANGE;
                    break;
                case 6:
                    color = Color.YELLOW;
                    break;
                case 7:
                    color = Color.YELLOW;
                    break;
                case 8:
                    color = Color.GREEN;
                    break;
                case 9:
                    color = Color.GREEN;
                    break;
                case 10:
                    color = Color.BLUE;
                    break;
                case 11:
                    color = Color.BLUE;
                    break;
                case 12:
                    color = Color.PINK;
                    break;
                case 13:
                    color = Color.PINK;
                    break;
                case 14:
                    color = Color.CYAN;
                    break;
                case 15:
                    color = Color.CYAN;
                    break;
                default:
                    color = color;
                    break;
            }
            blocks.add(new Block(new Rectangle(new Point(32 + i * 71, 350), 71, 30), 1, color));
        }
        return blocks;

    }

    /**
     * Number of levels that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the number of blocks.
     */
    public int numberOfBlocksToRemove() {
        return 16;
    }
}
