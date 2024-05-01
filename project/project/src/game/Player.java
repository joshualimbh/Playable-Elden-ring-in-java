package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import edu.monash.fit2099.engine.displays.Menu;
import game.action.DeathAction;
import game.action.PickRuneAction;
import game.action.SpawnAction;
import game.enviorment.SiteOfLostGrace;
import game.item.FlaskOfCrimsonTears;
import game.item.RemembranceOfTheGrafted;
import game.item.Rune;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.utils.RuneManager;
import game.utils.Status;

import java.util.List;


/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Lim Jun Yi, Joshua Lim Boon Hor
 *
 */
public class Player extends Actor implements Resettable {
	/**
	 * Menu to display when player is in the game
	 */
	private final Menu menu = new Menu();

	/**
	 * Constructor.
	 *
	 * @param hitPoints   Player's starting number of hitpoints
	 * @param weapon Player's initial weapon
	 */
	public Player(int hitPoints, WeaponItem weapon) {
		super("Tarnished", '@', hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.RESTING);
		this.addWeaponToInventory(weapon);
		this.addItemToInventory(new FlaskOfCrimsonTears(this));
		Rune playerRune = new Rune();
		this.addItemToInventory(playerRune);
		this.addItemToInventory(new RemembranceOfTheGrafted(this));
		RuneManager.getInstance().getRuneObject(playerRune);
		ResetManager.getInstance().registerResettable(this);
	}
	/**
	 * what a player does/or can do within each turn
	 * @param actions list of possible actions
	 * @param lastAction the action that was performed in the previous turn
	 * @param map the map the player is on
	 * @param display the display
	 * @return the action that the player will perform
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// check if current location has a rune
		List<Item> items = map.locationOf(this).getItems();
		for (Item item : items) {
			if (item.getDisplayChar() == '$') {	// item is a rune
				actions.add(new PickRuneAction(item));

			}
		}

		// Check if current location is a SiteOfLostGrace
		if (map.locationOf(this).getGround().getDisplayChar() == 'U') {
			ResetManager.getInstance().saveLastVisited(map.locationOf(this));
		}


		// check if current location is cliff
		if (map.locationOf(this).getGround().getDisplayChar() == '+') {
			return new DeathAction(this);
		}

		// update last location
		ResetManager.getInstance().saveLastLocation(map.locationOf(this));

		// return/print the console menu
		System.out.println(name + this.printHp() + ", " + "runes: " + RuneManager.getInstance().showRuneAmount());
		return menu.showMenu(this, actions, display);
	}
	/**
	 * reset the player's hitpoints to the maximum hitpoints
	 */
	@Override
	public void reset() {
		this.resetMaxHp(this.getMaxHp());
	}
}
