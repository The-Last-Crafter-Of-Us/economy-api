package world.anhgelus.economyapi.server.listener;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import world.anhgelus.economyapi.common.economy.Economy;
import world.anhgelus.economyapi.server.economy.capability.EconomyProvider;

public class AttachCapabilitiesListener {
    @SubscribeEvent
    public static void playerCapabilities(@NotNull AttachCapabilitiesEvent<Entity> event) {
        if (!(event.getObject() instanceof EntityPlayer)) return;
        event.addCapability(Economy.ECONOMY_CAP, new EconomyProvider());
    }
}
