package world.anhgelus.tlcou.economyapi.server.economy.capability;

import world.anhgelus.tlcou.economyapi.EconomyAPI;

/**
 * Capability for the Economy
 * @author anhgelus
 */
public class IEconomy {

    private long money = EconomyAPI.getEconomy().moneyForNewPlayer;

    public void add(long amount) {
        money += amount;
    }
    public void remove(long amount) {
        money -= amount;
    }
    public void set(long amount) {
        money = amount;
    }
    public void reset() {
        money = EconomyAPI.getEconomy().moneyForNewPlayer;
    }
    public long get() {
        return money;
    }
}
