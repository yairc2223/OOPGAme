import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yair Cohen
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * create the list of sprites.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * add the given sprites to the list.
     *
     * @param s the given sprite to add.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);

    }

    /**
     * gets the list of sprites.
     *
     * @return the list of sprites.
     */
    public List<Sprite> getList() {
        return this.sprites;
    }

    /**
     * sets the list of sprites.
     *
     * @param spriteslist - the list of sprites.
     */
    public void setList(List<Sprite> spriteslist) {
        this.sprites = spriteslist;
    }


    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesarr = new ArrayList<Sprite>(this.sprites);
        for (Sprite sprite : spritesarr) {
            sprite.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the give draw surface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        //List<Sprite> spritesarr = new ArrayList<Sprite>(this.sprites);
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}
