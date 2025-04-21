package brokenheart_undershirt.mixin.NoneRLCraft;

import codersafterdark.reskillable.skill.defense.TraitUndershirt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TraitUndershirt.class)
public class UndershirtActivated {
    private static final StatBase UNDERSHIRT_ACTIVATED = (new StatBasic("stat.UNDERSHIRT_ACTIVATED", new TextComponentTranslation(TextFormatting.AQUA + "Undershirt Activated", new Object[0]))).registerStat();

    @Inject(
            method = "onHurt",
            at = @At(value = "INVOKE", target = "Lnet/minecraftforge/event/entity/living/LivingHurtEvent;setAmount(F)V"),
            remap = false
    )
    public void Undershirt(LivingHurtEvent event, CallbackInfo ci) {
        EntityLivingBase entity = event.getEntityLiving();
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            player.addStat(UNDERSHIRT_ACTIVATED);
        }
    }
}