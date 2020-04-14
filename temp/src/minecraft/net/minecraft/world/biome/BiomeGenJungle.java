package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMelon;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenVines;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenJungle extends BiomeGenBase {
   private boolean field_150614_aC;
   private static final IBlockState field_181620_aE;
   private static final IBlockState field_181621_aF;
   private static final IBlockState field_181622_aG;

   public BiomeGenJungle(int p_i45379_1_, boolean p_i45379_2_) {
      super(p_i45379_1_);
      this.field_150614_aC = p_i45379_2_;
      if (p_i45379_2_) {
         this.field_76760_I.field_76832_z = 2;
      } else {
         this.field_76760_I.field_76832_z = 50;
      }

      this.field_76760_I.field_76803_B = 25;
      this.field_76760_I.field_76802_A = 4;
      if (!p_i45379_2_) {
         this.field_76761_J.add(new BiomeGenBase.SpawnListEntry(EntityOcelot.class, 2, 1, 1));
      }

      this.field_76762_K.add(new BiomeGenBase.SpawnListEntry(EntityChicken.class, 10, 4, 4));
   }

   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
      if (p_150567_1_.nextInt(10) == 0) {
         return this.field_76758_O;
      } else if (p_150567_1_.nextInt(2) == 0) {
         return new WorldGenShrub(field_181620_aE, field_181622_aG);
      } else {
         return (WorldGenAbstractTree)(!this.field_150614_aC && p_150567_1_.nextInt(3) == 0 ? new WorldGenMegaJungle(false, 10, 20, field_181620_aE, field_181621_aF) : new WorldGenTrees(false, 4 + p_150567_1_.nextInt(7), field_181620_aE, field_181621_aF, true));
      }
   }

   public WorldGenerator func_76730_b(Random p_76730_1_) {
      return p_76730_1_.nextInt(4) == 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
   }

   public void func_180624_a(World p_180624_1_, Random p_180624_2_, BlockPos p_180624_3_) {
      super.func_180624_a(p_180624_1_, p_180624_2_, p_180624_3_);
      int lvt_4_1_ = p_180624_2_.nextInt(16) + 8;
      int lvt_5_2_ = p_180624_2_.nextInt(16) + 8;
      int lvt_6_2_ = p_180624_2_.nextInt(p_180624_1_.func_175645_m(p_180624_3_.func_177982_a(lvt_4_1_, 0, lvt_5_2_)).func_177956_o() * 2);
      (new WorldGenMelon()).func_180709_b(p_180624_1_, p_180624_2_, p_180624_3_.func_177982_a(lvt_4_1_, lvt_6_2_, lvt_5_2_));
      WorldGenVines lvt_4_2_ = new WorldGenVines();

      for(lvt_5_2_ = 0; lvt_5_2_ < 50; ++lvt_5_2_) {
         lvt_6_2_ = p_180624_2_.nextInt(16) + 8;
         int lvt_7_1_ = true;
         int lvt_8_1_ = p_180624_2_.nextInt(16) + 8;
         lvt_4_2_.func_180709_b(p_180624_1_, p_180624_2_, p_180624_3_.func_177982_a(lvt_6_2_, 128, lvt_8_1_));
      }

   }

   static {
      field_181620_aE = Blocks.field_150364_r.func_176223_P().func_177226_a(BlockOldLog.field_176301_b, BlockPlanks.EnumType.JUNGLE);
      field_181621_aF = Blocks.field_150362_t.func_176223_P().func_177226_a(BlockOldLeaf.field_176239_P, BlockPlanks.EnumType.JUNGLE).func_177226_a(BlockLeaves.field_176236_b, false);
      field_181622_aG = Blocks.field_150362_t.func_176223_P().func_177226_a(BlockOldLeaf.field_176239_P, BlockPlanks.EnumType.OAK).func_177226_a(BlockLeaves.field_176236_b, false);
   }
}