package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AreaAttackAction;

/**
 * A Weapon carried by Skeletal Bandits.
 * It is the starter weapon for the class Bandit.
 * It deals 118 damage with 88% hit rate.
 * Created by:
 * @author Joshua Lim Boon Hor
 * Modified by:
 * @see WeaponItem
 */
public class Scimitar extends WeaponItem{
    /**
     * Constructor
     */
    public Scimitar(){
        super("Scimitar", 's', 118, "stabs", 88);
    }

    /**
     * Special skill that the weapon can perform
     * @param target The target of the actor
     * @param direction The direction of the actor
     * @return new AreaAttackAction
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }
}
