package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.ModelDragon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.layers.LayerEnderDragonDeath;
import net.minecraft.client.renderer.entity.layers.LayerEnderDragonEyes;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderDragon extends RenderLiving<EntityDragon> {
   private static final ResourceLocation field_110843_g = new ResourceLocation("textures/entity/endercrystal/endercrystal_beam.png");
   private static final ResourceLocation field_110842_f = new ResourceLocation("textures/entity/enderdragon/dragon_exploding.png");
   private static final ResourceLocation field_110844_k = new ResourceLocation("textures/entity/enderdragon/dragon.png");
   protected ModelDragon field_77084_b;

   public RenderDragon(RenderManager p_i46183_1_) {
      super(p_i46183_1_, new ModelDragon(0.0F), 0.5F);
      this.field_77084_b = (ModelDragon)this.field_77045_g;
      this.func_177094_a(new LayerEnderDragonEyes(this));
      this.func_177094_a(new LayerEnderDragonDeath());
   }

   protected void func_77043_a(EntityDragon p_77043_1_, float p_77043_2_, float p_77043_3_, float p_77043_4_) {
      float lvt_5_1_ = (float)p_77043_1_.func_70974_a(7, p_77043_4_)[0];
      float lvt_6_1_ = (float)(p_77043_1_.func_70974_a(5, p_77043_4_)[1] - p_77043_1_.func_70974_a(10, p_77043_4_)[1]);
      GlStateManager.func_179114_b(-lvt_5_1_, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b(lvt_6_1_ * 10.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.func_179109_b(0.0F, 0.0F, 1.0F);
      if (p_77043_1_.field_70725_aQ > 0) {
         float lvt_7_1_ = ((float)p_77043_1_.field_70725_aQ + p_77043_4_ - 1.0F) / 20.0F * 1.6F;
         lvt_7_1_ = MathHelper.func_76129_c(lvt_7_1_);
         if (lvt_7_1_ > 1.0F) {
            lvt_7_1_ = 1.0F;
         }

         GlStateManager.func_179114_b(lvt_7_1_ * this.func_77037_a(p_77043_1_), 0.0F, 0.0F, 1.0F);
      }

   }

   protected void func_77036_a(EntityDragon p_77036_1_, float p_77036_2_, float p_77036_3_, float p_77036_4_, float p_77036_5_, float p_77036_6_, float p_77036_7_) {
      if (p_77036_1_.field_70995_bG > 0) {
         float lvt_8_1_ = (float)p_77036_1_.field_70995_bG / 200.0F;
         GlStateManager.func_179143_c(515);
         GlStateManager.func_179141_d();
         GlStateManager.func_179092_a(516, lvt_8_1_);
         this.func_110776_a(field_110842_f);
         this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
         GlStateManager.func_179092_a(516, 0.1F);
         GlStateManager.func_179143_c(514);
      }

      this.func_180548_c(p_77036_1_);
      this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
      if (p_77036_1_.field_70737_aN > 0) {
         GlStateManager.func_179143_c(514);
         GlStateManager.func_179090_x();
         GlStateManager.func_179147_l();
         GlStateManager.func_179112_b(770, 771);
         GlStateManager.func_179131_c(1.0F, 0.0F, 0.0F, 0.5F);
         this.field_77045_g.func_78088_a(p_77036_1_, p_77036_2_, p_77036_3_, p_77036_4_, p_77036_5_, p_77036_6_, p_77036_7_);
         GlStateManager.func_179098_w();
         GlStateManager.func_179084_k();
         GlStateManager.func_179143_c(515);
      }

   }

   public void func_76986_a(EntityDragon p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      BossStatus.func_82824_a(p_76986_1_, false);
      super.func_76986_a((EntityLiving)p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
      if (p_76986_1_.field_70992_bH != null) {
         this.func_180574_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_9_);
      }

   }

   protected void func_180574_a(EntityDragon p_180574_1_, double p_180574_2_, double p_180574_4_, double p_180574_6_, float p_180574_8_) {
      float lvt_9_1_ = (float)p_180574_1_.field_70992_bH.field_70261_a + p_180574_8_;
      float lvt_10_1_ = MathHelper.func_76126_a(lvt_9_1_ * 0.2F) / 2.0F + 0.5F;
      lvt_10_1_ = (lvt_10_1_ * lvt_10_1_ + lvt_10_1_) * 0.2F;
      float lvt_11_1_ = (float)(p_180574_1_.field_70992_bH.field_70165_t - p_180574_1_.field_70165_t - (p_180574_1_.field_70169_q - p_180574_1_.field_70165_t) * (double)(1.0F - p_180574_8_));
      float lvt_12_1_ = (float)((double)lvt_10_1_ + p_180574_1_.field_70992_bH.field_70163_u - 1.0D - p_180574_1_.field_70163_u - (p_180574_1_.field_70167_r - p_180574_1_.field_70163_u) * (double)(1.0F - p_180574_8_));
      float lvt_13_1_ = (float)(p_180574_1_.field_70992_bH.field_70161_v - p_180574_1_.field_70161_v - (p_180574_1_.field_70166_s - p_180574_1_.field_70161_v) * (double)(1.0F - p_180574_8_));
      float lvt_14_1_ = MathHelper.func_76129_c(lvt_11_1_ * lvt_11_1_ + lvt_13_1_ * lvt_13_1_);
      float lvt_15_1_ = MathHelper.func_76129_c(lvt_11_1_ * lvt_11_1_ + lvt_12_1_ * lvt_12_1_ + lvt_13_1_ * lvt_13_1_);
      GlStateManager.func_179094_E();
      GlStateManager.func_179109_b((float)p_180574_2_, (float)p_180574_4_ + 2.0F, (float)p_180574_6_);
      GlStateManager.func_179114_b((float)(-Math.atan2((double)lvt_13_1_, (double)lvt_11_1_)) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.func_179114_b((float)(-Math.atan2((double)lvt_14_1_, (double)lvt_12_1_)) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
      Tessellator lvt_16_1_ = Tessellator.func_178181_a();
      WorldRenderer lvt_17_1_ = lvt_16_1_.func_178180_c();
      RenderHelper.func_74518_a();
      GlStateManager.func_179129_p();
      this.func_110776_a(field_110843_g);
      GlStateManager.func_179103_j(7425);
      float lvt_18_1_ = 0.0F - ((float)p_180574_1_.field_70173_aa + p_180574_8_) * 0.01F;
      float lvt_19_1_ = MathHelper.func_76129_c(lvt_11_1_ * lvt_11_1_ + lvt_12_1_ * lvt_12_1_ + lvt_13_1_ * lvt_13_1_) / 32.0F - ((float)p_180574_1_.field_70173_aa + p_180574_8_) * 0.01F;
      lvt_17_1_.func_181668_a(5, DefaultVertexFormats.field_181709_i);
      int lvt_20_1_ = true;

      for(int lvt_21_1_ = 0; lvt_21_1_ <= 8; ++lvt_21_1_) {
         float lvt_22_1_ = MathHelper.func_76126_a((float)(lvt_21_1_ % 8) * 3.1415927F * 2.0F / 8.0F) * 0.75F;
         float lvt_23_1_ = MathHelper.func_76134_b((float)(lvt_21_1_ % 8) * 3.1415927F * 2.0F / 8.0F) * 0.75F;
         float lvt_24_1_ = (float)(lvt_21_1_ % 8) * 1.0F / 8.0F;
         lvt_17_1_.func_181662_b((double)(lvt_22_1_ * 0.2F), (double)(lvt_23_1_ * 0.2F), 0.0D).func_181673_a((double)lvt_24_1_, (double)lvt_19_1_).func_181669_b(0, 0, 0, 255).func_181675_d();
         lvt_17_1_.func_181662_b((double)lvt_22_1_, (double)lvt_23_1_, (double)lvt_15_1_).func_181673_a((double)lvt_24_1_, (double)lvt_18_1_).func_181669_b(255, 255, 255, 255).func_181675_d();
      }

      lvt_16_1_.func_78381_a();
      GlStateManager.func_179089_o();
      GlStateManager.func_179103_j(7424);
      RenderHelper.func_74519_b();
      GlStateManager.func_179121_F();
   }

   protected ResourceLocation func_110775_a(EntityDragon p_110775_1_) {
      return field_110844_k;
   }
}
