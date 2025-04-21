package brokenheart_undershirt.mixin.NoneRLCraft;

import cursedflames.bountifulbaubles.item.ItemTrinketBrokenHeart;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemTrinketBrokenHeart.class)
public class BrokenheartActivated {
    private static final StatBase BROKEN_HEART_ACTIVATED = (new StatBasic("stat.BROKEN_HEART_ACTIVATED", new TextComponentTranslation(TextFormatting.DARK_RED + "Broken Heart Activated", new Object[0]))).registerStat();

    @Inject(
            method = "onDamage",
            at = @At(value = "INVOKE", target = "Lnet/minecraftforge/event/entity/living/LivingDamageEvent;setAmount(F)V"),
            remap = false
    )
    private static void BrokenHeart(LivingDamageEvent event, CallbackInfo ci) {
        EntityLivingBase entity = event.getEntityLiving();
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.addStat(BROKEN_HEART_ACTIVATED);
        }
    }
}