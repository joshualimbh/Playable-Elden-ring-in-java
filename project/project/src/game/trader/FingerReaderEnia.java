package game.trader;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;
import game.weapon.AxeOfGodrick;
import game.weapon.GraftedDragon;
import game.action.SellAction;
import game.action.TradeAction;
import game.item.RemembranceOfTheGrafted;
/**
 * Class representing the Finger Reader Enia. It extends Actor class.
 * Created by:
 * @author Joshua Lim Boon Hor
 * Modified by Liew Dong Xun
 * @see Actor
 */
public class FingerReaderEnia extends Actor{
    /**
     * constructor for the FingerReaderEnia class
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 100);
        this.addWeaponToInventory(new AxeOfGodrick());
        this.addWeaponToInventory(new GraftedDragon());
    
}

    /**
     * Method that sets what action this actor can do.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return a DoNothing action, since trader will not perform any action on its own.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
    /**
     * Method that allows a player to trade with this actor
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return a list of weapons that can be bought and sold.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {  // assuming that only player is hostile to enemy

            for (Item item: otherActor.getItemInventory()) {
                if (item.getDisplayChar() == 'O') {
                    for (WeaponItem selfweapons : this.getWeaponInventory()) {
                        actions.add(new TradeAction(selfweapons, item));
                    }
                }
            }


            for (WeaponItem weapons : otherActor.getWeaponInventory()) {
                actions.add(new SellAction(weapons));
                }
            }
        return actions;
    }
}
