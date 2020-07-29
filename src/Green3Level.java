import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * a class of the Green3Level.
 */
public class Green3Level implements LevelInformation {
    /**
     * the number of balls.
     *
     * @return the number of balls.
     */
    public int numberOfBalls() {
        return 2;
    }

    /**
     * The initial velocity of each ball.
     *
     * @return a list of velocities.
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(new Velocity(8, 8));
        }
        return velocities;
    }

    /**
     * sets the paddle speed.
     *
     * @return the paddle speed.
     */
    public int paddleSpeed() {
        return 15;
    }

    /**
     * sets the paddle width.
     *
     * @return the paddle width.
     */
    public int paddleWidth() {
        return 500;
    }

    /**
     * the level name will be displayed at the top of the screen.
     *
     * @return the level name.
     */
    public String levelName() {
        return "Green 3";
    }

    /**
     * Returns a sprite with the background of the level.
     *
     * @return a sprite with the background of the level.
     */
    public Sprite getBackground() {
        Green3LevelBG green3LevelBG = new Green3LevelBG();
        return green3LevelBG;
    }

    /**
     * The Blocks that make up this level, each block contains.
     * its size, color and location.
     *
     * @return a block list.
     */
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int firstrow = 12;
        int secondrow = 11;
        int thirdrow = 10;
        int fourthrow = 9;
        int fifthrow = 8;
        for (int i = 0; i < firstrow; i++) {
            blocks.add(new Block(new Rectangle(new Point(1120 - 50 * i, 270), 50, 30), 1, Color.GRAY));
        }
        for (int i = 0; i < secondrow; i++) {
            blocks.add(new Block(new Rectangle(new Point(1120 - 50 * i, 300), 50, 30), 1, Color.RED));
        }
        for (int i = 0; i < thirdrow; i++) {
            blocks.add(new Block(new Rectangle(new Point(1120 - 50 * i, 330), 50, 30), 1, Color.YELLOW));
        }
        for (int i = 0; i < fourthrow; i++) {
            blocks.add(new Block(new Rectangle(new Point(1120 - 50 * i, 360), 50, 30), 1, Color.BLUE));
        }
        for (int i = 0; i < fifthrow; i++) {
            blocks.add(new Block(new Rectangle(new Point(1120 - 50 * i, 390), 50, 30), 1, Color.WHITE));
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
        return 50;
    }
}
