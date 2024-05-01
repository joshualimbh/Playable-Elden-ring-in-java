package game.enemy.undeadtype;

import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.weapon.Scimitar;
import game.behaviour.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * Skeletal Bandit class, a type of enemy.
 * Skeletal Bandit is displayed as 'b' in the map.
 * Skeletal Bandit has 184 hp.
 * Skeletal Bandit is an undead type enemy.
 * Skeletal Bandit has a Scimitar as its weapon.
 * Skeletal Bandit has an Area Attack Behaviour.
 * Skeletal Bandit is resettable.
 * Created by:
 * @author
 * Modified by: Lim Jun Yi
 * @see Enemy
 */
public class SkeletalBandit extends Enemy {
    /**
     * A map of behaviours for Skeletal Bandit.
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * Constructor for SkeletalBandit.
     */
    public SkeletalBandit() {
        super("Skeletal Bandit", 'b', 184);
        this.addCapability(EnemiesType.IS_UNDEAD_TYPE);
        this.addWeaponToInventory(new Scimitar());
        this.behaviours.put(1, new AreaAttackBehaviour());
        ResetManager.getInstance().registerResettable(this);
    }


}
