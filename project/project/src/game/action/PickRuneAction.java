package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.RuneManager;

/**
 * A class that allows player to pick up runes on ground.
 * @author Liew Dong Xun
 * @see Action
 */
public class PickRuneAction extends Action {
    Item item;

    /**
     * Constructor for PickRuneAction class.
     * @param item the item that is to be picked up.
     */
    public PickRuneAction(Item item) {
        this.item = item;
    }

    /**
     * Method to pick up rune from ground, and add amount to player's rune.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description showing how many runes the player picked up.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).removeItem(this.item);
        RuneManager.getInstance().recoverRune();
        return actor + "retrieved Rune (value: " + RuneManager.getInstance().showRuneOnGroundValue() + ")";
    }

    /**
     * Method that describes how many runes can a player pick up.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " retrieves Runes (value: " + RuneManager.getInstance().showRuneOnGroundValue() + ")" ;
    }
}
