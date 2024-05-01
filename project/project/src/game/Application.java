package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.enviorment.*;


import game.gamemap.BossRoom;
import game.gamemap.Limgrave;
import game.gamemap.RoundtableHold;
import game.gamemap.StormveilCastle;

import game.item.GoldenRune;

import game.trader.FingerReaderEnia;

import game.trader.MerchantKale;
import game.utils.ChooseClassMenu;
import game.utils.FancyMessage;
import game.utils.ResetManager;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Lim Jun Yi, Liew Dong Xun, Joshua Lim Boon Hor
 * 
 */
public class Application {

	public static void main(String[] args) {

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		// Creates a new world
		World world = new World(new Display());


		// Add the map Limgrave to the world
		GameMap limgrave = new Limgrave().getGameMap();
		world.addGameMap(limgrave);
		limgrave.at(40,12).addActor(new MerchantKale());
		limgrave.at(37,12).addActor(new FingerReaderEnia());
		limgrave.at(36,11).addItem(new GoldenRune());

		// Add the map Stormveil Castle to the world
		GameMap stormveilCastle = new StormveilCastle().getGameMap();
		world.addGameMap(stormveilCastle);

		// Add the map Roundtable Hold to the world
		GameMap roundtableHold = new RoundtableHold().getGameMap();
		world.addGameMap(roundtableHold);

		// Add the map Boss Room to the world
		GameMap bossRoom = new BossRoom().getGameMap();
		world.addGameMap(bossRoom);

		// adding all Golden Fog Doors
		limgrave.at(38,15).setGround(new GoldenFogDoor("Roundtable Hold", roundtableHold.at(9,10)));
		limgrave.at(38,8).setGround(new GoldenFogDoor("Stormveil Castle", stormveilCastle.at(37,23)));
		roundtableHold.at(9,10).setGround(new GoldenFogDoor("Limgrave", limgrave.at(38,15)));
		stormveilCastle.at(37,23).setGround(new GoldenFogDoor("Limgrave", limgrave.at(38,8)));
		stormveilCastle.at(47,0).setGround(new GoldenFogDoor("Boss Room", bossRoom.at(13,7)));


		// create a new player and choose their class
		Player player = ChooseClassMenu.chooseClass();
		
		// add player to the world
		world.addPlayer(player, limgrave.at(36, 10));


		// set default SiteOfLostGrace for player
		ResetManager.getInstance().saveLastVisited(limgrave.at(38, 10));

		world.run(); //run the game
	}
}
