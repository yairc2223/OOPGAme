/**
 * an interface of hit notifier.
 */
public interface HitNotifier {


    /**
     * Adds hl as a listener to hit events.
     *
     * @param hl - a hitlistener to add.
     */
    void addHitListener(HitListener hl);


    /**
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl - hitlistener to remove.
     */
    void removeHitListener(HitListener hl);
}
