/**
 * @author Yair Cohen
 */
public class CollisionInfo {
    // the point at which the collision occurs.
    private Point intresction;
    //adding the interface.
    private Collidable object;

    /**
     * puts values in the collision info.
     *
     * @param inter  the intersection point.
     * @param object the object that is involved in the ibtersection.
     */
    public CollisionInfo(Point inter, Collidable object) {
        this.object = object;
        this.intresction = inter;
    }

    /**
     * accesor to point intersection.
     *
     * @return the intesection point.
     */
    public Point getIntresction() {
        return this.intresction;
    }

    /**
     * accesor to the object.
     *
     * @return gets the object.
     */
    public Collidable getCollidable() {
        return this.object;
    }

    /**
     * gets the collision point.
     *
     * @return the point of collision.
     */
    public Point collisionPoint() {
        return this.intresction;
    }

    /**
     * the collidable object involved in the collision.
     *
     * @return the object involved.
     */
    public Collidable collisionObject() {
        return this.object;
    }
}