package game.enemy.undeadtype;

import game.enemy.Enemy;
import game.weapon.Grossmesser;
import game.behaviour.*;
import game.utils.EnemiesType;
import game.utils.ResetManager;

import java.util.Map;
import java.util.TreeMap;

/**
 * Heavy Skeletal Swordsman class, a type of enemy.
 * Heavy Skeletal Swordsman is displayed as 'q' in the map.
 * Heavy Skeletal Swordsman has 153 hp.
 * Heavy Skeletal Swordsman is an undead type enemy.
 * Heavy Skeletal Swordsman has a Grossmesser as its weapon.
 * Heavy Skeletal Swordsman has an Area Attack Behaviour.
 * Heavy Skeletal Swordsman is resettable.
 * Created by:
 * @author
 * Modified by: Lim Jun Yi
 * @see Enemy
 */
public class HeavySkeletalSwordsman extends Enemy {
    /**
     * A map of behaviours for Heavy Skeletal Swordsman.
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * Constructor for HeavySkeletalSwordsman.
     */
    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.addCapability(EnemiesType.IS_UNDEAD_TYPE);
        this.addWeaponToInventory(new Grossmesser());
        this.behaviours.put(1, new AreaAttackBehaviour());
        ResetManager.getInstance().registerResettable(this);
    }


}
