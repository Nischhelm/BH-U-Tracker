package brokenheart_undershirt.mixin.RLCraft;

import ichttt.mods.firstaid.api.event.FirstAidLivingDamageEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rlmixins.handlers.bountifulbaubles.BrokenHeartBaubleHandler;

@Mixin(BrokenHeartBaubleHandler.class)
public class BrokenheartActivatedRLCraft {
    private static final StatBase BROKEN_HEART_ACTIVATED = (new StatBasic("stat.BROKEN_HEART_ACTIVATED", new TextComponentTranslation(TextFormatting.DARK_RED + "Broken Heart Activated", new Object[0]))).registerStat();

    @Inject(
            method = "onFirstAidLivingDamageLow",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/EntityPlayer;DDDLnet/minecraft/util/SoundEvent;Lnet/minecraft/util/SoundCategory;FF)V")
    )
    private static void BrokenHeart(FirstAidLivingDamageEvent event, CallbackInfo ci) {
        if (event.getEntityPlayer() != null && !event.getEntityPlayer().world.isRemote) {
            EntityPlayer player = event.getEntityPlayer();
            player.addStat(BROKEN_HEART_ACTIVATED);
        }
    }
}