package brokenheart_undershirt.mixin.RLCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rlmixins.handlers.reskillable.UndershirtHandler;

@Mixin(UndershirtHandler.class)
public class UndershirtActivatedRLCraft {
    private static final StatBase UNDERSHIRT_ACTIVATED = (new StatBasic("stat.UNDERSHIRT_ACTIVATED", new TextComponentTranslation(TextFormatting.AQUA + "Undershirt Activated", new Object[0]))).registerStat();

    @Inject(
            method = "onFirstAidLivingDamageHigh",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/EntityPlayer;DDDLnet/minecraft/util/SoundEvent;Lnet/minecraft/util/SoundCategory;FF)V")
    )
    private static void Undershirt(ichttt.mods.firstaid.api.event.FirstAidLivingDamageEvent event, CallbackInfo ci) {
        if (event.getEntityPlayer() != null && !event.getEntityPlayer().world.isRemote) {
            EntityPlayer player = event.getEntityPlayer();
            player.addStat(UNDERSHIRT_ACTIVATED);
        }
    }
}