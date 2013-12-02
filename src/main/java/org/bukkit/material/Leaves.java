package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * Represents the different types of leaves. This class only supports GENERIC/REDWOOD/BIRCH/JUNGLE Species.
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
     * Gets the current species of this leaf
     *
     * @return TreeSpecies of this leaf
     */
    public TreeSpecies getSpecies() {
        return TreeSpecies.getByData((byte) (getData() & 0x3));
    }

    /**
     * Sets the species of this leaf
     *
     * @param species New species of this leaf
     */
    public void setSpecies(TreeSpecies species) {
        switch (species) {
        case GENERIC:
        case REDWOOD:
        case BIRCH:
        case JUNGLE:
            setData((byte) ((getData() & 0xC) | (species.getData() & 0x3)));
            break;
        default:
            throw new IllegalArgumentException("TreeSpecies " + species + " is not supported by " + getItemType());
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
