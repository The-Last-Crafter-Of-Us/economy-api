package world.anhgelus.tlcou.economyapi.economyapi.common.economy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import world.anhgelus.tlcou.economyapi.economyapi.EconomyAPI;
import world.anhgelus.tlcou.economyapi.economyapi.common.config.MainConfig;
import world.anhgelus.tlcou.economyapi.economyapi.server.economy.capability.IEconomy;

public class Economy {
    public final String name;
    public final String symbol;
    public final long maxMoney;
    public final String bankName;
    public final long moneyForNewPlayer;

    public static final ResourceLocation ECONOMY_CAP_LOCATION = new ResourceLocation(EconomyAPI.MOD_ID, "economy-cap");

    @CapabilityInject(IEconomy.class)
    static Capability<IEconomy> ECONOMY_CAP = null;

    public Economy() {
        name = MainConfig.currency.name;
        symbol = MainConfig.currency.symbol;
        maxMoney = MainConfig.bank.maxMoney;
        bankName = MainConfig.bank.name;
        moneyForNewPlayer = MainConfig.bank.moneyForNewPlayer;
    }

    /**
     * Get the amount of money of a player
     * @param player the player
     * @return the amount of money
     */
    public long get(EntityPlayer player) {
        final IEconomy capability = capability(player);
        return capability.get();
    }

    /**
     * Set the amount of money of a player
     * @param player the player
     * @param amount the amount of money
     */
    public void set(EntityPlayer player, long amount) {
        final IEconomy capability = capability(player);
        capability.set(amount);
    }

    /**
     * Add an amount of money to a player
     * @param player the player
     * @param amount the amount of money
     * @return the new amount of money
     */
    public long add(EntityPlayer player, long amount) {
        final IEconomy capability = capability(player);
        capability.add(amount);
        return capability.get();
    }

    /**
     * Remove an amount of money from a player
     * @param player the player
     * @param amount the amount of money
     * @return the new amount of money
     */
    public long remove(EntityPlayer player, long amount) {
        final IEconomy capability = capability(player);
        capability.remove(amount);
        return capability.get();
    }

    /**
     * Reset the amount of money of a player
     * @param player the player
     * @return the new amount of money
     */
    public long reset(EntityPlayer player) {
        final IEconomy capability = capability(player);
        capability.reset();
        return moneyForNewPlayer;
    }

    protected IEconomy capability(EntityPlayer player) {
        if (!player.hasCapability(ECONOMY_CAP, null)) {
            throw new RuntimeException("Player has no capability");
        }
        return player.getCapability(ECONOMY_CAP, null);
    }
}
