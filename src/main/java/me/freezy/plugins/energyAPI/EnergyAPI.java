package me.freezy.plugins.energyAPI;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class for the EnergyAPI plugin.
 * This class extends JavaPlugin and overrides the onEnable and onDisable methods.
 */
public final class EnergyAPI extends JavaPlugin {
    /**
     * Logger instance for logging messages.
     */
    public static Logger LOG = LoggerFactory.getLogger(EnergyAPI.class);

    /**
     * List of startup messages to be logged when the plugin is enabled.
     */
    static List<String> startupMessages = List.of(
            "",
            " __________________________________",
            "|  _______  _______  _______  ___  |",
            "| |       ||   _   ||       ||   | |",
            "| |    ___||  |_|  ||    _  ||   | |",
            "| |   |___ |       ||   |_| ||   | |",
            "| |    ___||       ||    ___||   | |",
            "| |   |___ |   _   ||   |    |   | |",
            "| |_______||__| |__||___|    |___| |",
            "|                                  |",
            "|              By Freezy           |",
            "|     Made in Germany              |",
            "|__________________________________|",
            ""
    );

    /**
     * List of all EnergyItem instances.
     */
    private final List<EnergyItem> energyItems = new ArrayList<>();

    /**
     * Called when the plugin is enabled.
     * Logs the startup messages and additional information.
     */
    @Override
    public void onEnable() {
        for (String line : startupMessages) {
            LOG.info(line);
        }
        LOG.info("EnergyAPI is starting!");

        new BukkitRunnable() {
            @Override
            public void run() {
                updateEnergyItems();
            }
        }.runTaskTimerAsynchronously(this, 0, 20);

        LOG.info("EnergyAPI has been enabled!");
    }

    /**
     * Called when the plugin is disabled.
     * Logs a message indicating that the plugin has been disabled.
     */
    @Override
    public void onDisable() {
        LOG.info("EnergyAPI has been disabled!");
    }

    /**
     * Adds an EnergyItem to the list of energy items.
     *
     * @param item The EnergyItem to add.
     */
    public void addEnergyItem(EnergyItem item) {
        synchronized (energyItems) {
            energyItems.add(item);
        }
    }

    /**
     * Updates the energy of all EnergyItem instances.
     */
    private void updateEnergyItems() {
        synchronized (energyItems) {
            for (EnergyItem item : energyItems) {
                double currentEnergy = item.getEnergy();
                double maxEnergy = item.getMaxEnergy();
                short updateAmount = item.getUpdateAmount();

                if (currentEnergy < maxEnergy) {
                    item.setEnergy(Math.min(currentEnergy + updateAmount, maxEnergy));
                }

                // Display hotbar message to all players
                for (Player player : Bukkit.getOnlinePlayers()) {
                    ItemStack heldItem = player.getInventory().getItemInMainHand();
                    if (heldItem.equals(item)) {
                        String message = String.format("Energy: %.2f/%.2f", item.getEnergy(), item.getMaxEnergy());
                        Component component = MiniMessage.miniMessage().deserialize(message);
                        player.sendActionBar(component);
                    }
                }
            }
        }
    }
}