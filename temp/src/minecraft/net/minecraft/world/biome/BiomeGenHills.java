package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenHills extends BiomeGenBase {
   private WorldGenerator field_82915_S;
   private WorldGenTaiga2 field_150634_aD;
   private int field_150635_aE;
   private int field_150636_aF;
   private int field_150637_aG;
   private int field_150638_aH;

   protected BiomeGenHills(int p_i45373_1_, boolean p_i45373_2_) {
      super(p_i45373_1_);
      this.field_82915_S = new WorldGenMinable(Blocks.field_150418_aU.func_176223_P().func_177226_a(BlockSilverfish.field_176378_a, BlockSilverfish.EnumType.STONE), 9);
      this.field_150634_aD = new WorldGenTaiga2(false);
      this.field_150635_aE = 0;
      this.field_150636_aF = 1;
      this.field_150637_aG = 2;
      this.field_150638_aH = this.field_150635_aE;
      if (p_i45373_2_) {
         this.field_76760_I.field_76832_z = 3;
         this.field_150638_aH = this.field_150636_aF;
      }

   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      return (WorldGenAbstractTree)(p_150567_1_.nextInt(3) > 0 ? this.field_150634_aD : super.func_150567_a(p_150567_1_));
   }

   public void func_180624_a(World p_180624_1_, Random p_180624_2_, BlockPos p_180624_3_) {
      super.func_180624_a(p_180624_1_, p_180624_2_, p_180624_3_);
      int lvt_4_2_ = 3 + p_180624_2_.nextInt(6);

      int lvt_5_2_;
      int lvt_6_2_;
      int lvt_7_2_;
      for(lvt_5_2_ = 0; lvt_5_2_ < lvt_4_2_; ++lvt_5_2_) {
         lvt_6_2_ = p_180624_2_.nextInt(16);
         lvt_7_2_ = p_180624_2_.nextInt(28) + 4;
         int lvt_8_1_ = p_180624_2_.nextInt(16);
         BlockPos lvt_9_1_ = p_180624_3_.func_177982_a(lvt_6_2_, lvt_7_2_, lvt_8_1_);
         if (p_180624_1_.func_180495_p(lvt_9_1_).func_177230_c() == Blocks.field_150348_b) {
            p_180624_1_.func_180501_a(lvt_9_1_, Blocks.field_150412_bA.func_176223_P(), 2);
         }
      }

      for(lvt_4_2_ = 0; lvt_4_2_ < 7; ++lvt_4_2_) {
         lvt_5_2_ = p_180624_2_.nextInt(16);
         lvt_6_2_ = p_180624_2_.nextInt(64);
         lvt_7_2_ = p_180624_2_.nextInt(16);
         this.field_82915_S.func_180709_b(p_180624_1_, p_180624_2_, p_180624_3_.func_177982_a(lvt_5_2_, lvt_6_2_, lvt_7_2_));
      }

   }

   public void func_180622_a(World p_180622_1_, Random p_180622_2_, ChunkPrimer p_180622_3_, int p_180622_4_, int p_180622_5_, double p_180622_6_) {
      this.field_76752_A = Blocks.field_150349_c.func_176223_P();
      this.field_76753_B = Blocks.field_150346_d.func_176223_P();
      if ((p_180622_6_ < -1.0D || p_180622_6_ > 2.0D) && this.field_150638_aH == this.field_150637_aG) {
         this.field_76752_A = Blocks.field_150351_n.func_176223_P();
         this.field_76753_B = Blocks.field_150351_n.func_176223_P();
      } else if (p_180622_6_ > 1.0D && this.field_150638_aH != this.field_150636_aF) {
         this.field_76752_A = Blocks.field_150348_b.func_176223_P();
         this.field_76753_B = Blocks.field_150348_b.func_176223_P();
      }

      this.func_180628_b(p_180622_1_, p_180622_2_, p_180622_3_, p_180622_4_, p_180622_5_, p_180622_6_);
   }

   private BiomeGenHills func_150633_b(BiomeGenBase p_150633_1_) {
      this.field_150638_aH = this.field_150637_aG;
      this.func_150557_a(p_150633_1_.field_76790_z, true);
      this.func_76735_a(p_150633_1_.field_76791_y + " M");
      this.func_150570_a(new BiomeGenBase.Height(p_150633_1_.field_76748_D, p_150633_1_.field_76749_E));
      this.func_76732_a(p_150633_1_.field_76750_F, p_150633_1_.field_76751_G);
      return this;
   }

   protected BiomeGenBase func_180277_d(int p_180277_1_) {
      return (new BiomeGenHills(p_180277_1_, false)).func_150633_b(this);
   }
}