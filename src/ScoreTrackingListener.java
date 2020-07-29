/**
 * a class of the score of the game, holds the score.
 * implements HitListener.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * a constuctor to ScoreCounter.
     *
     * @param scoreCounter - the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit - the block that is being hit.
     * @param hitter   -  The hitter parameter is the Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);

    }
}