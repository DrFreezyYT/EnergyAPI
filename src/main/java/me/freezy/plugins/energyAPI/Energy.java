package me.freezy.plugins.energyAPI;

/**
 * The Energy class represents an energy system with a current energy level and a maximum energy capacity.
 */
public class Energy {
    private double energy;
    private double maxEnergy;
    private short updateAmount;

    /**
     * Constructs an Energy object with the specified initial energy and maximum energy.
     *
     * @param energy the initial amount of energy
     * @param maxEnergy the maximum amount of energy
     * @param updateAmount the amount of energy to update
     */
    public Energy(double energy, double maxEnergy, short updateAmount) {
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.updateAmount = updateAmount;
    }

    /**
     * Returns the current amount of energy.
     *
     * @return the current energy
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Returns the maximum amount of energy.
     *
     * @return the maximum energy
     */
    public double getMaxEnergy() {
        return maxEnergy;
    }

    /**
     * Sets the current amount of energy.
     *
     * @param energy the new amount of energy
     */
    public void setEnergy(double energy) {
        this.energy = energy;
    }

    /**
     * Sets the maximum amount of energy.
     *
     * @param maxEnergy the new maximum amount of energy
     */
    public void setMaxEnergy(double maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    /**
     * Returns the amount of energy to update.
     *
     * @return the amount of energy to update
     */
    public short getUpdateAmount() {
        return updateAmount;
    }

    /**
     * Sets the amount of energy to update.
     *
     * @param updateAmount the new amount of energy to update
     */
    public void setUpdateAmount(short updateAmount) {
        this.updateAmount = updateAmount;
    }
}