package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;

/**
 * Represents the different types of Logs. This class only supports ACACIA/DARK_OAK Species.
 */
public class Log2 extends Log {
    public Log2() {
        super(Material.LOG_2);
    }

    public Log2(TreeSpecies species) {
        this();
        setSpecies(species);
    }

    public Log2(TreeSpecies species, BlockFace dir) {
        this();
        setSpecies(species);
        setFacingDirection(dir);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Log2(final int type) {
        super(type);
    }

    public Log2(final Material type) {
        super(type);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Log2(final int type, final byte data) {
        super(type, data);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Log2(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current species of this tree
     *
     * @return TreeSpecies of this tree
     */
    @Override
    public TreeSpecies getSpecies() {
        switch(getData() & 0x3) {
        case 0:
            return TreeSpecies.ACACIA;
        case 1:
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
    @Override
    public void setSpecies(TreeSpecies species) {
        switch(species) {
        case ACACIA:
            setData((byte) (getData() & 0xC | 0));
            return;
        case DARK_OAK:
            setData((byte) (getData() & 0xC | 1));
            return;
        default:
            return;
        }
    }

    @Override
    public String toString() {
        return getSpecies() + " " + getFacing() + " " + super.toString();
    }

    @Override
    public Log2 clone() {
        return (Log2) super.clone();
    }
}
