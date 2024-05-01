package game.enviorment;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.TravelAction;
import game.utils.Status;

/**
 * A ground that allows player to travel between maps, like a portal.
 * @author Liew Dong Xun
 */
public class GoldenFogDoor extends Ground {

    private String linkedName;
    private Location linkedLocation;

    /**
     * Constructor for the GoldenFogDoor class
     * @param linkedName the name of the map where this ground is linked to
     * @param linkedLocation the location of the map where this ground is linked to
     */
    public GoldenFogDoor(String linkedName, Location linkedLocation) {
        super('D');
        this.linkedLocation = linkedLocation;
        this.linkedName = linkedName;
    }

    /**
     * Floor cannot be entered by enemies
     * @param actor The actor that will enter the Ground
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
    }

    /**
     * A list of allowable actions that a player can do, when standing on this ground.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return the list of actions that can be done
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList action = new ActionList();
        action.add(new TravelAction(this.linkedName, this.linkedLocation));
        return action;

    }
}
