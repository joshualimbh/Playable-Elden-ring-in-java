package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Player;
import game.utils.ResetManager;
import game.utils.RuneManager;
import game.utils.FancyMessage;
import game.utils.Status;

/**
 * An action executed if an actor is killed.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Liew Dong Xun, Lim Jun Yi, Joshua
 * @see Action
 */
public class DeathAction extends Action {
    /**
     * the attacker attribute
     */
    private Actor attacker;

    /**
     * constructor
     * @param actor the actor attacking
     */
    public DeathAction(Actor actor) {
        this.attacker = actor;
    }

    /**
     * When the target is killed, the items & weapons carried by target
     * will be dropped to the location in the game map where the target was
     *
     * @param target The actor performing the action.
     * @param map The map the actor is on.
     * @return result of the action to be displayed on the UI
     */
    @Override
    public String execute(Actor target, GameMap map) {
        String result = "";

        ActionList dropActions = new ActionList();
        // only if not a player
        if (!target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            //drop all items
            for (Item item : target.getItemInventory())
                dropActions.add(item.getDropAction(target));
            for (WeaponItem weapon : target.getWeaponInventory())
                dropActions.add(weapon.getDropAction(target));
            for (Action drop : dropActions)
                drop.execute(target, map);

            // remove actor
            map.removeActor(target);
            result += System.lineSeparator() + menuDescription(target);

            if(this.attacker.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                RuneManager.getInstance().addRuneToPlayer(target);
                result += System.lineSeparator() + target + " transfers " + RuneManager.getInstance().getGenerated() + " runes to " + this.attacker.toString();
            }

        } else { // if player dies
            Location siteOfLostGraces = ResetManager.getInstance().retrieveLastVisited();
            Location lastLocation = ResetManager.getInstance().retrieveLastLocation();

            // Drop rune
            RuneManager.getInstance().dropRune(lastLocation);
            ResetManager.getInstance().run();
            map.moveActor(target, siteOfLostGraces);

            ResetManager.getInstance().removeActorList(map);

            // print YOU DIED message
            for (String line : FancyMessage.YOU_DIED.split("\n")) {
                new Display().println(line);
                try {
                    Thread.sleep(350);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }

        return result;
    }
    /**
     * Method that describes which actor is killed.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is killed.";
    }
}
