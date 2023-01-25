package world.anhgelus.tlcou.economyapi.server.economy.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagLong;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

/**
 * Storage for the Economy
 * @author anhgelus
 */
public class EconomyStorage implements Capability.IStorage<IEconomy>{
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IEconomy> capability, IEconomy instance, EnumFacing side) {
        return new NBTTagLong(instance.get());
    }

    @Override
    public void readNBT(Capability<IEconomy> capability, IEconomy instance, EnumFacing side, NBTBase nbt) {
        instance.set(((NBTTagLong) nbt).getLong());
    }
}
