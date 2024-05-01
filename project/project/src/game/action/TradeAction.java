package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A class that allows player to trade with the trader.
 * @author Liew Don Xuan
 * Modified by: Lim Jun Yi
 * @see Action
 */
public class TradeAction extends Action{
    private Item item;
    private WeaponItem weapon;

    /**
     * Constructor
     * @param weapon the weapon intended to be traded
     */
    public TradeAction(WeaponItem weapon,Item item){
        this.weapon = weapon;
        this.item = item;
    }

    /**
     * When executed, actor will trade with the trader
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a message notifying that the sale was successful
     */
    @Override
    public String execute(Actor actor, GameMap map) {
     actor.addWeaponToInventory(this.weapon);
     actor.removeItemFromInventory(this.item);
     return actor + " trades " + this.item + " for " + this.weapon;
    }

    /**
     * Describes what has been traded wit the trader.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " trades " + this.item + " for " + this.weapon;
    }

    
}
