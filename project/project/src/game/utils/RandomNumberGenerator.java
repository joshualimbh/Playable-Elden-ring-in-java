package game.utils;

import java.util.Random;

/**
 * A random number generator
 * Created by:
 * @author Adrian Kristanto
 * Modified by: 
 *
 */
public class RandomNumberGenerator {
    /**
     * returns a random number within a number starting from 0 to bound
     * @param bound the upper bound
     * @return a random number
     */
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }
    /**
     * returns a random number within a lower bound and upper bound
     * @param lowerBound the lower bound
     * @param upperBound the upper bound
     * @return a random number
     */
    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
}
