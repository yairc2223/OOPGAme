/**
 * @author Yair Cohen
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return the coliision rectangle.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with.
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     *
     * @param hitter          the ball that hits the block.
     * @param collisionPoint  the collision point.
     * @param currentVelocity the current velocity of the object.
     * @return the new velocity after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}