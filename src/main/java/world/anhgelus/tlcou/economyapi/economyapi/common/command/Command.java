package world.anhgelus.tlcou.economyapi.economyapi.common.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class Command extends CommandBase {
    public final List<String> subs;
    public final String name;
    public final String modid;

    /**
     * Player after a successful check
     */
    @Nullable
    protected EntityPlayer player;

    public Command(List<String> subs, String name, String modid) {
        this.subs = subs;
        this.name = name;
        this.modid = modid;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull String getUsage(ICommandSender sender) {
        return this.modid+ ".command."+this.name+".usage";
    }

    @Override
    public abstract void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException;

    /**
     * Check if the command is valid
     * @param server Server
     * @param sender Sender
     * @param args Arguments
     * @return true if it's valid
     */
    protected boolean checks(MinecraftServer server, ICommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new TextComponentTranslation(getUsage(sender)));
            return false;
        }
        if(!(sender instanceof EntityPlayer)) {
            sender.sendMessage(new TextComponentTranslation(this.modid+ "command.not-player"));
            return false;
        }
        this.player = (EntityPlayer) sender;
        return true;
    }

    protected String generateKey(String name, @Nullable String sub) {
        if (sub == null) return modid+ ".command."+name;
        return modid+ ".command."+name+"."+sub;
    }

    protected String generateKey(String name) {
        return modid+ ".command."+name;
    }
}
