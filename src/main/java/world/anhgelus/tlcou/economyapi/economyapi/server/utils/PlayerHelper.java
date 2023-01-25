package world.anhgelus.tlcou.economyapi.economyapi.server.utils;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class PlayerHelper {
    private static final MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();

    /**
     * Get a player from his username
     * @param username Username
     * @return Player
     */
    @Nullable
    public static EntityPlayerMP getPlayer(String username) {
        return server.getPlayerList().getPlayerByUsername(username);
    }

    /**
     * Get a player from his uuid
     * @param uuid UUID
     * @return Player
     */
    @Nullable
    public static EntityPlayerMP getPlayer(UUID uuid) {
        return server.getPlayerList().getPlayerByUUID(uuid);
    }

}
