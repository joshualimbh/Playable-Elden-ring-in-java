package game.enemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.*;
import game.behaviour.*;
import game.utils.Resettable;
import game.utils.Status;

import java.util.Map;
import java.util.TreeMap;

/**
 * A class that represents an enemy.
 * Created by:
 * @author
 * Modified by: Lim Jun Yi
 * @see Actor 
 * @see Resettable
 */
public abstract class Enemy extends Actor implements Resettable {
    /**
     * Map of behaviours for Enemy
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * boolean to check if enemy has follow behaviour
     */
    private boolean hasFollow;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(2, new AttackBehaviour());
        this.behaviours.put(4, new DespawnBehaviour());
        this.behaviours.put(5, new WanderBehaviour());
        this.hasFollow = false;
    }
    /**
     * what the enemy does every turn
     * @param actions list of possible actions
     * @param lastAction the last action performed
     * @param map the map the enemy is on
     * @param display the display
     * @return the action the enemy will perform
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if (this.hasCapability(Status.WIPED)) {
            new DespawnAction(this).execute(this, map);
            return new DoNothingAction();
        }

        if (!hasFollow){
            Location here = map.locationOf(this);
            for (Exit exit : here.getExits()) {
                Location destination = exit.getDestination();

                if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
                    this.behaviours.put(3, new FollowBehaviour(destination.getActor()));
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
     * get the list of allowable actions for the enemy
     * @param otherActor the other actor
     * @param direction the direction of the other actor
     * @param map the map the enemy is on
     * @return the list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
            for (WeaponItem weapons : otherActor.getWeaponInventory()) {
                actions.add(new AttackAction(this, direction, weapons));
                actions.add(weapons.getSkill(this, direction));
            }
        }

        return actions;

    }
    /**
     * despawn enemy by setting status as wiped
     */
    @Override
    public void reset() {
        this.addCapability(Status.WIPED);
    }


}
