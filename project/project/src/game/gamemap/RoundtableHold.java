package game.gamemap;


import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enviorment.*;

import java.util.Arrays;
import java.util.List;

/**
 * A class that creates the "Roundtable Hold" map.
 * @author Liew Dong Xun
 */
public class RoundtableHold {

    private List<String> map;
    private FancyGroundFactory groundFactory;
    private GameMap gameMap;

    /**
     * Constructor
     */
    public RoundtableHold() {
        this.groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater(), new SiteOfLostGrace(), new Cliff(), new Cage(), new Barrack(), new SummonSign());
        this.mapLayout();
        this.gameMap = new GameMap(this.groundFactory, this.map);
    }
    /**
     * A method that returns the gamemap created by this class.
     * @return the gamemap created by this class.
     */
    public GameMap getGameMap() {
        return this.gameMap;
    }

    /**
     * A private method to set the map layout.
     * This is to make constructor neater.
     */
    private void mapLayout(){
        this.map = Arrays.asList(
                "##################",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "########___#######");
    }
}
