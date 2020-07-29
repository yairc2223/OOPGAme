import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Cohen
 */
public class Ass6Game {
    /**
     * The main method that runs the Arkanoid game.
     *
     * @param args the parameters to the main.
     */
    public static void main(String[] args) {
        List<LevelInformation> levelInformations = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                levelInformations.add(new DirectHitLevel());
            }
            if (args[i].equals("2")) {
                levelInformations.add(new WideEasyLevel());
            }
            if (args[i].equals("3")) {
                levelInformations.add(new Green3Level());
            }
            if (args[i].equals("4")) {
                levelInformations.add(new FinalFourLevel());
            }
        }

        GUI gui = new GUI("Arkanoid", 1200, 800);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        AnimationRunner animationRunner = new AnimationRunner(gui);
        GameFlow gameFlow = new GameFlow(animationRunner, keyboard);
        gameFlow.runLevels(levelInformations);
        gui.close();
    }
}

