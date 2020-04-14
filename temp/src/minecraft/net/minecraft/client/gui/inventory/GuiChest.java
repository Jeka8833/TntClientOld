package net.minecraft.client.gui.inventory;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiChest extends GuiContainer {
   private static final ResourceLocation field_147017_u = new ResourceLocation("textures/gui/container/generic_54.png");
   private IInventory field_147016_v;
   private IInventory field_147015_w;
   private int field_147018_x;

   public GuiChest(IInventory p_i46315_1_, IInventory p_i46315_2_) {
      super(new ContainerChest(p_i46315_1_, p_i46315_2_, Minecraft.func_71410_x().field_71439_g));
      this.field_147016_v = p_i46315_1_;
      this.field_147015_w = p_i46315_2_;
      this.field_146291_p = false;
      int lvt_3_1_ = 222;
      int lvt_4_1_ = lvt_3_1_ - 108;
      this.field_147018_x = p_i46315_2_.func_70302_i_() / 9;
      this.field_147000_g = lvt_4_1_ + this.field_147018_x * 18;
   }

   protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
      this.field_146289_q.func_78276_b(this.field_147015_w.func_145748_c_().func_150260_c(), 8, 6, 4210752);
      this.field_146289_q.func_78276_b(this.field_147016_v.func_145748_c_().func_150260_c(), 8, this.field_147000_g - 96 + 2, 4210752);
   }

   protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
      GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
      this.field_146297_k.func_110434_K().func_110577_a(field_147017_u);
      int lvt_4_1_ = (this.field_146294_l - this.field_146999_f) / 2;
      int lvt_5_1_ = (this.field_146295_m - this.field_147000_g) / 2;
      this.func_73729_b(lvt_4_1_, lvt_5_1_, 0, 0, this.field_146999_f, this.field_147018_x * 18 + 17);
      this.func_73729_b(lvt_4_1_, lvt_5_1_ + this.field_147018_x * 18 + 17, 0, 126, this.field_146999_f, 96);
   }
}
