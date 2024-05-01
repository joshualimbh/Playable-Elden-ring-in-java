package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.AreaAttackAction;
import game.action.AttackAction;
import game.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Random;

/**
 * a class that find whether there is a target actor around the actor to trigger an AOE attack.
 *
 * @author Lim Jun Yi
 * @see Behaviour
 */

public class AreaAttackBehaviour implements Behaviour {

    private Actor target; // target actor to attack
    /**
     * get action function that return an action to be executed.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return an action to be executed
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location here = map.locationOf(actor);

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                target = destination.getActor();

                if (RandomNumberGenerator.getRandomInt(1, 100) <= 50 && !actor.capabilitiesList().equals(target.capabilitiesList())){
                    return new AreaAttackAction();
                }

                return null;
            }
        }
        return null;
    }
}
