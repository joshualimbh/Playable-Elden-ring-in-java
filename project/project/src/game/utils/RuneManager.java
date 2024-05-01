package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.item.Rune;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A rune manager class that helps to manage the player's runes.
 * The Rune that this class is managing will be the player's rune.
 * @author Liew Dong Xun
 */
public class RuneManager {
    /**
     * hash map of rune amount 
     */
    private Map<Character, List<Integer>> runeAmount = new HashMap<>();
    /**
     * instance of runeManager
     */
    private static RuneManager instance;
    /**
     * the default player rune is null
     */
    private Rune playerRune = null;
    /**
     * generated integer
     */
    private int generated;
    /**
     * the default dropped rune is null
     */
    private Rune droppedRune = null;
    /**
     * the location at which runes were dropped
     */
    private Location droppedLocation;

    /**
     * rune manager private constructor containing hashmap of enemies and their rune amounts
     */
    private RuneManager(){
        runeAmount.put('h', addList(55, 1470)); // Lone Wolf
        runeAmount.put('q', addList(35, 892)); // Heavy Skeletal Swordsman
        runeAmount.put('C', addList(318, 4961)); // Giant Crab
        runeAmount.put('b', addList(35, 892)); // Skeletal Bandit
        runeAmount.put('G', addList(313, 1808)); // Giant Dog
        runeAmount.put('R', addList(500, 2374)); // Giant Crayfish
        runeAmount.put('X', addList(35,892)); // Pile Of Bones
        runeAmount.put('a', addList(52, 1390)); // Dog
        runeAmount.put('p', addList(38, 70)); // Godrick Soldier
        runeAmount.put('ඞ', addList(1358, 5578)); // Invader
    }

    /**
     * A method to get a single instance of RuneManager.
     * @return a single instance of RuneManager.
     */
    public static RuneManager getInstance(){
        if(instance == null){
            instance = new RuneManager();
        }
        return instance;
    }

    /**
     * A method that adds an enemy's rune into the player's rune.
     * @param enemy The enemy that was killed by the player.
     */
    public void addRuneToPlayer(Actor enemy) {
        List<Integer> runeRange = runeAmount.get(enemy.getDisplayChar());
        generated = RandomNumberGenerator.getRandomInt(runeRange.get(0), runeRange.get(1));
        playerRune.addRune(generated);
    }

    /**
     * Method to display the total rune amount that player currently have.
     * @return the total rune amount
     */
    public int showRuneAmount(){
        return playerRune.getAmount();
    }

    /**
     * Method to get a Rune object, so that any changes are made on that Rune.
     * @param rune A rune object.
     */
    public void getRuneObject(Rune rune) {
        playerRune = rune;
    }

    /**
     * Method to add an amount of rune to player's rune.
     * @param amount amount of rune to add
     */
    public void addRune(int amount){
        playerRune.addRune(amount);
    }

    /**
     * Method to subtract amount of rune from player's rune.
     * @param amount amount of rune to subtract
     */
    public void subtractRune(int amount){
        playerRune.useRune(amount);
    }

    /**
     * Method to drop rune at a location.
     * Will also ensure that only one rune is on the map at all times.
     * @param location location to drop the rune (player's location)
     */
    public void dropRune(Location location) {
        // before dropping rune, remove previous rune on map
        if (droppedRune != null) {
            droppedLocation.removeItem(droppedRune);
        }
        location.addItem(playerRune);
        runeAmount.put('$', addList(playerRune.getAmount(), playerRune.getAmount()));
        droppedRune = playerRune;
        droppedLocation = location;
        playerRune = new Rune();
        }

    /**
     * Method for player to pick up rune and add amount to own rune.
     */
    public void recoverRune() {
        List<Integer> runeOnGround = runeAmount.get('$');
        playerRune.addRune(runeOnGround.get(0));
    }

    /**
     * Method to show what is the amount of rune on ground.
     * @return the amount of rune that is on the ground.
     */
    public int showRuneOnGroundValue() {
        List<Integer> runeOnGround = runeAmount.get('$');
        return runeOnGround.get(0);
    }

    /**
     * Method to get the random number that is generated
     * @return a randomly generated number, based on lower and upper bounds set.
     */
    public int getGenerated() {
        return generated;
    }
    /**
     * Method to add a list of lower and upper bounds into a list.
     * @param lower the lower bound
     * @param upper the upper bound
     * @return a list of lower and upper bounds
     */
    private List<Integer> addList(int lower, int upper) {
        List<Integer> newList = new ArrayList<>();
        newList.add(lower);
        newList.add(upper);
        return newList;
    }
}


