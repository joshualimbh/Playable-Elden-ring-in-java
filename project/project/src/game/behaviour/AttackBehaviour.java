package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AttackAction;
import game.utils.Status;

import java.util.List;
/**
 * A class that allows actor to attack.
 * Created by: 
 * @author Liew Dong Xun
 * @see Behaviour
 */
public class AttackBehaviour implements Behaviour {
    /**
     * target actor to attack
     * 
     */
    private Actor target;
    /**
     * empty constructor
     */
    public AttackBehaviour() {
    }
    /**
     * getAction will return a new attack action where plausible
     * @param actor actor attacking
     * @param map location of actor on the map
     * @return attack action or null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);      // get current location of actor

        if (!actor.hasCapability(Status.FRIENDLY)){
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();

                if (destination.containsAnActor()) {
                    target = destination.getActor();
                    if (actor.capabilitiesList().equals(target.capabilitiesList())) {
                        return null;
                    }
                    if (actor.getWeaponInventory().size() == 0) {
                        return new AttackAction(target, exit.getName());
                    }else {
                        List<WeaponItem> inv = actor.getWeaponInventory();
                        Weapon weapon = inv.get(0);
                        return new AttackAction(target, exit.getName(),weapon);
                    }
                }
            }
        }else{
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();

                if (destination.containsAnActor()) {
                    target = destination.getActor();

                    if(target.hasCapability(Status.HOSTILE_TO_ENEMY) && actor.hasCapability(Status.FRIENDLY)){
                        return null;
                    }
                    if (actor.getWeaponInventory().size() == 0) {
                        return new AttackAction(target, exit.getName());
                    }else {
                        List<WeaponItem> inv = actor.getWeaponInventory();
                        Weapon weapon = inv.get(0);
                        return new AttackAction(target, exit.getName(), weapon);
                    }
                }
            }
        }

        return null;
    }
}
