package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AreaAttackAction;
/**
 * A weapon that can be used to attack the enemy.
 * It deals 208 damage with 90% hit rate
 * Created by:
 * @Author Lim Jun Yi
 * @see WeaponItem
 */
public class GiantCrabPincer extends WeaponItem {
    /**
     * Constructor
     */
    public GiantCrabPincer() {
        super("Giant Crab Pincer", '-', 208, "slams", 90);
        this.togglePortability();
    }

    /**
     * Special skill that the weapon can perform
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }
}
