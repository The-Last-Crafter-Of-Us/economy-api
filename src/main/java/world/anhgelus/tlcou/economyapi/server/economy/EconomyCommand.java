package world.anhgelus.tlcou.economyapi.server.economy;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;
import org.jetbrains.annotations.NotNull;
import world.anhgelus.tlcou.economyapi.EconomyAPI;
import world.anhgelus.tlcou.economyapi.common.command.Command;
import world.anhgelus.tlcou.economyapi.server.utils.PlayerHelper;

import java.util.Arrays;
import java.util.List;

public class EconomyCommand extends Command {
    public final static List<String> SUBS = Arrays.asList("get", "set");

    public EconomyCommand() {
        super(SUBS, "economy", EconomyAPI.MOD_ID);
    }

    @Override
    public void execute(@NotNull MinecraftServer server, @NotNull ICommandSender sender, String @NotNull [] args) throws CommandException {
        if (!this.checks(server, sender, args)) return;
        assert player != null;
        final String sub = args[0];
        assert sub != null;
        switch (sub) {
            case "get":
                get(args);
                break;
            case "set":
                set(args);
                break;
        }
    }

    private void get(String[] args) {
        if (args.length != 2) {
            player.sendMessage(new TextComponentTranslation(generateKey("get", "usage")));
            return;
        }
        final String playerStr = args[1];
        final EntityPlayer player = PlayerHelper.getPlayer(playerStr);
        final long money = EconomyAPI.getEconomy().get(player);
        player.sendMessage(new TextComponentTranslation(generateKey("get", "success"), playerStr, money));
    }

    private void set(String[] args) {
        if (args.length != 3) {
            player.sendMessage(new TextComponentTranslation(generateKey("set", "usage")));
            return;
        }
        final String playerStr = args[1];
        final String amountStr = args[1];
        final EntityPlayer player = PlayerHelper.getPlayer(playerStr);
        EconomyAPI.getEconomy().set(player, Long.parseLong(amountStr));
        player.sendMessage(new TextComponentTranslation(generateKey("set", "success"), playerStr, amountStr));
    }
}
