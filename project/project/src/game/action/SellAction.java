package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.RuneManager;

import java.util.HashMap;

/**
 * An action that allows an actor to sell to trader
 * @author Liew Dong Xun
 * @see Action
 */
public class SellAction extends Action {
    private WeaponItem weapon; //weapon being sold 

    private HashMap<String,Integer> weaponPrice = new HashMap<>(); //hashmap of the weapon prices
    private int price;//price integer attribute

    /**
     * Constructor of SellAction Class.
     * @param weapon the weapon intended to be sold.
     */
    public SellAction(WeaponItem weapon) {
        this.weapon = weapon;
        weaponPrice.put("Uchigatana", 500);
        weaponPrice.put("Great Knife", 350);
        weaponPrice.put("Club", 100);
        weaponPrice.put("Grossmesser", 100);
        weaponPrice.put("Axe Of Godrick", 100);
        weaponPrice.put("Grafted Dragon", 200);
        weaponPrice.put("Flaming Sword", 100);
        this.price = weaponPrice.get(weapon.toString());
    }
    /**
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a message notifying that the sale was successful
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // remove weapon from actors inventory
        actor.removeWeaponFromInventory(weapon);

        // sell means actor selling to trader, so actor add runes
        RuneManager.getInstance().addRune(this.price);

        //return string
        return actor + " sold " + this.weapon + " for " + this.price + " runes.";
    }

    /**
     * Describes what an actor can sell
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + this.weapon + " for " + this.price + " runes.";
    }
}
