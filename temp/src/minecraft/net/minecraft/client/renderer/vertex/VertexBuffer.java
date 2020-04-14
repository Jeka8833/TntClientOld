package net.minecraft.client.renderer.vertex;

import java.nio.ByteBuffer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.optifine.render.VboRange;
import net.optifine.render.VboRegion;
import org.lwjgl.opengl.GL11;

public class VertexBuffer {
   private int field_177365_a;
   private final VertexFormat field_177363_b;
   private int field_177364_c;
   private VboRegion vboRegion;
   private VboRange vboRange;
   private int drawMode;

   public VertexBuffer(VertexFormat p_i46098_1_) {
      this.field_177363_b = p_i46098_1_;
      this.field_177365_a = OpenGlHelper.func_176073_e();
   }

   public void func_177359_a() {
      OpenGlHelper.func_176072_g(OpenGlHelper.field_176089_P, this.field_177365_a);
   }

   public void func_181722_a(ByteBuffer p_181722_1_) {
      if (this.vboRegion != null) {
         this.vboRegion.bufferData(p_181722_1_, this.vboRange);
      } else {
         this.func_177359_a();
         OpenGlHelper.func_176071_a(OpenGlHelper.field_176089_P, p_181722_1_, 35044);
         this.func_177361_b();
         this.field_177364_c = p_181722_1_.limit() / this.field_177363_b.func_177338_f();
      }
   }

   public void func_177358_a(int p_177358_1_) {
      if (this.drawMode > 0) {
         p_177358_1_ = this.drawMode;
      }

      if (this.vboRegion != null) {
         this.vboRegion.drawArrays(p_177358_1_, this.vboRange);
      } else {
         GL11.glDrawArrays(p_177358_1_, 0, this.field_177364_c);
      }

   }

   public void func_177361_b() {
      OpenGlHelper.func_176072_g(OpenGlHelper.field_176089_P, 0);
   }

   public void func_177362_c() {
      if (this.field_177365_a >= 0) {
         OpenGlHelper.func_176074_g(this.field_177365_a);
         this.field_177365_a = -1;
      }

   }

   public void setVboRegion(VboRegion p_setVboRegion_1_) {
      if (p_setVboRegion_1_ != null) {
         this.func_177362_c();
         this.vboRegion = p_setVboRegion_1_;
         this.vboRange = new VboRange();
      }
   }

   public VboRegion getVboRegion() {
      return this.vboRegion;
   }

   public VboRange getVboRange() {
      return this.vboRange;
   }

   public int getDrawMode() {
      return this.drawMode;
   }

   public void setDrawMode(int p_setDrawMode_1_) {
      this.drawMode = p_setDrawMode_1_;
   }
}
