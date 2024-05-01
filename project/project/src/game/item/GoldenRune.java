package game.item;


import java.util.Random;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import game.action.ConsumeAction;
import game.utils.Consumable;
import game.utils.RuneManager;
/**
 * New Consumable item ; Golden Rune
 * This item can be consumed by the player to add a random amount of runes from 200-10000 to the player's inventory.
 * This item can be picked up by the player and can be dropped by the player.
 * 
 * @author Joshua Lim Boon Hor
 */
public class GoldenRune extends Item implements Consumable{
    int amount; //amount of Golden runes
    private Random rand = new Random(); // to generate random number of runes
    private Action consumeAction = new ConsumeAction(this); //consume action
    private Actor player; //actor using the item

    public GoldenRune() {
        super("Golden Rune", '*', true);

        
    }
    /**
     * Method to get the maximum use of this item.
     * @return the maximum use of this item
     */
    @Override
    public void consume() {
        this.amount -= 1;
        RuneManager.getInstance().addRune(rand.nextInt(200,10000));

        if (this.amount < 1){
            this.removeAction(consumeAction);
            //remove the item from players inventory
            player.removeItemFromInventory(this);
        }
        
    }

    @Override
    public int getMaxUse() {
        return this.amount;
    }
    /**
     * Method to get the number of uses left of this item.
     * @return the number of uses left of this item.
     */
    @Override
    public int getUsesLeft() {
        return this.amount;
    }
    	/**
	 * Create and return an action to pick this Item up.
	 * If this Item is not portable, returns null. 
	 * 
	 * @return a new PickUpItemAction if this Item is portable, null otherwise.
	 */
    @Override
	public PickUpAction getPickUpAction(Actor actor) {
		if(portable){
            this.player = actor;
            this.addAction(consumeAction);
            this.amount += 1 ;
			return new PickUpItemAction(this);}
        else{return null;} 
	}
}
