package world.anhgelus.economyapi.server.economy.capability;

import java.util.concurrent.Callable;

/**
 * Factory for the Economy
 * @author anhgelus
 */
public class EconomyFactory implements Callable<IEconomy> {

    private long money;

    @Override
    public IEconomy call() throws Exception {
        return new IEconomy();
    }
}
