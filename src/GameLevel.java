import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Cohen
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter counterblocks;
    private Counter counterballs;
    private ScoreIndicator scoreIndicator;
    private LivesIndicator livesIndicator;
    private AnimationRunner runner;
    private Boolean running;
    private Boolean close;
    private Boolean levelfinished;
    private Paddle paddle;
    private biuoop.KeyboardSensor keyboard;
    private List<Velocity> velocities;
    private List<Block> blocks;
    private LevelName levelName;
    private Sprite bacgground;

    /**
     * a constructor to GameLevel that gets level.
     *
     * @param levelInformation the level information.
     * @param keyboardSensor   a keyboard sensor.
     * @param animationRunner  the object that runs the animations in game.
     * @param lives            - counter to number of lives.
     * @param score            counter to score.
     */
    public GameLevel(LevelInformation levelInformation, biuoop.KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, int lives, int score) {
        this.counterballs = new Counter(levelInformation.numberOfBalls());
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.counterblocks = new Counter(levelInformation.numberOfBlocksToRemove());
        this.counterballs = new Counter(0);
        this.scoreIndicator = new ScoreIndicator(new Rectangle(new Point(0, 0),
                1200, 30), new Counter(score), Color.GREEN);
        this.livesIndicator = new LivesIndicator(new Rectangle(new Point(0, 0),
                70, 30), new Counter(lives));
        this.running = true;
        this.runner = animationRunner;
        this.paddle = new Paddle(runner.getGui(), new Rectangle(new Point(300, 760),
                levelInformation.paddleWidth(), 10), levelInformation.paddleSpeed());
        this.keyboard = keyboardSensor;
        this.close = false;
        this.blocks = levelInformation.blocks();
        this.velocities = levelInformation.initialBallVelocities();
        this.levelName = new LevelName(levelInformation.levelName());
        this.bacgground = levelInformation.getBackground();
        this.levelfinished = false;

    }

    /**
     * adds the object to collidables.
     *
     * @param c the objet that is collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adds the object to sprites.
     *
     * @param s the objet that is sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle).
     * and adds them to the game.
     */
    public void initialize() {
        this.bacgground.addToGame(this);
        initializeborders();
        initializeBlocks();
        this.scoreIndicator.addToGame(this);
        this.livesIndicator.addToGame(this);
        this.levelName.addToGame(this);
    }

    /**
     * a method that creates the blocks according to level information.
     */
    public void initializeBlocks() {
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.scoreIndicator.getScore());
        LivesTrackingListener livesTrackingListener = new LivesTrackingListener(this.livesIndicator.getLives());
        BlockRemover blockRemover = new BlockRemover(this, this.counterblocks);
        List<Block> blocksl = this.blocks;
        for (Block block : blocksl) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
        }
    }

    /**
     * the method initializes the borders of the screen.
     */
    public void initializeborders() {
        BallRemover ballremover = new BallRemover(this, this.counterballs);
        Block border1 = new Block(new Rectangle(new Point(0, 0), 1200, 50),
                1, Color.GRAY);
        Block border2 = new Block(new Rectangle(new Point(0, 30), 30, 740),
                1, Color.GRAY);
        Block border3 = new Block(new Rectangle(new Point(0, 770), 1200, 30),
                1, Color.GRAY);
        Block border4 = new Block(new Rectangle(new Point(1170, 30), 30, 740),
                1, Color.GRAY);
        border1.addToGame(this);
        border2.addToGame(this);
        border3.addToGame(this);
        border3.addHitListener(ballremover);
        border4.addToGame(this);

    }


    /**
     * playOneTurn runs the game -- start the animation loop.
     */
    public void playOneTurn() {
        //this.createballsonpaddle();
        //this.running = true;
        this.initalizeBallPaddle();
        this.runner.getGui().getDrawSurface().setColor(Color.CYAN);
        this.runner.run(new CountdownAnimation(2.0, 3, this.sprites));
        this.runner.run(this);

    }

    /**
     * a method that removes a collidable from the collidables list.
     *
     * @param c - the given collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidables().remove(c);
    }

    /**
     * a method that removes a sprites from the sprites list.
     *
     * @param s - the given sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.getList().remove(s);
    }


    /**
     * getter to the scoreindicator.
     *
     * @return the scoreindicator.
     */
    public ScoreIndicator getScoreIndicator() {
        return this.scoreIndicator;
    }

    /**
     * getter to the livesindicator.
     *
     * @return the livesindicator.
     */
    public LivesIndicator getLivesIndicator() {
        return this.livesIndicator;
    }

    /**
     * a method that draws on the drawsurface and checks if a key is pressed.
     *
     * @param d - the drawsurface.
     */
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.counterballs.getValue() == 0) {
            if ((this.livesIndicator.getLives().getValue() <= 0)) {
                this.close = true;
            }
            if (this.livesIndicator.getLives().getValue() > 0) {
                this.livesIndicator.getLives().decrease(1);
                paddle.removeFromGame(this);
                initalizeBallPaddle();
            }
        }
        if (this.counterblocks.getValue() == 0) {
            this.scoreIndicator.getScore().increase(100);
            this.levelfinished = true;
        }


        if (keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen()));
        }
    }

    /**
     * checks if the animation should stop.
     *
     * @return wether the animation should stop.
     */
    public boolean shouldStop() {
        return !this.running;

    }

    /**
     * checks if the animation is finished.
     *
     * @return wether the animation is finished.
     */
    public boolean isFinished() {
        return this.levelfinished;
    }

    /**
     * checks if the animation should close.
     *
     * @return wether the animation should close.
     */
    public boolean shouldClose() {
        if (this.close) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new EndScreen(this.keyboard, false, this.scoreIndicator.getScore().getValue())));
        }
        return this.close;
    }

    /**
     * a method that creates the balls and paddle.
     */
    public void initalizeBallPaddle() {
        this.paddle.addToGame(this);
        Ball ball;
        List<Ball> ballList = new ArrayList<>();
        List<Velocity> velocitiesarr = this.velocities;
        int x = 150;
        for (Velocity velocity : velocitiesarr) {
            ball = new Ball(x, 600, 10, Color.BLUE, this.environment);
            ball.setVelocity(velocity);
            ball.addToGame(this);
            this.counterballs.increase(1);
            x = x + 100;
        }
    }

    /**
     * a method that create the blocks.
     */
    public void initializeBlocksFirst() {
        int i = 0;
        int firstrow = 19;
        int secondrow = 18;
        int thirdrow = 17;
        int fourthrow = 16;
        int fifthrow = 15;
        PrintingHitListener printingHitListener = new PrintingHitListener();
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.scoreIndicator.getScore());
        LivesTrackingListener livesTrackingListener = new LivesTrackingListener(this.livesIndicator.getLives());
        BlockRemover blockRemover = new BlockRemover(this, this.counterblocks);
        Block[] blocksFirstLine = new Block[firstrow];
        for (i = 0; i < firstrow; i++) {
            blocksFirstLine[i] = new Block(new Rectangle(new Point((220 + 50 * i), 100), 50, 30), 2, Color.cyan);
            blocksFirstLine[i].addToGame(this);
            blocksFirstLine[i].addHitListener(printingHitListener);
            blocksFirstLine[i].addHitListener(blockRemover);
        }
        Block[] blocksSecondLine = new Block[secondrow];
        for (i = 0; i < secondrow; i++) {
            blocksSecondLine[i] = new Block(new Rectangle(new Point((270 + 50 * i),
                    130), 50, 30), 1, Color.BLUE);
            blocksSecondLine[i].addToGame(this);
            blocksSecondLine[i].addHitListener(printingHitListener);
            blocksSecondLine[i].addHitListener(blockRemover);
        }
        Block[] blocksThirdLine = new Block[thirdrow];
        for (i = 0; i < thirdrow; i++) {
            blocksThirdLine[i] = new Block(new Rectangle(new Point((320 + 50 * i),
                    160), 50, 30), 1, Color.YELLOW);
            blocksThirdLine[i].addToGame(this);
            blocksThirdLine[i].addHitListener(printingHitListener);
            blocksThirdLine[i].addHitListener(blockRemover);
        }
        Block[] blocksFourthLine = new Block[fourthrow];
        for (i = 0; i < fourthrow; i++) {
            blocksFourthLine[i] = new Block(new Rectangle(new Point((370 + 50 * i),
                    190), 50, 30), 1, Color.GREEN.brighter());
            blocksFourthLine[i].addToGame(this);
            blocksFourthLine[i].addHitListener(blockRemover);

        }
        Block[] blocksFifthhLine = new Block[fifthrow];
        for (i = 0; i < fifthrow; i++) {
            blocksFifthhLine[i] = new Block(new Rectangle(new Point((420 + 50 * i), 220),
                    50, 30), 1, Color.MAGENTA.brighter());
            blocksFifthhLine[i].addToGame(this);
            blocksFifthhLine[i].addHitListener(printingHitListener);
            blocksFifthhLine[i].addHitListener(blockRemover);
        }
        this.counterblocks.increase(85);

    }

    /**
     * an accesor method to number of blocks.
     *
     * @return the counter of blocks.
     */
    public Counter getCounterblocks() {
        return counterblocks;
    }

    /**
     * an accesor method to number of balls.
     *
     * @return the counter of balls.
     */
    public Counter getCounterballs() {
        return counterballs;
    }


}