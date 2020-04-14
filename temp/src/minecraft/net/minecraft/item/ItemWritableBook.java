package net.minecraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemWritableBook extends Item {
   public ItemWritableBook() {
      this.func_77625_d(1);
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.func_71048_c(p_77659_1_);
      p_77659_3_.func_71029_a(StatList.field_75929_E[Item.func_150891_b(this)]);
      return p_77659_1_;
   }

   public static boolean func_150930_a(NBTTagCompound p_150930_0_) {
      if (p_150930_0_ == null) {
         return false;
      } else if (!p_150930_0_.func_150297_b("pages", 9)) {
         return false;
      } else {
         NBTTagList lvt_1_1_ = p_150930_0_.func_150295_c("pages", 8);

         for(int lvt_2_1_ = 0; lvt_2_1_ < lvt_1_1_.func_74745_c(); ++lvt_2_1_) {
            String lvt_3_1_ = lvt_1_1_.func_150307_f(lvt_2_1_);
            if (lvt_3_1_ == null) {
               return false;
            }

            if (lvt_3_1_.length() > 32767) {
               return false;
            }
         }

         return true;
      }
   }
}
