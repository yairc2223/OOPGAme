/**
 * a class that tests if there is a hit.
 */
public class PrintingHitListener implements HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit - the block that is being hit.
     * @param hitter   -  The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block with " + beingHit.getNumhits() + " points was hit.");
    }
}

