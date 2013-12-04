package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;

/**
 * Represents the different types of Trees.
 */
public class Tree extends Rotateable {
    public Tree() {
        super(Material.LOG);
    }

    public Tree(TreeSpecies species) {
        this();
        setSpecies(species);
    }

    public Tree(TreeSpecies species, BlockFace dir) {
        this();
        setSpecies(species);
        setFacingDirection(dir);
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
     * Sets the species of this tree
     *
     * @param species New species of this tree
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

    /**
     * Get direction of the log
     *
     * @return BlockFace.TOP for upright (default), BlockFace.NORTH (east-west), BlockFace.WEST (north-sout), BlockFace.SELF (directionless)
     * @deprecated use getFacing() from {@link Directional} instead
     */
    @Deprecated
    public BlockFace getDirection() {
        return getFacing();
    }

    /**
     * Set direction of the log
     *
     * @param dir - direction of end of log (BlockFace.SELF for no direction)
     * @deprecated use setFacingDirection() from {@link Directional} instead
     */
    @Deprecated
    public void setDirection(BlockFace dir) {
        setFacingDirection(dir);
    }

    @Override
    public String toString() {
        return getSpecies() + " " + getFacing() + " " + super.toString();
    }

    @Override
    public Tree clone() {
        return (Tree) super.clone();
    }
}
