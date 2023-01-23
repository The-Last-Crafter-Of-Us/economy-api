package world.anhgelus.economyapi.common.config;

import net.minecraftforge.common.config.Config;
import world.anhgelus.economyapi.EconomyAPI;
import world.anhgelus.economyapi.common.config.main.BankSubConfig;
import world.anhgelus.economyapi.common.config.main.CurrencySubConfig;

@Config(modid = EconomyAPI.MOD_ID, name = EconomyAPI.FOLDER + "/main")
public final class MainConfig {
    @Config.Comment({
        "This is the main config file for EconomyAPI",
        "This is where you can change the main settings for the mod",
    })
    public static String version = "0.0.1";
    public static CurrencySubConfig currency = new CurrencySubConfig();
    public static BankSubConfig bank = new BankSubConfig();
}
