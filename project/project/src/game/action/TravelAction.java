package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * An action that allows an actor to travel to other maps.
 * @author Liew Dong Xun
 * @see Action
 */
public class TravelAction extends Action {

    private String name;
    private Location location;

    /**
     * Constructor of TravelAction class
     * @param name Name of intended travel map
     * @param location location to move actor to
     */
    public TravelAction(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    /**
     * When executed, the actor will be moved to the intended location.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string that shows the result of the action
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.moveActor(actor, this.location);
        return actor.toString() + " travelled to " + this.name;
    }

    /**
     * Returns a string to be showed in the menu for the action.
     * @param actor The actor performing the action.
     * @return a string that shows the description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " travels to " + this.name;
    }
}
