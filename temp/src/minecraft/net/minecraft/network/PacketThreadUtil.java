package net.minecraft.network;

import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.src.Config;
import net.minecraft.util.IThreadListener;

public class PacketThreadUtil {
   public static int lastDimensionId = Integer.MIN_VALUE;

   public static <T extends INetHandler> void func_180031_a(final Packet<T> p_180031_0_, final T p_180031_1_, IThreadListener p_180031_2_) throws ThreadQuickExitException {
      if (!p_180031_2_.func_152345_ab()) {
         p_180031_2_.func_152344_a(new Runnable() {
            public void run() {
               PacketThreadUtil.clientPreProcessPacket(p_180031_0_);
               p_180031_0_.func_148833_a(p_180031_1_);
            }
         });
         throw ThreadQuickExitException.field_179886_a;
      } else {
         clientPreProcessPacket(p_180031_0_);
      }
   }

   protected static void clientPreProcessPacket(Packet p_clientPreProcessPacket_0_) {
      if (p_clientPreProcessPacket_0_ instanceof S08PacketPlayerPosLook) {
         Config.getRenderGlobal().onPlayerPositionSet();
      }

      if (p_clientPreProcessPacket_0_ instanceof S07PacketRespawn) {
         S07PacketRespawn respawn = (S07PacketRespawn)p_clientPreProcessPacket_0_;
         lastDimensionId = respawn.func_149082_c();
      } else if (p_clientPreProcessPacket_0_ instanceof S01PacketJoinGame) {
         S01PacketJoinGame joinGame = (S01PacketJoinGame)p_clientPreProcessPacket_0_;
         lastDimensionId = joinGame.func_149194_f();
      } else {
         lastDimensionId = Integer.MIN_VALUE;
      }

   }
}