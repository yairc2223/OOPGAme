

/**
 * a clss that is responsible for removing blocks.
 * holds fields of gameLevel and a counter of remaining blocks.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * a constructor to BlockRemover.
     *
     * @param gameLevel     - the given gameLevel.
     * @param removedBlocks - counter of the remaining balls.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }


    /**
     * Blocks that are hit and reach 0 hit-points should be removed.
     * from the gameLevel. Remember to remove this listener from the block.
     * that is being removed from the gameLevel.
     *
     * @param beingHit - the block that is being hit.
     * @param hitter   the ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.gameLevel.getScoreIndicator().getScore().increase(5);
        hitter.setColor(beingHit.getColor());
        if (beingHit.getNumhits() == 0) {
            beingHit.removeFromGame(this.gameLevel);
            this.remainingBlocks.decrease(1);
            this.gameLevel.getScoreIndicator().getScore().increase(10);
        }
        this.gameLevel.getScoreIndicator().getScore().increase(5);
    }
}

