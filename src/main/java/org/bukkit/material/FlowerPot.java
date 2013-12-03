package org.bukkit.material;

import org.bukkit.FlowerSpecies;
import org.bukkit.GrassSpecies;
import org.bukkit.Material;
import org.bukkit.TreeSpecies;

/**
 * Represents a flower pot.
 */
public class FlowerPot extends MaterialData {

    /**
     * Default constructor for a flower pot.
     */
    public FlowerPot() {
        super(Material.FLOWER_POT);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public FlowerPot(final int type) {
        super(type);
    }

    public FlowerPot(final Material type) {
        super(type);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public FlowerPot(final int type, final byte data) {
        super(type, data);
    }

    /**
     *
     * @deprecated Magic value
     */
    @Deprecated
    public FlowerPot(final Material type, final byte data) {
        super(type, data);
    }

    /**
     * Get the material in the flower pot
     *
     * @return material MaterialData for the block currently in the flower pot or null if empty
     */
    public MaterialData getContents() {
        switch (getData()) {
            case 1:
                return new Flower(FlowerSpecies.POPPY);
            case 2:
                return new MaterialData(Material.YELLOW_FLOWER);
            case 3:
                return new Tree(TreeSpecies.GENERIC);
            case 4:
                return new Tree(TreeSpecies.REDWOOD);
            case 5:
                return new Tree(TreeSpecies.BIRCH);
            case 6:
                return new Tree(TreeSpecies.JUNGLE);
            case 7:
                return new MaterialData(Material.RED_MUSHROOM);
            case 8:
                return new MaterialData(Material.BROWN_MUSHROOM);
            case 9:
                return new MaterialData(Material.CACTUS);
            case 10:
                return new MaterialData(Material.DEAD_BUSH);
            case 11:
                return new LongGrass(GrassSpecies.FERN_LIKE);
            case 12:
                return new Tree(TreeSpecies.ACACIA);
            case 13:
                return new Tree(TreeSpecies.DARK_OAK);
            default:
                return null;
        }
    }

    /**
     * Set the contents of the flower pot
     *
     * @param materialData MaterialData of the block to put in the flower pot.
     */
    public void setContents(MaterialData materialData) {
        Material mat = materialData.getItemType();

        if (mat == Material.RED_ROSE) {
            FlowerSpecies species = ((Flower) materialData).getSpecies();

            if (species == FlowerSpecies.POPPY) {
                setData((byte) 1);
            }
        } else if (mat == Material.YELLOW_FLOWER) {
            setData((byte) 2);
        } else if (mat == Material.RED_MUSHROOM) {
            setData((byte) 7);
        } else if (mat == Material.BROWN_MUSHROOM) {
            setData((byte) 8);
        } else if (mat == Material.CACTUS) {
            setData((byte) 9);
        } else if (mat == Material.DEAD_BUSH) {
            setData((byte) 10);
        } else if (mat == Material.SAPLING) {
            TreeSpecies species = ((Tree) materialData).getSpecies();

            if (species == TreeSpecies.GENERIC) {
                setData((byte) 3);
            } else if (species == TreeSpecies.REDWOOD) {
                setData((byte) 4);
            } else if (species == TreeSpecies.BIRCH) {
                setData((byte) 5);
            } else if (species == TreeSpecies.JUNGLE) {
                setData((byte) 6);
            } else if (species == TreeSpecies.ACACIA) {
                setData((byte) 12);
            } else if (species == TreeSpecies.DARK_OAK) {
                setData((byte) 13);
            }
        } else if (mat == Material.LONG_GRASS) {
            GrassSpecies species = ((LongGrass) materialData).getSpecies();

            if (species == GrassSpecies.FERN_LIKE) {
                setData((byte) 11);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + " containing " + getContents();
    }

    @Override
    public FlowerPot clone() {
        return (FlowerPot) super.clone();
    }
}
