package world.anhgelus.economyapi.common.economy;

import net.minecraft.util.ResourceLocation;
import world.anhgelus.economyapi.EconomyAPI;
import world.anhgelus.economyapi.common.config.MainConfig;

public class Economy {
    public final String name;
    public final String symbol;
    public final long maxMoney;
    public final String bankName;
    public final long moneyForNewPlayer;

    public static final ResourceLocation ECONOMY_CAP = new ResourceLocation(EconomyAPI.MOD_ID, "economy-cap");

    public Economy() {
        name = MainConfig.currency.name;
        symbol = MainConfig.currency.symbol;
        maxMoney = MainConfig.bank.maxMoney;
        bankName = MainConfig.bank.name;
        moneyForNewPlayer = MainConfig.bank.moneyForNewPlayer;
    }
}
