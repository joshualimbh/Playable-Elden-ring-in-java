package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Consumable;

/**
 * An action to consume an item.
 * @author Liew Dong Xun
 * @see Action
 */
public class ConsumeAction extends Action {
    /**
     * consumable item attribute
     */
    Consumable consumableItem;
    /**
     * constructor
     * @param consumableItem the item wished to be consumed
     */
    public ConsumeAction(Consumable consumableItem) {
        this.consumableItem = consumableItem;
    }

    /**
     * Method that will consume the intended item.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string that shows which actor consume what item, and how many uses left of that item.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        this.consumableItem.consume();
        return actor + " consumed " + this.consumableItem.toString() + " (" + this.consumableItem.getUsesLeft() + "/" + this.consumableItem.getMaxUse() + ")";

    }

    /**
     * Method that describes which actor can consume what item, and the amount of uses left of that item.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + this.consumableItem.toString() + " (" + this.consumableItem.getUsesLeft() + "/" + this.consumableItem.getMaxUse() + ")";

    }
}
