package ru.job4j.exchanger;

import java.util.Arrays;

/**
 * Class Exchanger.
 *
 * @author Ekaterina Turka (ekaterina2rka@gmail.com)
 * @version 1
 * @since 23.12.2017
 */
public class Exchanger {
    /**
     * Coins denomination.
     */
    private static final int[] COINS = {10, 5, 2, 1};

    /**
     * Count change with considering coins denomination.
     *
     * @param value denomination
     * @param price good cost
     * @return change array
     * @throws LackValueException when the price is bigger than insert value
     */
    public int[] changes(int value, int price) throws LackValueException {
        if (value < price) {
            throw new LackValueException();
        }
        value -= price;
        int count = 0;
        int[] coinsCount = new int[COINS.length];
        for (int i = 0; i < COINS.length; i++) {
            coinsCount[i] = value / COINS[i];
            value %= COINS[i];
            count += coinsCount[i];
        }
        int[] coins = new int[count];
        for (int i = 0; i < COINS.length; i++) {
            if (coinsCount[i] > 0) {
                Arrays.fill(coins, count - coinsCount[i], count, COINS[i]);
                count -= coinsCount[i];
            }
        }
        return coins;
    }
}