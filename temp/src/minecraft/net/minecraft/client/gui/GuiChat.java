package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiChat extends GuiScreen {
   private static final Logger field_146408_f = LogManager.getLogger();
   private String field_146410_g = "";
   private int field_146416_h = -1;
   private boolean field_146417_i;
   private boolean field_146414_r;
   private int field_146413_s;
   private List<String> field_146412_t = Lists.newArrayList();
   protected GuiTextField field_146415_a;
   private String field_146409_v = "";

   public GuiChat() {
   }

   public GuiChat(String p_i1024_1_) {
      this.field_146409_v = p_i1024_1_;
   }

   public void func_73866_w_() {
      Keyboard.enableRepeatEvents(true);
      this.field_146416_h = this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().size();
      this.field_146415_a = new GuiTextField(0, this.field_146289_q, 4, this.field_146295_m - 12, this.field_146294_l - 4, 12);
      this.field_146415_a.func_146203_f(100);
      this.field_146415_a.func_146185_a(false);
      this.field_146415_a.func_146195_b(true);
      this.field_146415_a.func_146180_a(this.field_146409_v);
      this.field_146415_a.func_146205_d(false);
   }

   public void func_146281_b() {
      Keyboard.enableRepeatEvents(false);
      this.field_146297_k.field_71456_v.func_146158_b().func_146240_d();
   }

   public void func_73876_c() {
      this.field_146415_a.func_146178_a();
   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) throws IOException {
      this.field_146414_r = false;
      if (p_73869_2_ == 15) {
         this.func_146404_p_();
      } else {
         this.field_146417_i = false;
      }

      if (p_73869_2_ == 1) {
         this.field_146297_k.func_147108_a((GuiScreen)null);
      } else if (p_73869_2_ != 28 && p_73869_2_ != 156) {
         if (p_73869_2_ == 200) {
            this.func_146402_a(-1);
         } else if (p_73869_2_ == 208) {
            this.func_146402_a(1);
         } else if (p_73869_2_ == 201) {
            this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(this.field_146297_k.field_71456_v.func_146158_b().func_146232_i() - 1);
         } else if (p_73869_2_ == 209) {
            this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(-this.field_146297_k.field_71456_v.func_146158_b().func_146232_i() + 1);
         } else {
            this.field_146415_a.func_146201_a(p_73869_1_, p_73869_2_);
         }
      } else {
         String lvt_3_1_ = this.field_146415_a.func_146179_b().trim();
         if (lvt_3_1_.length() > 0) {
            this.func_175275_f(lvt_3_1_);
         }

         this.field_146297_k.func_147108_a((GuiScreen)null);
      }

   }

   public void func_146274_d() throws IOException {
      super.func_146274_d();
      int lvt_1_1_ = Mouse.getEventDWheel();
      if (lvt_1_1_ != 0) {
         if (lvt_1_1_ > 1) {
            lvt_1_1_ = 1;
         }

         if (lvt_1_1_ < -1) {
            lvt_1_1_ = -1;
         }

         if (!func_146272_n()) {
            lvt_1_1_ *= 7;
         }

         this.field_146297_k.field_71456_v.func_146158_b().func_146229_b(lvt_1_1_);
      }

   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) throws IOException {
      if (p_73864_3_ == 0) {
         IChatComponent lvt_4_1_ = this.field_146297_k.field_71456_v.func_146158_b().func_146236_a(Mouse.getX(), Mouse.getY());
         if (this.func_175276_a(lvt_4_1_)) {
            return;
         }
      }

      this.field_146415_a.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
   }

   protected void func_175274_a(String p_175274_1_, boolean p_175274_2_) {
      if (p_175274_2_) {
         this.field_146415_a.func_146180_a(p_175274_1_);
      } else {
         this.field_146415_a.func_146191_b(p_175274_1_);
      }

   }

   public void func_146404_p_() {
      String lvt_3_2_;
      if (this.field_146417_i) {
         this.field_146415_a.func_146175_b(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false) - this.field_146415_a.func_146198_h());
         if (this.field_146413_s >= this.field_146412_t.size()) {
            this.field_146413_s = 0;
         }
      } else {
         int lvt_1_1_ = this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false);
         this.field_146412_t.clear();
         this.field_146413_s = 0;
         String lvt_2_1_ = this.field_146415_a.func_146179_b().substring(lvt_1_1_).toLowerCase();
         lvt_3_2_ = this.field_146415_a.func_146179_b().substring(0, this.field_146415_a.func_146198_h());
         this.func_146405_a(lvt_3_2_, lvt_2_1_);
         if (this.field_146412_t.isEmpty()) {
            return;
         }

         this.field_146417_i = true;
         this.field_146415_a.func_146175_b(lvt_1_1_ - this.field_146415_a.func_146198_h());
      }

      if (this.field_146412_t.size() > 1) {
         StringBuilder lvt_1_2_ = new StringBuilder();

         for(Iterator lvt_2_2_ = this.field_146412_t.iterator(); lvt_2_2_.hasNext(); lvt_1_2_.append(lvt_3_2_)) {
            lvt_3_2_ = (String)lvt_2_2_.next();
            if (lvt_1_2_.length() > 0) {
               lvt_1_2_.append(", ");
            }
         }

         this.field_146297_k.field_71456_v.func_146158_b().func_146234_a(new ChatComponentText(lvt_1_2_.toString()), 1);
      }

      this.field_146415_a.func_146191_b((String)this.field_146412_t.get(this.field_146413_s++));
   }

   private void func_146405_a(String p_146405_1_, String p_146405_2_) {
      if (p_146405_1_.length() >= 1) {
         BlockPos lvt_3_1_ = null;
         if (this.field_146297_k.field_71476_x != null && this.field_146297_k.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
            lvt_3_1_ = this.field_146297_k.field_71476_x.func_178782_a();
         }

         this.field_146297_k.field_71439_g.field_71174_a.func_147297_a(new C14PacketTabComplete(p_146405_1_, lvt_3_1_));
         this.field_146414_r = true;
      }
   }

   public void func_146402_a(int p_146402_1_) {
      int lvt_2_1_ = this.field_146416_h + p_146402_1_;
      int lvt_3_1_ = this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().size();
      lvt_2_1_ = MathHelper.func_76125_a(lvt_2_1_, 0, lvt_3_1_);
      if (lvt_2_1_ != this.field_146416_h) {
         if (lvt_2_1_ == lvt_3_1_) {
            this.field_146416_h = lvt_3_1_;
            this.field_146415_a.func_146180_a(this.field_146410_g);
         } else {
            if (this.field_146416_h == lvt_3_1_) {
               this.field_146410_g = this.field_146415_a.func_146179_b();
            }

            this.field_146415_a.func_146180_a((String)this.field_146297_k.field_71456_v.func_146158_b().func_146238_c().get(lvt_2_1_));
            this.field_146416_h = lvt_2_1_;
         }
      }
   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      func_73734_a(2, this.field_146295_m - 14, this.field_146294_l - 2, this.field_146295_m - 2, Integer.MIN_VALUE);
      this.field_146415_a.func_146194_f();
      IChatComponent lvt_4_1_ = this.field_146297_k.field_71456_v.func_146158_b().func_146236_a(Mouse.getX(), Mouse.getY());
      if (lvt_4_1_ != null && lvt_4_1_.func_150256_b().func_150210_i() != null) {
         this.func_175272_a(lvt_4_1_, p_73863_1_, p_73863_2_);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_146406_a(String[] p_146406_1_) {
      if (this.field_146414_r) {
         this.field_146417_i = false;
         this.field_146412_t.clear();
         String[] lvt_2_1_ = p_146406_1_;
         int lvt_3_1_ = p_146406_1_.length;

         for(int lvt_4_1_ = 0; lvt_4_1_ < lvt_3_1_; ++lvt_4_1_) {
            String lvt_5_1_ = lvt_2_1_[lvt_4_1_];
            if (lvt_5_1_.length() > 0) {
               this.field_146412_t.add(lvt_5_1_);
            }
         }

         String lvt_2_2_ = this.field_146415_a.func_146179_b().substring(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false));
         String lvt_3_2_ = StringUtils.getCommonPrefix(p_146406_1_);
         if (lvt_3_2_.length() > 0 && !lvt_2_2_.equalsIgnoreCase(lvt_3_2_)) {
            this.field_146415_a.func_146175_b(this.field_146415_a.func_146197_a(-1, this.field_146415_a.func_146198_h(), false) - this.field_146415_a.func_146198_h());
            this.field_146415_a.func_146191_b(lvt_3_2_);
         } else if (this.field_146412_t.size() > 0) {
            this.field_146417_i = true;
            this.func_146404_p_();
         }
      }

   }

   public boolean func_73868_f() {
      return false;
   }
}
