package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class GuiOptionsRowList extends GuiListExtended {
   private final List<GuiOptionsRowList.Row> field_148184_k = Lists.newArrayList();

   public GuiOptionsRowList(Minecraft p_i45015_1_, int p_i45015_2_, int p_i45015_3_, int p_i45015_4_, int p_i45015_5_, int p_i45015_6_, GameSettings.Options... p_i45015_7_) {
      super(p_i45015_1_, p_i45015_2_, p_i45015_3_, p_i45015_4_, p_i45015_5_, p_i45015_6_);
      this.field_148163_i = false;

      for(int lvt_8_1_ = 0; lvt_8_1_ < p_i45015_7_.length; lvt_8_1_ += 2) {
         GameSettings.Options lvt_9_1_ = p_i45015_7_[lvt_8_1_];
         GameSettings.Options lvt_10_1_ = lvt_8_1_ < p_i45015_7_.length - 1 ? p_i45015_7_[lvt_8_1_ + 1] : null;
         GuiButton lvt_11_1_ = this.func_148182_a(p_i45015_1_, p_i45015_2_ / 2 - 155, 0, lvt_9_1_);
         GuiButton lvt_12_1_ = this.func_148182_a(p_i45015_1_, p_i45015_2_ / 2 - 155 + 160, 0, lvt_10_1_);
         this.field_148184_k.add(new GuiOptionsRowList.Row(lvt_11_1_, lvt_12_1_));
      }

   }

   private GuiButton func_148182_a(Minecraft p_148182_1_, int p_148182_2_, int p_148182_3_, GameSettings.Options p_148182_4_) {
      if (p_148182_4_ == null) {
         return null;
      } else {
         int lvt_5_1_ = p_148182_4_.func_74381_c();
         return (GuiButton)(p_148182_4_.func_74380_a() ? new GuiOptionSlider(lvt_5_1_, p_148182_2_, p_148182_3_, p_148182_4_) : new GuiOptionButton(lvt_5_1_, p_148182_2_, p_148182_3_, p_148182_4_, p_148182_1_.field_71474_y.func_74297_c(p_148182_4_)));
      }
   }

   public GuiOptionsRowList.Row func_148180_b(int p_148180_1_) {
      return (GuiOptionsRowList.Row)this.field_148184_k.get(p_148180_1_);
   }

   protected int func_148127_b() {
      return this.field_148184_k.size();
   }

   public int func_148139_c() {
      return 400;
   }

   protected int func_148137_d() {
      return super.func_148137_d() + 32;
   }

   public static class Row implements GuiListExtended.IGuiListEntry {
      private final Minecraft field_148325_a = Minecraft.func_71410_x();
      private final GuiButton field_148323_b;
      private final GuiButton field_148324_c;

      public Row(GuiButton p_i45014_1_, GuiButton p_i45014_2_) {
         this.field_148323_b = p_i45014_1_;
         this.field_148324_c = p_i45014_2_;
      }

      public void func_180790_a(int p_180790_1_, int p_180790_2_, int p_180790_3_, int p_180790_4_, int p_180790_5_, int p_180790_6_, int p_180790_7_, boolean p_180790_8_) {
         if (this.field_148323_b != null) {
            this.field_148323_b.field_146129_i = p_180790_3_;
            this.field_148323_b.func_146112_a(this.field_148325_a, p_180790_6_, p_180790_7_);
         }

         if (this.field_148324_c != null) {
            this.field_148324_c.field_146129_i = p_180790_3_;
            this.field_148324_c.func_146112_a(this.field_148325_a, p_180790_6_, p_180790_7_);
         }

      }

      public boolean func_148278_a(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_) {
         if (this.field_148323_b.func_146116_c(this.field_148325_a, p_148278_2_, p_148278_3_)) {
            if (this.field_148323_b instanceof GuiOptionButton) {
               this.field_148325_a.field_71474_y.func_74306_a(((GuiOptionButton)this.field_148323_b).func_146136_c(), 1);
               this.field_148323_b.field_146126_j = this.field_148325_a.field_71474_y.func_74297_c(GameSettings.Options.func_74379_a(this.field_148323_b.field_146127_k));
            }

            return true;
         } else if (this.field_148324_c != null && this.field_148324_c.func_146116_c(this.field_148325_a, p_148278_2_, p_148278_3_)) {
            if (this.field_148324_c instanceof GuiOptionButton) {
               this.field_148325_a.field_71474_y.func_74306_a(((GuiOptionButton)this.field_148324_c).func_146136_c(), 1);
               this.field_148324_c.field_146126_j = this.field_148325_a.field_71474_y.func_74297_c(GameSettings.Options.func_74379_a(this.field_148324_c.field_146127_k));
            }

            return true;
         } else {
            return false;
         }
      }

      public void func_148277_b(int p_148277_1_, int p_148277_2_, int p_148277_3_, int p_148277_4_, int p_148277_5_, int p_148277_6_) {
         if (this.field_148323_b != null) {
            this.field_148323_b.func_146118_a(p_148277_2_, p_148277_3_);
         }

         if (this.field_148324_c != null) {
            this.field_148324_c.func_146118_a(p_148277_2_, p_148277_3_);
         }

      }

      public void func_178011_a(int p_178011_1_, int p_178011_2_, int p_178011_3_) {
      }
   }
}
