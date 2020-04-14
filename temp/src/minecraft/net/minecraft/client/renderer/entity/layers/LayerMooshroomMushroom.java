package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderMooshroom;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class LayerMooshroomMushroom implements LayerRenderer<EntityMooshroom> {
   private final RenderMooshroom field_177205_a;
   private ModelRenderer modelRendererMushroom;
   private static final ResourceLocation LOCATION_MUSHROOM_RED = new ResourceLocation("textures/entity/cow/mushroom_red.png");
   private static boolean hasTextureMushroom = false;

   public static void update() {
      hasTextureMushroom = Config.hasResource(LOCATION_MUSHROOM_RED);
   }

   public LayerMooshroomMushroom(RenderMooshroom p_i46114_1_) {
      this.field_177205_a = p_i46114_1_;
      this.modelRendererMushroom = new ModelRenderer(this.field_177205_a.field_77045_g);
      this.modelRendererMushroom.func_78787_b(16, 16);
      this.modelRendererMushroom.field_78800_c = -6.0F;
      this.modelRendererMushroom.field_78798_e = -8.0F;
      this.modelRendererMushroom.field_78796_g = MathHelper.PI / 4.0F;
      int[][] faceUvs = new int[][]{null, null, {16, 16, 0, 0}, {16, 16, 0, 0}, null, null};
      this.modelRendererMushroom.addBox(faceUvs, 0.0F, 0.0F, 10.0F, 20.0F, 16.0F, 0.0F, 0.0F);
      int[][] faceUvs2 = new int[][]{null, null, null, null, {16, 16, 0, 0}, {16, 16, 0, 0}};
      this.modelRendererMushroom.addBox(faceUvs2, 10.0F, 0.0F, 0.0F, 0.0F, 16.0F, 20.0F, 0.0F);
   }

   public void func_177141_a(EntityMooshroom p_177141_1_, float p_177141_2_, float p_177141_3_, float p_177141_4_, float p_177141_5_, float p_177141_6_, float p_177141_7_, float p_177141_8_) {
      if (!p_177141_1_.func_70631_g_() && !p_177141_1_.func_82150_aj()) {
         BlockRendererDispatcher blockrendererdispatcher = Minecraft.func_71410_x().func_175602_ab();
         if (hasTextureMushroom) {
            this.field_177205_a.func_110776_a(LOCATION_MUSHROOM_RED);
         } else {
            this.field_177205_a.func_110776_a(TextureMap.field_110575_b);
         }

         GlStateManager.func_179089_o();
         GlStateManager.func_179107_e(1028);
         GlStateManager.func_179094_E();
         GlStateManager.func_179152_a(1.0F, -1.0F, 1.0F);
         GlStateManager.func_179109_b(0.2F, 0.35F, 0.5F);
         GlStateManager.func_179114_b(42.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179094_E();
         GlStateManager.func_179109_b(-0.5F, -0.5F, 0.5F);
         if (hasTextureMushroom) {
            this.modelRendererMushroom.func_78785_a(0.0625F);
         } else {
            blockrendererdispatcher.func_175016_a(Blocks.field_150337_Q.func_176223_P(), 1.0F);
         }

         GlStateManager.func_179121_F();
         GlStateManager.func_179094_E();
         GlStateManager.func_179109_b(0.1F, 0.0F, -0.6F);
         GlStateManager.func_179114_b(42.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179109_b(-0.5F, -0.5F, 0.5F);
         if (hasTextureMushroom) {
            this.modelRendererMushroom.func_78785_a(0.0625F);
         } else {
            blockrendererdispatcher.func_175016_a(Blocks.field_150337_Q.func_176223_P(), 1.0F);
         }

         GlStateManager.func_179121_F();
         GlStateManager.func_179121_F();
         GlStateManager.func_179094_E();
         ((ModelQuadruped)this.field_177205_a.func_177087_b()).field_78150_a.func_78794_c(0.0625F);
         GlStateManager.func_179152_a(1.0F, -1.0F, 1.0F);
         GlStateManager.func_179109_b(0.0F, 0.7F, -0.2F);
         GlStateManager.func_179114_b(12.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.func_179109_b(-0.5F, -0.5F, 0.5F);
         if (hasTextureMushroom) {
            this.modelRendererMushroom.func_78785_a(0.0625F);
         } else {
            blockrendererdispatcher.func_175016_a(Blocks.field_150337_Q.func_176223_P(), 1.0F);
         }

         GlStateManager.func_179121_F();
         GlStateManager.func_179107_e(1029);
         GlStateManager.func_179129_p();
      }

   }

   public boolean func_177142_b() {
      return true;
   }
}
