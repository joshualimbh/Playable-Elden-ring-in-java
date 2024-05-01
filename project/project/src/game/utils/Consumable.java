package game.utils;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * A consumable interface.
 * @author Liew Dong Xun
 */
public interface Consumable {
    /**
     * consume function
     */
    void consume();
    /**
     * to get the number of max uses
     * @return an integer amount of max uses
     */
    int getMaxUse();
    /**
     * to get uses left
     * @return an integer amount of uses left
     */
    int getUsesLeft();
}
