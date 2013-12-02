package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;

/**
 * Represents the different types of Trees. This class supports all 6 TreeSpecies.
 */
public class Tree extends MaterialData {
    public Tree() {
        super(Material.SAPLING);
    }

    public Tree(TreeSpecies species) {
        this();
        setSpecies(species);
    }

    public Tree(TreeSpecies species, BlockFace dir) {
        this();
        setSpecies(species);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Tree(final int type) {
        super(type);
    }

    public Tree(final Material type) {
        super(type);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Tree(final int type, final byte data) {
        super(type, data);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Tree(final Material type, final byte data) {
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

    @Override
    public String toString() {
        return getSpecies() + " " + super.toString();
    }

    @Override
    public Tree clone() {
        return (Tree) super.clone();
    }
}
