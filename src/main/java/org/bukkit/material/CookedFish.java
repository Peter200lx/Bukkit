package org.bukkit.material;

import org.bukkit.Material;
import org.bukkit.CookedFishType;

public class CookedFish extends MaterialData {
    public CookedFish() {
        super(Material.COOKED_FISH);
    }

    public CookedFish(CookedFishType type) {
        this();
        setType(type);
    }

    /**
    *
    * @deprecated Magic value
    */
   @Deprecated
   public CookedFish(final int type) {
       super(type);
   }

   public CookedFish(final Material type) {
       super(type);
   }

   /**
    *
    * @deprecated Magic value
    */
   @Deprecated
   public CookedFish(final int type, final byte data) {
       super(type, data);
   }

   /**
    *
    * @deprecated Magic value
    */
   @Deprecated
   public CookedFish(final Material type, final byte data) {
       super(type, data);
   }

   /**
    * Gets the current type of this CookedFish
    *
    * @return CookedFishType of this CookedFish
    */
   public CookedFishType getType() {
       switch (getData()) {
           case 0x0:
               return CookedFishType.COOKED_FISH;
           case 0x1:
               return CookedFishType.COOKED_SALMON;
           default:
               return null;
       }
   }

   /**
    * Sets the type of this CookedFish
    *
    * @param type New type of this CookedFish
    */
   public void setType(CookedFishType type) {
       switch (type) {
           case COOKED_FISH:
               setData((byte) 0x0);
               return;
           case COOKED_SALMON:
               setData((byte) 0x1);
               return;
       }
   }

   @Override
   public String toString() {
       return getType() + " " + super.toString();
   }

   @Override
   public CookedFish clone() {
       return (CookedFish) super.clone();
   }
}
