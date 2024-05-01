package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.ReviveAction;
import game.utils.Status;

/**
 * A class that check if an NPC has RESPAWNABLE capability and respawn the NPC into its previous state.
 *
 * @author Lim Jun Yi
 */
public class ReviveBehaviour implements Behaviour{
    /**
     * previous actor
     */
    private final Actor PREVIOUS;
    /**
     * constructor
     * @param actor actor being revived
     */
    public ReviveBehaviour(Actor actor) {
        this.PREVIOUS = actor;
    }
    /**
     * get action to revive actor
     * @param actor The actor getting revived
     * @param map The map the actor is on.
     * @return an action to revive actor or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.RESPAWNABLE)) {
            return new ReviveAction(this.PREVIOUS);
        }
        return null;
    }
}
