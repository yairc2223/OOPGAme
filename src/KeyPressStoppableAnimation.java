/**
 * this class is responsible for all the key presses animations.
 */

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class is responsible for all the key presses animations.
 */

public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String keypressed;
    private Animation animation;
    private boolean stop;
    private boolean close;
    private boolean isAlreadyPressed = false;

    /**
     * this is a constructor to KeyStoppableAnimation.
     *
     * @param keyboardSensor - the key bord sensors.
     * @param s              - a string of the key.
     * @param animation      - the animation tht runs.
     */
    public KeyPressStoppableAnimation(KeyboardSensor keyboardSensor, String s, Animation animation) {
        this.keyboardSensor = keyboardSensor;
        this.keypressed = s;
        this.animation = animation;
        this.stop = false;
        this.close = false;
    }

    /**
     * a method that draws on the drawsurface and checks if a key is pressed.
     *
     * @param d - the drawsurface.
     */
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(this.keypressed) && (!isAlreadyPressed)) {
            this.stop = true;
            this.close = true;
            isAlreadyPressed = true;
        }
    }

    /**
     * checks if the animation should stop.
     *
     * @return wether the animation should stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * checks if the animation should close.
     *
     * @return wether the animation should close.
     */
    public boolean shouldClose() {
        return this.close;
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
