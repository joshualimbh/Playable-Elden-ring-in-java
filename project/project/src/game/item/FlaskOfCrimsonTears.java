package game.item;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.utils.Consumable;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.action.ConsumeAction;

/**
 * An Item that allows an actor to heal.
 * @author Liew Dong Xun
 * @see Item
 * @see Consumable
 * @see Resettable
 */
public class FlaskOfCrimsonTears extends Item implements Consumable,Resettable {

    private final int MAX_USE = 2; // max number of uses item has
    private int count = 2; // current number of uses
    private Actor actor; //actor using the item
    private Action consumeAction = new ConsumeAction(this); //consume action

    /**
     * Constructor for FlaskOfCrimsonTears class
     * @param actor the actor that is using this item.
     */
    public FlaskOfCrimsonTears(Actor actor) {
        super("Flask Of Crimson Tears", '-', false);
        this.addAction(consumeAction);
        this.actor = actor;
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Method to consume this item.
     * Does not allow actor to consume if item cannot be consumed anymore.
     */
    @Override
    public void consume() {
        this.count -= 1;
        this.actor.heal(250);

        if (this.count < 1) {
            this.removeAction(consumeAction);
        }
    }

    /**
     * Method to get the maximum use of this item.
     * @return the maximum use of this item
     */
    @Override
    public int getMaxUse() {
        return this.MAX_USE;
    }

    /**
     * Methos to get the number of uses left of this item.
     * @return the number of uses left of this item.
     */
    @Override
    public int getUsesLeft() {
        return this.count;
    }

    /**
     * Method to reset this item.
     * Makes the number of uses left = max number of uses.
     */
    @Override
    public void reset() {
        if (this.count < 1) {
            this.addAction(consumeAction);
        }
        this.count = 2;
        
    }
}
