package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * Represents the different types of leaves.
 */
public class Leaves extends MaterialData {
    public Leaves() {
        super(Material.LEAVES);
    }

    public Leaves(TreeSpecies species) {
        this();
        setSpecies(species);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Leaves(final int type) {
        super(type);
    }

    public Leaves(final Material type) {
        super(type);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Leaves(final int type, final byte data) {
        super(type, data);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Leaves(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current species of this leave
     *
     * @return TreeSpecies of this leave
     */
    public TreeSpecies getSpecies() {
        switch(getData() & 0x3) {
        case 0:
            return TreeSpecies.GENERIC;
        case 1:
            return TreeSpecies.REDWOOD;
        case 2:
            return TreeSpecies.BIRCH;
        case 3:
            return TreeSpecies.JUNGLE;
        default:
            return null;
        }
    }

    /**
     * Sets the species of this leave
     *
     * @param species New species of this leave
     */
    public void setSpecies(TreeSpecies species) {
        switch(species) {
        case GENERIC:
            setData((byte) (getData() & 0xC | 0));
            return;
        case REDWOOD:
            setData((byte) (getData() & 0xC | 1));
            return;
        case BIRCH:
            setData((byte) (getData() & 0xC | 2));
            return;
        case JUNGLE:
            setData((byte) (getData() & 0xC | 3));
            return;
        default:
            return;
        }
    }

    @Override
    public String toString() {
        return getSpecies() + " " + super.toString();
    }

    @Override
    public Leaves clone() {
        return (Leaves) super.clone();
    }
}
