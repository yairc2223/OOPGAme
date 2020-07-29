/**
 * a clss that is responsible for removing a ball.
 * holds fields of gameLevel and a counter of remaining balls.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * a constructor to BallRemover.
     *
     * @param gameLevel    - the given gameLevel.
     * @param removedBalls - counter of the remaining balls.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }


    /**
     * if a ball touch the ground it is being removed.
     *
     * @param beingHit - the block that is being hit.
     * @param hitter   - the ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}


