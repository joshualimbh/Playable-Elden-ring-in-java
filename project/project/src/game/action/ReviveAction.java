package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that is responsible foe reviving the actor from unconscious state.
 *
 * @author Lim Jun Yi
 * @see Action
 */
public class ReviveAction extends Action {
    /**
     * previous actor
     */
    private final Actor previous;
    /**
     * constructor
     * @param actor actor being revived
     */
    public ReviveAction(Actor actor){
        this.previous = actor;
    }
    /**
     * when executed the actor will be revived at its previous location on the map
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string that shows which actor is being revived
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        Location previousSpawn = map.locationOf(actor);
        map.removeActor(actor);
        map.addActor(previous, previousSpawn);
        return menuDescription(actor);
    }
    /**
     * menu description of the action
     * @param actor The actor performing the action.
     * @return a string that shows which actor is being revived
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " has been revived into " + previous + ".";
    }
}
