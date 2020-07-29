/**
 * The class that listens to the livesindicator in the game.
 */
public class LivesTrackingListener implements HitListener {
    private Counter numlives;

    /**
     * a constructor to LivesTrackingListener.
     *
     * @param scoreCounter the core of the game.
     */
    public LivesTrackingListener(Counter scoreCounter) {
        this.numlives = scoreCounter;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit - the block that is being hit.
     * @param hitter   -  The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.numlives.decrease(1);
    }
}
