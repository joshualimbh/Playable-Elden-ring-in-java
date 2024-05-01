package game.enemy.undeadtype;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.enemy.Enemy;
import game.enemy.undeadtype.HeavySkeletalSwordsman;
import game.enemy.undeadtype.SkeletalBandit;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.utils.Status;
import game.behaviour.Behaviour;
import game.behaviour.ReviveBehaviour;
//import game.behaviour.ReviveBehaviour;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Pile of Bones a special ability some enemies have.
 * Created by:
 * @author
 * Modified by: Lim Jun Yi
 * @see Enemy
 * @see HeavySkeletalSwordsman
 * @see SkeletalBandit
 */
public class PileOfBones extends Enemy {
    /**
     * Map of behaviours for PileOfBones
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * counter to keep track of how many turns have passed
     */
    private int counter;
    /**
     * the actor that was previously killed
     */
    private final Actor previous;
    /**
     * constructor for PileOfBones
     * @param weaponInventory the weapon inventory of the actor that was previously killed
     * @param actor the actor that was previously killed
     */
    public PileOfBones(List<WeaponItem> weaponInventory, Actor actor) {
        super("Pile Of Bones", 'X', 1);
        for (WeaponItem weapon: weaponInventory){
            this.addWeaponToInventory(weapon);
        }
        this.counter = 0;
        this.previous = actor;
        this.addCapability(EnemiesType.IS_UNDEAD_TYPE);
        this.addCapability(Status.RESPAWNABLE);
        this.behaviours.put(0, new ReviveBehaviour(this.previous));
        ResetManager.getInstance().registerResettable(this);
    }
    /**
     * returns the actor that was previously killed
     * @return an action to either revive the actor or do nothing
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (counter == 3) {

            for (Behaviour behaviour : behaviours.values()) {
                Action action = behaviour.getAction(this, map);
                if (action != null)
                    return action;
            }
        }

        counter += 1;

        return new DoNothingAction();
    }

}
