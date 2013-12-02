package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.block.BlockFace;

/**
 * Represents the different types of Logs. This class only supports GENERIC/REDWOOD/BIRCH/JUNGLE Species.
 */
public class Log extends Rotateable {
    public Log() {
        super(Material.LOG);
    }

    public Log(TreeSpecies species) {
        this();
        setSpecies(species);
    }

    public Log(TreeSpecies species, BlockFace dir) {
        this();
        setSpecies(species);
        setFacingDirection(dir);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Log(final int type) {
        super(type);
    }

    public Log(final Material type) {
        super(type);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Log(final int type, final byte data) {
        super(type, data);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public Log(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current species of this tree
     *
     * @return TreeSpecies of this tree
     */
    public TreeSpecies getSpecies() {
        return TreeSpecies.getByData((byte) (getData() & 0x3));
    }

    /**
     * Sets the species of this tree
     *
     * @param species New species of this tree
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

    /**
     * Get direction of the log
     *
     * @return BlockFace.TOP for upright (default), BlockFace.NORTH (east-west), BlockFace.WEST (north-south), BlockFace.SELF (directionless)
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
    public Log clone() {
        return (Log) super.clone();
    }
}
