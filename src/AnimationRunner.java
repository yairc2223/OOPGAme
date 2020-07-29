/**
 * a class that responible for running the loop animation.
 */

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * a class that responible for running the loop animation.
 */

public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * a constructor to Animation runner.
     *
     * @param gui the gui screen.
     */
    public AnimationRunner(GUI gui) {
        this.framesPerSecond = 60;
        this.gui = gui;
        this.sleeper = new Sleeper();
    }

    /**
     * a method that runs the animation loop.
     *
     * @param animation the given animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
           if (animation.shouldClose()) {
               this.gui.close();
           }

            if (animation.isFinished()) {
                break;
            }
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * getter to the GUI.
     *
     * @return the gui.
     */
    public GUI getGui() {
        return this.gui;
    }
}