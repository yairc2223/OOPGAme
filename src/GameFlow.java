import biuoop.KeyboardSensor;

import java.util.List;

/**
 * a class that is responsible for running all the levels.
 */
public class GameFlow {

    private biuoop.KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private int numoflives = 1;
    private int score = 0;
    private Counter numlevels;

    /**
     * a constructor to game flow.
     *
     * @param ar the animationrunner.
     * @param ks the keyboard sensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
    }

    /**
     * a method that runs the levels.
     *
     * @param levels the levels list.
     */
    public void runLevels(List<LevelInformation> levels) {
        this.numlevels = new Counter(levels.size());
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor,
                    this.animationRunner, numoflives, score);
            level.initialize();
            while (!(level.isFinished()) && (!level.shouldClose())) {
                level.playOneTurn();
            }
            if (level.isFinished()) {
                this.numlevels.decrease(1);
                numoflives = level.getLivesIndicator().getLives().getValue();
                score = level.getScoreIndicator().getScore().getValue();
                if (this.numlevels.getValue() == 0) {
                    this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                            KeyboardSensor.SPACE_KEY, new EndScreen(this.keyboardSensor, true, score)));
                }
                continue;
            }
            if (level.shouldClose()) {
                break;
            }

        }
    }

}
