package game.item;

import edu.monash.fit2099.engine.items.Item;

/**
 * An item that allows actor to do trading.
 * Acts as a currency.
 * @author Liew Dong Xun
 * @see Item
 */
public class Rune extends Item {

    private int amount; //amount of runes

    /**
     * Constructor for Rune class.
     */
    public Rune() {
        super("Rune", '$', false);
        this.amount = 0;
    }

    /**
     * Method to get the amount of rune.
     * @return the amount of rune
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Method to add to the number of runes
     * @param newAmount the number of runes needed to be added
     */
    public void addRune(int newAmount){
        this.amount += newAmount;
    }

    /**
     * Method to subtract the number of runes
     * @param runeUsed the number of runes needed to be subtracted.
     */
    public void useRune(int runeUsed) {
        this.amount -= runeUsed;
    }
}
