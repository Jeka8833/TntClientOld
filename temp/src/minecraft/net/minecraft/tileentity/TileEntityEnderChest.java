package net.minecraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ITickable;

public class TileEntityEnderChest extends TileEntity implements ITickable {
   public float field_145972_a;
   public float field_145975_i;
   public int field_145973_j;
   private int field_145974_k;

   public void func_73660_a() {
      if (++this.field_145974_k % 20 * 4 == 0) {
         this.field_145850_b.func_175641_c(this.field_174879_c, Blocks.field_150477_bB, 1, this.field_145973_j);
      }

      this.field_145975_i = this.field_145972_a;
      int lvt_1_1_ = this.field_174879_c.func_177958_n();
      int lvt_2_1_ = this.field_174879_c.func_177956_o();
      int lvt_3_1_ = this.field_174879_c.func_177952_p();
      float lvt_4_1_ = 0.1F;
      double lvt_7_2_;
      if (this.field_145973_j > 0 && this.field_145972_a == 0.0F) {
         double lvt_5_1_ = (double)lvt_1_1_ + 0.5D;
         lvt_7_2_ = (double)lvt_3_1_ + 0.5D;
         this.field_145850_b.func_72908_a(lvt_5_1_, (double)lvt_2_1_ + 0.5D, lvt_7_2_, "random.chestopen", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
      }

      if (this.field_145973_j == 0 && this.field_145972_a > 0.0F || this.field_145973_j > 0 && this.field_145972_a < 1.0F) {
         float lvt_5_2_ = this.field_145972_a;
         if (this.field_145973_j > 0) {
            this.field_145972_a += lvt_4_1_;
         } else {
            this.field_145972_a -= lvt_4_1_;
         }

         if (this.field_145972_a > 1.0F) {
            this.field_145972_a = 1.0F;
         }

         float lvt_6_1_ = 0.5F;
         if (this.field_145972_a < lvt_6_1_ && lvt_5_2_ >= lvt_6_1_) {
            lvt_7_2_ = (double)lvt_1_1_ + 0.5D;
            double lvt_9_1_ = (double)lvt_3_1_ + 0.5D;
            this.field_145850_b.func_72908_a(lvt_7_2_, (double)lvt_2_1_ + 0.5D, lvt_9_1_, "random.chestclosed", 0.5F, this.field_145850_b.field_73012_v.nextFloat() * 0.1F + 0.9F);
         }

         if (this.field_145972_a < 0.0F) {
            this.field_145972_a = 0.0F;
         }
      }

   }

   public boolean func_145842_c(int p_145842_1_, int p_145842_2_) {
      if (p_145842_1_ == 1) {
         this.field_145973_j = p_145842_2_;
         return true;
      } else {
         return super.func_145842_c(p_145842_1_, p_145842_2_);
      }
   }

   public void func_145843_s() {
      this.func_145836_u();
      super.func_145843_s();
   }

   public void func_145969_a() {
      ++this.field_145973_j;
      this.field_145850_b.func_175641_c(this.field_174879_c, Blocks.field_150477_bB, 1, this.field_145973_j);
   }

   public void func_145970_b() {
      --this.field_145973_j;
      this.field_145850_b.func_175641_c(this.field_174879_c, Blocks.field_150477_bB, 1, this.field_145973_j);
   }

   public boolean func_145971_a(EntityPlayer p_145971_1_) {
      if (this.field_145850_b.func_175625_s(this.field_174879_c) != this) {
         return false;
      } else {
         return p_145971_1_.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5D, (double)this.field_174879_c.func_177956_o() + 0.5D, (double)this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D;
      }
   }
}
