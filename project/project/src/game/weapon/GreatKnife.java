package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.QuickStepAction;
/**
 * A Weapon that can be used to attack the enemy.
 * It is the starter weapon for the class Bandit.
 * It deals 75 damage with 70% hit rate.
 * Created by:
 * @author Joshua Lim Boon Hor
 * Modified by:
 * @see WeaponItem
 */
public class GreatKnife extends WeaponItem {
    /**
     * Constructor
     */
    public GreatKnife() {
        super("Great Knife", '/', 75 , "stabs", 70);
    }

    /**
     * Special skill that the weapon can perform
     * @param target The target of the actor
     * @param direction The direction of the actor
     * @return new QuickStepAction
     * @see QuickStepAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickStepAction(target, direction, this);
    }
}

