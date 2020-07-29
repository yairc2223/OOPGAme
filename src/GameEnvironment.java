
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Cohen
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * creates the game environment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c the given collidable.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);

    }

    /**
     * sets the list of collidables.
     *
     * @param carr - the list of collidables.
     */
    public void setCollidables(List<Collidable> carr) {
        this.collidables = carr;
    }

    /**
     * gets the list of collidables.
     *
     * @return the list of collidables.
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }

    /**
     * Assume an object moving from line.start() to line.end().
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the line thar represents the move vector of the ball.
     * @return the collision info that includes point and the object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //Point closetPoint=null;
        Collidable c = null;
        Point minPoint = null;
        double min = Double.MAX_VALUE;
        for (Collidable temp : collidables) {
            Point p = trajectory.closestIntersectionToStartOfLine(temp.getCollisionRectangle());
            if (p == null) {
                continue;
            }
            if (trajectory.start().distance(p) < min) {
                min = trajectory.start().distance(p);
                c = temp;
                minPoint = p;
            }
        }
        if (c == null) {
            return null;
        }
        return new CollisionInfo(minPoint, c);
    }

}