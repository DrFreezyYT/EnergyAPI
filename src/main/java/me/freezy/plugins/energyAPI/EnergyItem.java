package me.freezy.plugins.energyAPI;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Represents an item with energy properties in a Minecraft plugin.
 * Extends the ItemStack class to include energy and max energy values.
 */
public class EnergyItem extends ItemStack {
    private final NamespacedKey energyKey;
    private final NamespacedKey maxEnergyKey;
    private final NamespacedKey updateAmountKey;

    /**
     * Constructs an EnergyItem with specified energy, max energy, material, and amount.
     *
     * @param energy    The current energy value of the item.
     * @param maxEnergy The maximum energy value of the item.
     * @param updateAmount The amount of energy to update.
     * @param material  The material type of the item.
     * @param amount    The amount of items in the stack.
     */
    public EnergyItem(double energy, double maxEnergy, short updateAmount, Material material, int amount) {
        super(material, amount);

        Plugin plugin = JavaPlugin.getPlugin(EnergyAPI.class);
        this.energyKey = new NamespacedKey(plugin, "current_energy");
        this.maxEnergyKey = new NamespacedKey(plugin, "max_energy");
        this.updateAmountKey = new NamespacedKey(plugin, "energy_update_amount");

        PersistentDataContainer container = this.getItemMeta().getPersistentDataContainer();
        container.set(energyKey, PersistentDataType.DOUBLE, energy);
        container.set(maxEnergyKey, PersistentDataType.DOUBLE, maxEnergy);
        container.set(updateAmountKey, PersistentDataType.SHORT, updateAmount);

        this.setItemMeta(this.getItemMeta());

        // Register this item with the EnergyAPI plugin
        ((EnergyAPI) plugin).addEnergyItem(this);
    }

    /**
     * Gets the current energy value of the item.
     *
     * @return The current energy value.
     */
    public double getEnergy() {
        PersistentDataContainer container = this.getItemMeta().getPersistentDataContainer();
        return container.getOrDefault(energyKey, PersistentDataType.DOUBLE, 0.0);
    }

    /**
     * Sets the current energy value of the item.
     *
     * @param energy The new energy value to set.
     */
    public void setEnergy(double energy) {
        PersistentDataContainer container = this.getItemMeta().getPersistentDataContainer();
        container.set(energyKey, PersistentDataType.DOUBLE, energy);
        this.setItemMeta(this.getItemMeta());
    }

    /**
     * Gets the maximum energy value of the item.
     *
     * @return The maximum energy value.
     */
    public double getMaxEnergy() {
        PersistentDataContainer container = this.getItemMeta().getPersistentDataContainer();
        return container.getOrDefault(maxEnergyKey, PersistentDataType.DOUBLE, 0.0);
    }

    /**
     * Sets the maximum energy value of the item.
     *
     * @param maxEnergy The new maximum energy value to set.
     */
    public void setMaxEnergy(double maxEnergy) {
        PersistentDataContainer container = this.getItemMeta().getPersistentDataContainer();
        container.set(maxEnergyKey, PersistentDataType.DOUBLE, maxEnergy);
        this.setItemMeta(this.getItemMeta());
    }

    /**
     * Gets the amount of energy to update.
     *
     * @return The amount of energy to update.
     */
    public short getUpdateAmount() {
        PersistentDataContainer container = this.getItemMeta().getPersistentDataContainer();
        return container.getOrDefault(updateAmountKey, PersistentDataType.SHORT, (short) 0);
    }

    /**
     * Sets the amount of energy to update.
     *
     * @param updateAmount The new amount of energy to update.
     */
    public void setUpdateAmount(short updateAmount) {
        PersistentDataContainer container = this.getItemMeta().getPersistentDataContainer();
        container.set(updateAmountKey, PersistentDataType.SHORT, updateAmount);
        this.setItemMeta(this.getItemMeta());
    }


}