package net.minecraft.entity.item;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityFallingBlock extends Entity {
   private IBlockState field_175132_d;
   public int field_145812_b;
   public boolean field_145813_c = true;
   private boolean field_145808_f;
   private boolean field_145809_g;
   private int field_145815_h = 40;
   private float field_145816_i = 2.0F;
   public NBTTagCompound field_145810_d;

   public EntityFallingBlock(World p_i1706_1_) {
      super(p_i1706_1_);
   }

   public EntityFallingBlock(World p_i45848_1_, double p_i45848_2_, double p_i45848_4_, double p_i45848_6_, IBlockState p_i45848_8_) {
      super(p_i45848_1_);
      this.field_175132_d = p_i45848_8_;
      this.field_70156_m = true;
      this.func_70105_a(0.98F, 0.98F);
      this.func_70107_b(p_i45848_2_, p_i45848_4_, p_i45848_6_);
      this.field_70159_w = 0.0D;
      this.field_70181_x = 0.0D;
      this.field_70179_y = 0.0D;
      this.field_70169_q = p_i45848_2_;
      this.field_70167_r = p_i45848_4_;
      this.field_70166_s = p_i45848_6_;
   }

   protected boolean func_70041_e_() {
      return false;
   }

   protected void func_70088_a() {
   }

   public boolean func_70067_L() {
      return !this.field_70128_L;
   }

   public void func_70071_h_() {
      Block lvt_1_1_ = this.field_175132_d.func_177230_c();
      if (lvt_1_1_.func_149688_o() == Material.field_151579_a) {
         this.func_70106_y();
      } else {
         this.field_70169_q = this.field_70165_t;
         this.field_70167_r = this.field_70163_u;
         this.field_70166_s = this.field_70161_v;
         BlockPos lvt_2_2_;
         if (this.field_145812_b++ == 0) {
            lvt_2_2_ = new BlockPos(this);
            if (this.field_70170_p.func_180495_p(lvt_2_2_).func_177230_c() == lvt_1_1_) {
               this.field_70170_p.func_175698_g(lvt_2_2_);
            } else if (!this.field_70170_p.field_72995_K) {
               this.func_70106_y();
               return;
            }
         }

         this.field_70181_x -= 0.03999999910593033D;
         this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
         this.field_70159_w *= 0.9800000190734863D;
         this.field_70181_x *= 0.9800000190734863D;
         this.field_70179_y *= 0.9800000190734863D;
         if (!this.field_70170_p.field_72995_K) {
            lvt_2_2_ = new BlockPos(this);
            if (this.field_70122_E) {
               this.field_70159_w *= 0.699999988079071D;
               this.field_70179_y *= 0.699999988079071D;
               this.field_70181_x *= -0.5D;
               if (this.field_70170_p.func_180495_p(lvt_2_2_).func_177230_c() != Blocks.field_180384_M) {
                  this.func_70106_y();
                  if (!this.field_145808_f) {
                     if (this.field_70170_p.func_175716_a(lvt_1_1_, lvt_2_2_, true, EnumFacing.UP, (Entity)null, (ItemStack)null) && !BlockFalling.func_180685_d(this.field_70170_p, lvt_2_2_.func_177977_b()) && this.field_70170_p.func_180501_a(lvt_2_2_, this.field_175132_d, 3)) {
                        if (lvt_1_1_ instanceof BlockFalling) {
                           ((BlockFalling)lvt_1_1_).func_176502_a_(this.field_70170_p, lvt_2_2_);
                        }

                        if (this.field_145810_d != null && lvt_1_1_ instanceof ITileEntityProvider) {
                           TileEntity lvt_3_1_ = this.field_70170_p.func_175625_s(lvt_2_2_);
                           if (lvt_3_1_ != null) {
                              NBTTagCompound lvt_4_1_ = new NBTTagCompound();
                              lvt_3_1_.func_145841_b(lvt_4_1_);
                              Iterator lvt_5_1_ = this.field_145810_d.func_150296_c().iterator();

                              while(lvt_5_1_.hasNext()) {
                                 String lvt_6_1_ = (String)lvt_5_1_.next();
                                 NBTBase lvt_7_1_ = this.field_145810_d.func_74781_a(lvt_6_1_);
                                 if (!lvt_6_1_.equals("x") && !lvt_6_1_.equals("y") && !lvt_6_1_.equals("z")) {
                                    lvt_4_1_.func_74782_a(lvt_6_1_, lvt_7_1_.func_74737_b());
                                 }
                              }

                              lvt_3_1_.func_145839_a(lvt_4_1_);
                              lvt_3_1_.func_70296_d();
                           }
                        }
                     } else if (this.field_145813_c && this.field_70170_p.func_82736_K().func_82766_b("doEntityDrops")) {
                        this.func_70099_a(new ItemStack(lvt_1_1_, 1, lvt_1_1_.func_180651_a(this.field_175132_d)), 0.0F);
                     }
                  }
               }
            } else if (this.field_145812_b > 100 && !this.field_70170_p.field_72995_K && (lvt_2_2_.func_177956_o() < 1 || lvt_2_2_.func_177956_o() > 256) || this.field_145812_b > 600) {
               if (this.field_145813_c && this.field_70170_p.func_82736_K().func_82766_b("doEntityDrops")) {
                  this.func_70099_a(new ItemStack(lvt_1_1_, 1, lvt_1_1_.func_180651_a(this.field_175132_d)), 0.0F);
               }

               this.func_70106_y();
            }
         }

      }
   }

   public void func_180430_e(float p_180430_1_, float p_180430_2_) {
      Block lvt_3_1_ = this.field_175132_d.func_177230_c();
      if (this.field_145809_g) {
         int lvt_4_1_ = MathHelper.func_76123_f(p_180430_1_ - 1.0F);
         if (lvt_4_1_ > 0) {
            List<Entity> lvt_5_1_ = Lists.newArrayList((Iterable)this.field_70170_p.func_72839_b(this, this.func_174813_aQ()));
            boolean lvt_6_1_ = lvt_3_1_ == Blocks.field_150467_bQ;
            DamageSource lvt_7_1_ = lvt_6_1_ ? DamageSource.field_82728_o : DamageSource.field_82729_p;
            Iterator lvt_8_1_ = lvt_5_1_.iterator();

            while(lvt_8_1_.hasNext()) {
               Entity lvt_9_1_ = (Entity)lvt_8_1_.next();
               lvt_9_1_.func_70097_a(lvt_7_1_, (float)Math.min(MathHelper.func_76141_d((float)lvt_4_1_ * this.field_145816_i), this.field_145815_h));
            }

            if (lvt_6_1_ && (double)this.field_70146_Z.nextFloat() < 0.05000000074505806D + (double)lvt_4_1_ * 0.05D) {
               int lvt_8_2_ = (Integer)this.field_175132_d.func_177229_b(BlockAnvil.field_176505_b);
               ++lvt_8_2_;
               if (lvt_8_2_ > 2) {
                  this.field_145808_f = true;
               } else {
                  this.field_175132_d = this.field_175132_d.func_177226_a(BlockAnvil.field_176505_b, lvt_8_2_);
               }
            }
         }
      }

   }

   protected void func_70014_b(NBTTagCompound p_70014_1_) {
      Block lvt_2_1_ = this.field_175132_d != null ? this.field_175132_d.func_177230_c() : Blocks.field_150350_a;
      ResourceLocation lvt_3_1_ = (ResourceLocation)Block.field_149771_c.func_177774_c(lvt_2_1_);
      p_70014_1_.func_74778_a("Block", lvt_3_1_ == null ? "" : lvt_3_1_.toString());
      p_70014_1_.func_74774_a("Data", (byte)lvt_2_1_.func_176201_c(this.field_175132_d));
      p_70014_1_.func_74774_a("Time", (byte)this.field_145812_b);
      p_70014_1_.func_74757_a("DropItem", this.field_145813_c);
      p_70014_1_.func_74757_a("HurtEntities", this.field_145809_g);
      p_70014_1_.func_74776_a("FallHurtAmount", this.field_145816_i);
      p_70014_1_.func_74768_a("FallHurtMax", this.field_145815_h);
      if (this.field_145810_d != null) {
         p_70014_1_.func_74782_a("TileEntityData", this.field_145810_d);
      }

   }

   protected void func_70037_a(NBTTagCompound p_70037_1_) {
      int lvt_2_1_ = p_70037_1_.func_74771_c("Data") & 255;
      if (p_70037_1_.func_150297_b("Block", 8)) {
         this.field_175132_d = Block.func_149684_b(p_70037_1_.func_74779_i("Block")).func_176203_a(lvt_2_1_);
      } else if (p_70037_1_.func_150297_b("TileID", 99)) {
         this.field_175132_d = Block.func_149729_e(p_70037_1_.func_74762_e("TileID")).func_176203_a(lvt_2_1_);
      } else {
         this.field_175132_d = Block.func_149729_e(p_70037_1_.func_74771_c("Tile") & 255).func_176203_a(lvt_2_1_);
      }

      this.field_145812_b = p_70037_1_.func_74771_c("Time") & 255;
      Block lvt_3_1_ = this.field_175132_d.func_177230_c();
      if (p_70037_1_.func_150297_b("HurtEntities", 99)) {
         this.field_145809_g = p_70037_1_.func_74767_n("HurtEntities");
         this.field_145816_i = p_70037_1_.func_74760_g("FallHurtAmount");
         this.field_145815_h = p_70037_1_.func_74762_e("FallHurtMax");
      } else if (lvt_3_1_ == Blocks.field_150467_bQ) {
         this.field_145809_g = true;
      }

      if (p_70037_1_.func_150297_b("DropItem", 99)) {
         this.field_145813_c = p_70037_1_.func_74767_n("DropItem");
      }

      if (p_70037_1_.func_150297_b("TileEntityData", 10)) {
         this.field_145810_d = p_70037_1_.func_74775_l("TileEntityData");
      }

      if (lvt_3_1_ == null || lvt_3_1_.func_149688_o() == Material.field_151579_a) {
         this.field_175132_d = Blocks.field_150354_m.func_176223_P();
      }

   }

   public World func_145807_e() {
      return this.field_70170_p;
   }

   public void func_145806_a(boolean p_145806_1_) {
      this.field_145809_g = p_145806_1_;
   }

   public boolean func_90999_ad() {
      return false;
   }

   public void func_85029_a(CrashReportCategory p_85029_1_) {
      super.func_85029_a(p_85029_1_);
      if (this.field_175132_d != null) {
         Block lvt_2_1_ = this.field_175132_d.func_177230_c();
         p_85029_1_.func_71507_a("Immitating block ID", Block.func_149682_b(lvt_2_1_));
         p_85029_1_.func_71507_a("Immitating block data", lvt_2_1_.func_176201_c(this.field_175132_d));
      }

   }

   public IBlockState func_175131_l() {
      return this.field_175132_d;
   }
}
