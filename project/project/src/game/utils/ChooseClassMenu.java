package game.utils;

import game.Player;
import game.playerClass.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Allows the user to choose a class for their player.
 * @author Liew Dong Xun
 * Modified by: Lim Jun Yi
 */
public class ChooseClassMenu {
    /**
     * hashmap of player class 
     */
    private static HashMap<String, Player> playerClass = new HashMap<>();
    private static final PlayerRoleFactory astrologer = new Astrologer();
    private static final PlayerRoleFactory bandit = new Bandit();
    private static final PlayerRoleFactory samurai = new Samurai();
    private static final PlayerRoleFactory wretch = new Wretch();


    /**
     * Method that prints out a list of choosable classes, and lets user to choose a class
     * @return a Player with the chosen class.
     */
    public static Player chooseClass() {
        /*
         * return value for which player class is chosen
         */
        Player res = null;
        while (res == null) {
            playerClass.put("a", astrologer.chosePlayerRole());
            playerClass.put("b", bandit.chosePlayerRole());
            playerClass.put("s", samurai.chosePlayerRole());
            playerClass.put("w", wretch.chosePlayerRole());
            System.out.println("Select your role:");
            System.out.println("b: Bandit");
            System.out.println("s: Samurai");
            System.out.println("w: Wretch");
            System.out.println("a: Astrologer");
            Scanner sel = new Scanner(System.in);
            String classChoice = sel.nextLine();
            res = playerClass.get(classChoice);
        }
        return res;
    }

}
