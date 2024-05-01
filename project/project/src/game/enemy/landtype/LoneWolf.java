package game.enemy.landtype;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AttackAction;
import game.behaviour.*;
import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.utils.Status;

import java.util.Map;
import java.util.TreeMap;

/**
 * BEHOLD, DOG!
 *
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Liew Dong Xun, Lim Jun Yi,Joshua Lim Boon Hor
 * @see Enemy
 */
public class LoneWolf extends Enemy {
    /**
     * Map of behaviours for LoneWolf
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * constructor for lone wolf
     */
    public LoneWolf() {
        super("Lone Wolf", 'h', 102);
        this.addCapability(EnemiesType.IS_LAND_TYPE);        // set type of enemy, so same type cannot attack each other
        ResetManager.getInstance().registerResettable(this);
    }
    /**
     * intrinsic weapon for lone wolf is its bite
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(97, "bites", 95);
    }

}