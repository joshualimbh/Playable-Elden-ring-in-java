package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.DespawnAction;
import game.behaviour.AttackBehaviour;
import game.behaviour.Behaviour;
import game.behaviour.FollowBehaviour;
import game.behaviour.WanderBehaviour;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.utils.Status;

import java.util.Map;
import java.util.TreeMap;

/**
 * A class that represents an Invader.
 * Created by:
 * @author Lim Jun Yi
 * Modified by: Lim Jun Yi
 * @see Actor
 */
public class Invader extends Actor implements Resettable {
    /**
     * Map of behaviours for Invader
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * boolean to check if Invader has follow behaviour
     */
    private boolean hasFollow;

    /**
     * Constructor.
     *
     */
    public Invader(int hitPoints, WeaponItem weapon) {
        super("Invader", 'ඞ', hitPoints);
        this.addWeaponToInventory(weapon);
        this.behaviours.put(1, new AttackBehaviour());
        this.behaviours.put(3, new WanderBehaviour());
        this.hasFollow = false;
        ResetManager.getInstance().addActor(this);
    }

    /**
     * what an Invader does/or can do within each turn
     * @param actions list of possible actions
     * @param lastAction the action that was performed in the previous turn
     * @param map the map the player is on
     * @param display the display
     * @return the action that the player will perform
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {


        if (!hasFollow){
            Location here = map.locationOf(this);
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();

                if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    this.behaviours.put(2, new FollowBehaviour(destination.getActor()));
                    this.hasFollow = true;
                }
            }
        }

        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * Invader's reset method
     */
    @Override
    public void reset() {
    }
}
