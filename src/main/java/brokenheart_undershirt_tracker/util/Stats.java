package brokenheart_undershirt_tracker.util;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;

public class Stats {
    public static final StatBase BROKEN_HEART_ACTIVATED =
            new StatBasic(
                "stat.BROKEN_HEART_ACTIVATED",
                new TextComponentTranslation("bhut.stat.brokenheartactivated").setStyle(new Style().setColor(TextFormatting.DARK_RED))
            ).registerStat();

    public static final StatBase UNDERSHIRT_ACTIVATED =
            new StatBasic(
                "stat.UNDERSHIRT_ACTIVATED",
                new TextComponentTranslation("bhut.stat.undershirtactivated").setStyle(new Style().setColor(TextFormatting.AQUA))
            ).registerStat();
}
