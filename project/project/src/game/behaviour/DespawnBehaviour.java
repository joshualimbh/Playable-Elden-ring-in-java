package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.DespawnAction;
import game.utils.RandomNumberGenerator;

/**
 * A class that despawn NPCs.
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see Behaviour
 */
public class DespawnBehaviour implements Behaviour {
    /**
     * get action to despawn actor
     * @param actor The actor getting despawned
     * @param map The map the actor is on.
     * @return an action to despawn actor or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (RandomNumberGenerator.getRandomInt(1, 100) <= 10){
            return new DespawnAction(actor);
        }
        return null;
    }
}
