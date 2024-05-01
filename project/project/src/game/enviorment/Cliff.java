package game.enviorment;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.utils.Status;

/**
 * A class that represents Cage.
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see Ground
 */
public class Cliff extends Ground {

    /**
     * Constructor.
     *
     */
    public Cliff() {
        super('+');
    }

    /**
     * only player are allowed to enter cliff
     * @param actor The actor that will enter the Ground
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }
}
