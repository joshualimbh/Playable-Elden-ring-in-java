package game.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
/**
 * Class representing the RemembranceOfTheGrafted. It extends Item class.
 * Created by:
 * @author Joshua Lim Boon Hor
 * @see Item
 */
public class RemembranceOfTheGrafted extends Item{
    /**
     * Constructor
     * @param actor the actor that has the RemembranceOfTheGrafted
     */
    private int amount;
    public RemembranceOfTheGrafted(Actor actor){
        super("Remembrance of the Grafted", 'O', true);
        this.amount = 0;
    }
    
}
