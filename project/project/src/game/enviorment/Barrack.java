package game.enviorment;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemy.stormveil.GodrickSoldier;
import game.utils.RandomNumberGenerator;

/**
 * A class that represents Barrack.
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see Ground
 */
public class Barrack extends Ground {

    /**
     * Constructor.
     *
     */
    public Barrack() {
        super('B');
    }

    /**
     * Barrack can also experience the joy of time.
     * @param location The location of the Ground
     */
    public void tick(Location location) {
        if (RandomNumberGenerator.getRandomInt(1, 100) <= 45 && !location.containsAnActor()) {
            // spawn Godrick Soldiers
            location.addActor(new GodrickSoldier());
        }
    }
}
