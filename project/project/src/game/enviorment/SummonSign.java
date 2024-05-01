package game.enviorment;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.SpawnAction;
import game.action.TravelAction;
import game.utils.Status;

/**
 * A class that represents summon sign.
 * Created by:
 * @author Liew Dong Xun
 * Modified by:
 * @see Ground
 */
public class SummonSign extends Ground {

    /**
     * Constructor.
     *
     */
    public SummonSign() {
        super('=');
    }

    /**
     * only player are allowed to enter summon
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
        action.add(new SpawnAction());
        return action;

    }

}
