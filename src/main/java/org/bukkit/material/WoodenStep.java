package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * Represents the different types of wooden steps.
 */
public class WoodenStep extends MaterialData {

    public WoodenStep() {
        super(Material.WOOD_STEP);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public WoodenStep(final int type) {
        super(type);
    }

    public WoodenStep(TreeSpecies species) {
        this();
        setSpecies(species);
    }

    public WoodenStep(TreeSpecies species, boolean inv) {
        this();
        setSpecies(species);
        setInverted(inv);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public WoodenStep(final int type, final byte data) {
        super(type, data);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public WoodenStep(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current species of this tree
     *
     * @return TreeSpecies of this tree
     */
    public TreeSpecies getSpecies() {
        switch(getData() & 0x7) {
        case 0:
            return TreeSpecies.GENERIC;
        case 1:
            return TreeSpecies.REDWOOD;
        case 2:
            return TreeSpecies.BIRCH;
        case 3:
            return TreeSpecies.JUNGLE;
        case 4:
            return TreeSpecies.ACACIA;
        case 5:
            return TreeSpecies.DARK_OAK;
        default:
            return null;
        }
    }

    /**
     * Sets the species of this tree
     *
     * @param species New species of this tree
     */
    public void setSpecies(TreeSpecies species) {
        switch(species) {
        case GENERIC:
            setData((byte) (getData() & 0x8 | 0));
            return;
        case REDWOOD:
            setData((byte) (getData() & 0x8 | 1));
            return;
        case BIRCH:
            setData((byte) (getData() & 0x8 | 2));
            return;
        case JUNGLE:
            setData((byte) (getData() & 0x8 | 3));
            return;
        case ACACIA:
            setData((byte) (getData() & 0x8 | 4));
            return;
        case DARK_OAK:
            setData((byte) (getData() & 0x8 | 5));
            return;
        default:
            return;
        }
    }

    /**
     * Test if step is inverted
     *
     * @return true if inverted (top half), false if normal (bottom half)
     */
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }
    
    /**
     * Set step inverted state
     *
     * @param inv - true if step is inverted (top half), false if step is normal (bottom half)
     */
    public void setInverted(boolean inv) {
        int dat = getData() & 0x7;
        if (inv) {
            dat |= 0x8;
        }
        setData((byte) dat);
    }
    
    @Override
    public WoodenStep clone() {
        return (WoodenStep) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + " " + getSpecies() + (isInverted()?" inverted":"");
    }
}
