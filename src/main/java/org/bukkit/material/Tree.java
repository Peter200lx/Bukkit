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
        return TreeSpecies.getByData((byte) (getData() & 0x7));
    }

    /**
     * Sets the species of this tree
     *
     * @param species New species of this tree
     */
    public void setSpecies(TreeSpecies species) {
        setData((byte) ((getData() & 0xC) | species.getData()));
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
