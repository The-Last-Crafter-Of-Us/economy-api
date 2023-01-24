package world.anhgelus.tlcou.economyapi.economyapi.common.config.main;

import net.minecraftforge.common.config.Config;

public final class BankSubConfig {
    public String name = "Bank";
    @Config.Comment({
        "Max money stored in the bank"
    })
    @Config.RangeInt(min = 0, max = 1000000000)
    public long maxMoney = 1000000000;

    @Config.Comment({
        "This is the amount of money that the bank will give you when you create an account",
    })
    @Config.RangeInt(min = 0, max = 1000000000)
    public long moneyForNewPlayer = 0;
}
