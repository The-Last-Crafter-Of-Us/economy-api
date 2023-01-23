package world.anhgelus.economyapi.common.config.main;

import net.minecraftforge.common.config.Config;

public final class BankSubConfig {
    public String name = "Bank";
    @Config.Comment({
        "This is the amount of money that the bank will give you when you create an account",
        "This is in the currency that you set in the main config file",
    })
    @Config.RangeInt(min = 0, max = 1000000000)
    public long maxMoney = 1000000000;
}
