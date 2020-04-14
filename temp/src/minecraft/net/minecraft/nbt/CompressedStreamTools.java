package net.minecraft.nbt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;

public class CompressedStreamTools {
   public static NBTTagCompound func_74796_a(InputStream p_74796_0_) throws IOException {
      DataInputStream lvt_1_1_ = new DataInputStream(new BufferedInputStream(new GZIPInputStream(p_74796_0_)));

      NBTTagCompound var2;
      try {
         var2 = func_152456_a(lvt_1_1_, NBTSizeTracker.field_152451_a);
      } finally {
         lvt_1_1_.close();
      }

      return var2;
   }

   public static void func_74799_a(NBTTagCompound p_74799_0_, OutputStream p_74799_1_) throws IOException {
      DataOutputStream lvt_2_1_ = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(p_74799_1_)));

      try {
         func_74800_a(p_74799_0_, lvt_2_1_);
      } finally {
         lvt_2_1_.close();
      }

   }

   public static void func_74793_a(NBTTagCompound p_74793_0_, File p_74793_1_) throws IOException {
      File lvt_2_1_ = new File(p_74793_1_.getAbsolutePath() + "_tmp");
      if (lvt_2_1_.exists()) {
         lvt_2_1_.delete();
      }

      func_74795_b(p_74793_0_, lvt_2_1_);
      if (p_74793_1_.exists()) {
         p_74793_1_.delete();
      }

      if (p_74793_1_.exists()) {
         throw new IOException("Failed to delete " + p_74793_1_);
      } else {
         lvt_2_1_.renameTo(p_74793_1_);
      }
   }

   public static void func_74795_b(NBTTagCompound p_74795_0_, File p_74795_1_) throws IOException {
      DataOutputStream lvt_2_1_ = new DataOutputStream(new FileOutputStream(p_74795_1_));

      try {
         func_74800_a(p_74795_0_, lvt_2_1_);
      } finally {
         lvt_2_1_.close();
      }

   }

   public static NBTTagCompound func_74797_a(File p_74797_0_) throws IOException {
      if (!p_74797_0_.exists()) {
         return null;
      } else {
         DataInputStream lvt_1_1_ = new DataInputStream(new FileInputStream(p_74797_0_));

         NBTTagCompound var2;
         try {
            var2 = func_152456_a(lvt_1_1_, NBTSizeTracker.field_152451_a);
         } finally {
            lvt_1_1_.close();
         }

         return var2;
      }
   }

   public static NBTTagCompound func_74794_a(DataInputStream p_74794_0_) throws IOException {
      return func_152456_a(p_74794_0_, NBTSizeTracker.field_152451_a);
   }

   public static NBTTagCompound func_152456_a(DataInput p_152456_0_, NBTSizeTracker p_152456_1_) throws IOException {
      NBTBase lvt_2_1_ = func_152455_a(p_152456_0_, 0, p_152456_1_);
      if (lvt_2_1_ instanceof NBTTagCompound) {
         return (NBTTagCompound)lvt_2_1_;
      } else {
         throw new IOException("Root tag must be a named compound tag");
      }
   }

   public static void func_74800_a(NBTTagCompound p_74800_0_, DataOutput p_74800_1_) throws IOException {
      func_150663_a(p_74800_0_, p_74800_1_);
   }

   private static void func_150663_a(NBTBase p_150663_0_, DataOutput p_150663_1_) throws IOException {
      p_150663_1_.writeByte(p_150663_0_.func_74732_a());
      if (p_150663_0_.func_74732_a() != 0) {
         p_150663_1_.writeUTF("");
         p_150663_0_.func_74734_a(p_150663_1_);
      }
   }

   private static NBTBase func_152455_a(DataInput p_152455_0_, int p_152455_1_, NBTSizeTracker p_152455_2_) throws IOException {
      byte lvt_3_1_ = p_152455_0_.readByte();
      if (lvt_3_1_ == 0) {
         return new NBTTagEnd();
      } else {
         p_152455_0_.readUTF();
         NBTBase lvt_4_1_ = NBTBase.func_150284_a(lvt_3_1_);

         try {
            lvt_4_1_.func_152446_a(p_152455_0_, p_152455_1_, p_152455_2_);
            return lvt_4_1_;
         } catch (IOException var8) {
            CrashReport lvt_6_1_ = CrashReport.func_85055_a(var8, "Loading NBT data");
            CrashReportCategory lvt_7_1_ = lvt_6_1_.func_85058_a("NBT Tag");
            lvt_7_1_.func_71507_a("Tag name", "[UNNAMED TAG]");
            lvt_7_1_.func_71507_a("Tag type", lvt_3_1_);
            throw new ReportedException(lvt_6_1_);
         }
      }
   }
}
