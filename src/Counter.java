/**
 * a class that behaves like a counter for our game.
 */
public class Counter {

    private int counter;

    /**
     * a constructor to Count.
     *
     * @param count the count value.
     */
    public Counter(int count) {
        this.counter = count;
    }

    /**
     * a method that increases the value by a given a number.
     *
     * @param number - a given number to increase by.
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * a method that subtracts the value by a given a number.
     *
     * @param number - a given number to subtract by.
     */
    public void decrease(int number) {
        this.counter -= number;
    }


    /**
     * gets a current count.
     *
     * @return the current value of the count.
     */
    public int getValue() {
        return this.counter;
    }
}