package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A class that is used to despawn actor on the map.
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see Action
 */
public class DespawnAction extends Action {
    /**
     * the actor attribute
     */
    private Actor actor;
    /**
     * constructor 
     * @param actor actor being despawned
     */
    public DespawnAction(Actor actor){
        this.actor = actor;
    }   
    /**
     * when executed actor is removed from the map 
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string that shows which actor is being despawned
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        map.removeActor(actor);

        return menuDescription(actor);
    }
    /**
     * menu description of the action
     * @param actor The actor performing the action.
     * @return a string that shows which actor is being despawned
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is being despawn from the map.";
    }
}
