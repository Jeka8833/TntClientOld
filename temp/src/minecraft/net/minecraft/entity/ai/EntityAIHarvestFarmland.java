package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityAIHarvestFarmland extends EntityAIMoveToBlock {
   private final EntityVillager field_179504_c;
   private boolean field_179502_d;
   private boolean field_179503_e;
   private int field_179501_f;

   public EntityAIHarvestFarmland(EntityVillager p_i45889_1_, double p_i45889_2_) {
      super(p_i45889_1_, p_i45889_2_, 16);
      this.field_179504_c = p_i45889_1_;
   }

   public boolean func_75250_a() {
      if (this.field_179496_a <= 0) {
         if (!this.field_179504_c.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
            return false;
         }

         this.field_179501_f = -1;
         this.field_179502_d = this.field_179504_c.func_175556_cs();
         this.field_179503_e = this.field_179504_c.func_175557_cr();
      }

      return super.func_75250_a();
   }

   public boolean func_75253_b() {
      return this.field_179501_f >= 0 && super.func_75253_b();
   }

   public void func_75249_e() {
      super.func_75249_e();
   }

   public void func_75251_c() {
      super.func_75251_c();
   }

   public void func_75246_d() {
      super.func_75246_d();
      this.field_179504_c.func_70671_ap().func_75650_a((double)this.field_179494_b.func_177958_n() + 0.5D, (double)(this.field_179494_b.func_177956_o() + 1), (double)this.field_179494_b.func_177952_p() + 0.5D, 10.0F, (float)this.field_179504_c.func_70646_bf());
      if (this.func_179487_f()) {
         World lvt_1_1_ = this.field_179504_c.field_70170_p;
         BlockPos lvt_2_1_ = this.field_179494_b.func_177984_a();
         IBlockState lvt_3_1_ = lvt_1_1_.func_180495_p(lvt_2_1_);
         Block lvt_4_1_ = lvt_3_1_.func_177230_c();
         if (this.field_179501_f == 0 && lvt_4_1_ instanceof BlockCrops && (Integer)lvt_3_1_.func_177229_b(BlockCrops.field_176488_a) == 7) {
            lvt_1_1_.func_175655_b(lvt_2_1_, true);
         } else if (this.field_179501_f == 1 && lvt_4_1_ == Blocks.field_150350_a) {
            InventoryBasic lvt_5_1_ = this.field_179504_c.func_175551_co();

            for(int lvt_6_1_ = 0; lvt_6_1_ < lvt_5_1_.func_70302_i_(); ++lvt_6_1_) {
               ItemStack lvt_7_1_ = lvt_5_1_.func_70301_a(lvt_6_1_);
               boolean lvt_8_1_ = false;
               if (lvt_7_1_ != null) {
                  if (lvt_7_1_.func_77973_b() == Items.field_151014_N) {
                     lvt_1_1_.func_180501_a(lvt_2_1_, Blocks.field_150464_aj.func_176223_P(), 3);
                     lvt_8_1_ = true;
                  } else if (lvt_7_1_.func_77973_b() == Items.field_151174_bG) {
                     lvt_1_1_.func_180501_a(lvt_2_1_, Blocks.field_150469_bN.func_176223_P(), 3);
                     lvt_8_1_ = true;
                  } else if (lvt_7_1_.func_77973_b() == Items.field_151172_bF) {
                     lvt_1_1_.func_180501_a(lvt_2_1_, Blocks.field_150459_bM.func_176223_P(), 3);
                     lvt_8_1_ = true;
                  }
               }

               if (lvt_8_1_) {
                  --lvt_7_1_.field_77994_a;
                  if (lvt_7_1_.field_77994_a <= 0) {
                     lvt_5_1_.func_70299_a(lvt_6_1_, (ItemStack)null);
                  }
                  break;
               }
            }
         }

         this.field_179501_f = -1;
         this.field_179496_a = 10;
      }

   }

   protected boolean func_179488_a(World p_179488_1_, BlockPos p_179488_2_) {
      Block lvt_3_1_ = p_179488_1_.func_180495_p(p_179488_2_).func_177230_c();
      if (lvt_3_1_ == Blocks.field_150458_ak) {
         p_179488_2_ = p_179488_2_.func_177984_a();
         IBlockState lvt_4_1_ = p_179488_1_.func_180495_p(p_179488_2_);
         lvt_3_1_ = lvt_4_1_.func_177230_c();
         if (lvt_3_1_ instanceof BlockCrops && (Integer)lvt_4_1_.func_177229_b(BlockCrops.field_176488_a) == 7 && this.field_179503_e && (this.field_179501_f == 0 || this.field_179501_f < 0)) {
            this.field_179501_f = 0;
            return true;
         }

         if (lvt_3_1_ == Blocks.field_150350_a && this.field_179502_d && (this.field_179501_f == 1 || this.field_179501_f < 0)) {
            this.field_179501_f = 1;
            return true;
         }
      }

      return false;
   }
}