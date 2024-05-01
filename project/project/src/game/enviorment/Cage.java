package game.enviorment;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemy.stormveil.Dog;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents Cage.
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see Ground
 */
public class Cage extends Ground {

    /**
     * Constructor.
     *
     */
    public Cage() {
        super('<');
    }

    /**
     * Cage can also experience the joy of time.
     * @param location The location of the Ground
     */
    public void tick(Location location) {
        if (RandomNumberGenerator.getRandomInt(1, 100) <= 37 && !location.containsAnActor()) {
            // spawn dog
            location.addActor(new Dog());
        }
    }
}
