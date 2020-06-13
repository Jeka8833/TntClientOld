package net.minecraft.item;

import net.minecraft.block.material.MapColor;
import net.minecraft.util.IStringSerializable;

public enum EnumDyeColor implements IStringSerializable
{
    WHITE(0, 15, "white", "white", MapColor.snowColor),
    ORANGE(1, 14, "orange", "orange", MapColor.adobeColor),
    MAGENTA(2, 13, "magenta", "magenta", MapColor.magentaColor),
    LIGHT_BLUE(3, 12, "light_blue", "lightBlue", MapColor.lightBlueColor),
    YELLOW(4, 11, "yellow", "yellow", MapColor.yellowColor),
    LIME(5, 10, "lime", "lime", MapColor.limeColor),
    PINK(6, 9, "pink", "pink", MapColor.pinkColor),
    GRAY(7, 8, "gray", "gray", MapColor.grayColor),
    SILVER(8, 7, "silver", "silver", MapColor.silverColor),
    CYAN(9, 6, "cyan", "cyan", MapColor.cyanColor),
    PURPLE(10, 5, "purple", "purple", MapColor.purpleColor),
    BLUE(11, 4, "blue", "blue", MapColor.blueColor),
    BROWN(12, 3, "brown", "brown", MapColor.brownColor),
    GREEN(13, 2, "green", "green", MapColor.greenColor),
    RED(14, 1, "red", "red", MapColor.redColor),
    BLACK(15, 0, "black", "black", MapColor.blackColor);

    private static final EnumDyeColor[] META_LOOKUP = new EnumDyeColor[values().length];
    private static final EnumDyeColor[] DYE_DMG_LOOKUP = new EnumDyeColor[values().length];
    private final int meta;
    private final int dyeDamage;
    private final String name;
    private final String unlocalizedName;
    private final MapColor mapColor;

    EnumDyeColor(int meta, int dyeDamage, String name, String unlocalizedName, MapColor mapColorIn)
    {
        this.meta = meta;
        this.dyeDamage = dyeDamage;
        this.name = name;
        this.unlocalizedName = unlocalizedName;
        this.mapColor = mapColorIn;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public int getDyeDamage()
    {
        return this.dyeDamage;
    }

    public String getUnlocalizedName()
    {
        return this.unlocalizedName;
    }

    public MapColor getMapColor()
    {
        return this.mapColor;
    }

    public static EnumDyeColor byDyeDamage(int damage)
    {
        if (damage < 0 || damage >= DYE_DMG_LOOKUP.length)
        {
            damage = 0;
        }

        return DYE_DMG_LOOKUP[damage];
    }

    public static EnumDyeColor byMetadata(int meta)
    {
        if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String toString()
    {
        return this.unlocalizedName;
    }

    public String getName()
    {
        return this.name;
    }

    static {
        for (EnumDyeColor enumdyecolor : values())
        {
            META_LOOKUP[enumdyecolor.getMetadata()] = enumdyecolor;
            DYE_DMG_LOOKUP[enumdyecolor.getDyeDamage()] = enumdyecolor;
        }
    }
}
