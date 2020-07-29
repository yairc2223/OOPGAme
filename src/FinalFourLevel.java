import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * a class of the FinalFourLevel.
 */
public class FinalFourLevel implements LevelInformation {
    /**
     * the number of balls.
     *
     * @return the number of balls.
     */
    public int numberOfBalls() {
        return 30;
    }

    /**
     * The initial velocity of each ball.
     *
     * @return a list of velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(new Velocity(10, 11));
        }
        return velocities;
    }

    /**
     * sets the paddle speed.
     *
     * @return the paddle speed.
     */
    public int paddleSpeed() {
        return 10;
    }

    /**
     * sets the paddle width.
     *
     * @return the paddle width.
     */
    public int paddleWidth() {
        return 400;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    public String levelName() {
        return "Final Four";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        FinalFourLevelBG finalFourLevelBG = new FinalFourLevelBG();
        return finalFourLevelBG;
    }

    /**
     * Number of levels that should be removed
     * before the level is considered to be "cleared".
     *
     * @return the number of blocks.
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color color = Color.red;
        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    color = Color.GRAY;
                    break;
                case 1:
                    color = Color.RED;
                    break;
                case 2:
                    color = Color.YELLOW;
                    break;
                case 3:
                    color = Color.GREEN;
                    break;
                case 4:
                    color = Color.WHITE;
                    break;
                case 5:
                    color = Color.PINK;
                    break;
                case 6:
                    color = Color.CYAN;
                    break;
                default:
                    color = color.brighter();
                    break;
            }
            for (int j = 0; j < 16; j++) {
                blocks.add(new Block(new Rectangle(new Point(1097 - 71 * j, 150 + 30 * i), 71, 30), 1, color));
            }

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
        return 16 * 7;
    }
}
