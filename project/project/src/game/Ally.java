package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.DespawnAction;
import game.behaviour.AttackBehaviour;
import game.behaviour.Behaviour;
import game.behaviour.WanderBehaviour;
import game.item.FlaskOfCrimsonTears;
import game.item.Rune;
import game.utils.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * A class that represents an Ally.
 * Created by:
 * @author Lim Jun Yi
 * Modified by: Lim Jun Yi
 * @see Actor
 */
public class Ally extends Actor implements Resettable {
    /**
     * Map of behaviours for Ally
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor.
     *
     */
    public Ally(int hitPoints, WeaponItem weapon) {
        super("Ally", 'A', hitPoints);
        this.addCapability(Status.FRIENDLY);
        this.addWeaponToInventory(weapon);
        this.behaviours.put(0, new AttackBehaviour());
        this.behaviours.put(1, new WanderBehaviour());
        ResetManager.getInstance().addActor(this);
    }

    /**
     * what an Ally does/or can do within each turn
     * @param actions list of possible actions
     * @param lastAction the action that was performed in the previous turn
     * @param map the map the player is on
     * @param display the display
     * @return the action that the player will perform
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Ally's reset method
     */
    @Override
    public void reset() {
    }
}
