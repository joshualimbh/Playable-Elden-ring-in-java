package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.RuneManager;

import java.util.HashMap;

/**
 * A action that allows an actor to buy from trader.
 * @author Liew Dong Xun
 * @see Action
 */
public class BuyAction extends Action {
    private WeaponItem weapon;
    private HashMap<String,Integer> weaponPrice = new HashMap<>();
    private int price;

    /**
     * Constructor for BuyAction class.
     * @param weapon the weapon intended to be bought
     */
    public BuyAction(WeaponItem weapon) {
        this.weapon = weapon;
        weaponPrice.put("Uchigatana", 5000);
        weaponPrice.put("Great Knife", 3500);
        weaponPrice.put("Club", 600);
        this.price = weaponPrice.get(weapon.toString());
    }

    /**
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a message if the purchase is successful and a message if the purchase is not successful
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // buy means player buy from trader, so player minus runes
        if (this.price > RuneManager.getInstance().showRuneAmount()) {
            return "You do not have enough runes to purchase this item.";
        }

        //item gets added into inventory
        actor.addWeaponToInventory(weapon);
        RuneManager.getInstance().subtractRune(this.price);
        return actor +"purchased" + this.weapon + "for" + price + "runes.";
    }


    /**
     * Describes what an actor can purchase.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + this.weapon + " for " + price + " runes.";
    }

}
