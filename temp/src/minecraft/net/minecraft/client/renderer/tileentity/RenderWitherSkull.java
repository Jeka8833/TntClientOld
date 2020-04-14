package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.ResourceLocation;

public class RenderWitherSkull extends Render<EntityWitherSkull> {
   private static final ResourceLocation field_110811_a = new ResourceLocation("textures/entity/wither/wither_invulnerable.png");
   private static final ResourceLocation field_110810_f = new ResourceLocation("textures/entity/wither/wither.png");
   private final ModelSkeletonHead field_82401_a = new ModelSkeletonHead();

   public RenderWitherSkull(RenderManager p_i46129_1_) {
      super(p_i46129_1_);
   }

   private float func_82400_a(float p_82400_1_, float p_82400_2_, float p_82400_3_) {
      float lvt_4_1_;
      for(lvt_4_1_ = p_82400_2_ - p_82400_1_; lvt_4_1_ < -180.0F; lvt_4_1_ += 360.0F) {
      }

      while(lvt_4_1_ >= 180.0F) {
         lvt_4_1_ -= 360.0F;
      }

      return p_82400_1_ + p_82400_3_ * lvt_4_1_;
   }

   public void func_76986_a(EntityWitherSkull p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_) {
      GlStateManager.func_179094_E();
      GlStateManager.func_179129_p();
      float lvt_10_1_ = this.func_82400_a(p_76986_1_.field_70126_B, p_76986_1_.field_70177_z, p_76986_9_);
      float lvt_11_1_ = p_76986_1_.field_70127_C + (p_76986_1_.field_70125_A - p_76986_1_.field_70127_C) * p_76986_9_;
      GlStateManager.func_179109_b((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
      float lvt_12_1_ = 0.0625F;
      GlStateManager.func_179091_B();
      GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
      GlStateManager.func_179141_d();
      this.func_180548_c(p_76986_1_);
      this.field_82401_a.func_78088_a(p_76986_1_, 0.0F, 0.0F, 0.0F, lvt_10_1_, lvt_11_1_, lvt_12_1_);
      GlStateManager.func_179121_F();
      super.func_76986_a(p_76986_1_, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
   }

   protected ResourceLocation func_110775_a(EntityWitherSkull p_110775_1_) {
      return p_110775_1_.func_82342_d() ? field_110811_a : field_110810_f;
   }
}
