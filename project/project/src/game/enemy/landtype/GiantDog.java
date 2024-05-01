package game.enemy.landtype;

import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.weapon.GiantDogHead;
import game.behaviour.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * Giant Dog class, a type of enemy.
 * Giant Dog is displayed as 'G' in the map.
 * Giant Dog has 693 hp.
 * Giant Dog is a land type enemy.
 * Giant Dog has a Giant Dog Head as its weapon.
 * Giant Dog has an Area Attack Behaviour.
 * Giant Dog is resettable.
 * Created by:
 * @author
 * Modified by: Lim Jun Yi
 * @see Enemy
 */
public class GiantDog extends Enemy {
    /**
     * A map of behaviours for Giant Dog.
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * Constructor for GiantDog.
     */
    public GiantDog() {
        super("Giant Dog", 'G', 693);
        this.addCapability(EnemiesType.IS_LAND_TYPE);        // set type of enemy, so same type cannot attack each other
        this.addWeaponToInventory(new GiantDogHead());
        this.behaviours.put(1, new AreaAttackBehaviour());
        ResetManager.getInstance().registerResettable(this);
    }

}