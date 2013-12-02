package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.RawFishType;

public class RawFish extends MaterialData {
    public RawFish() {
        super(Material.RAW_FISH);
    }

    public RawFish(RawFishType type) {
        this();
        setType(type);
    }

    /**
    *
    * @deprecated Magic value
    */
   @Deprecated
   public RawFish(final int type) {
       super(type);
   }

   public RawFish(final Material type) {
       super(type);
   }

   /**
    *
    * @deprecated Magic value
    */
   @Deprecated
   public RawFish(final int type, final byte data) {
       super(type, data);
   }

   /**
    *
    * @deprecated Magic value
    */
   @Deprecated
   public RawFish(final Material type, final byte data) {
       super(type, data);
   }

   /**
    * Gets the current type of this raw fish
    *
    * @return RawFishType of this fish
    */
   public RawFishType getType() {
       switch (getData()) {
           case 0x0:
               return RawFishType.RAW_FISH;
           case 0x1:
               return RawFishType.RAW_SALMON;
           case 0x2:
               return RawFishType.CLOWNFISH;
           case 0x3:
               return RawFishType.PUFFERFISH;
           default:
               return null;
       }
   }

   /**
    * Sets the type of this raw fish
    *
    * @param type New type of this fish
    */
   public void setType(RawFishType type) {
       switch (type) {
           case RAW_FISH:
               setData((byte) 0x0);
               return;
           case RAW_SALMON:
               setData((byte) 0x1);
               return;
           case CLOWNFISH:
               setData((byte) 0x2);
               return;
           case PUFFERFISH:
               setData((byte) 0x3);
               return;
       }
   }

   @Override
   public String toString() {
       return getType() + " " + super.toString();
   }

   @Override
   public RawFish clone() {
       return (RawFish) super.clone();
   }
}
