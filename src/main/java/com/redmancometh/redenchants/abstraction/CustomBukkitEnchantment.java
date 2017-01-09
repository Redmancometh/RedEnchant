package com.redmancometh.redenchants.abstraction;

import org.bukkit.craftbukkit.v1_8_R3.enchantments.CraftEnchantment;
import org.bukkit.inventory.ItemStack;

import net.minecraft.server.v1_8_R3.Enchantment;

public class CustomBukkitEnchantment extends CraftEnchantment
{

    protected String name;
    
    public CustomBukkitEnchantment(Enchantment ench, String name)
    {
        super(ench);
        this.name = name;
    }

    public String getNumeralLevel(int level)
    {
        switch (level)
        {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";

        }
        return level + "";
    }

    @Override
    public String getName()
    {
        System.out.println(CraftEnchantment.getRaw(this) + " CALLED BUKKIT NAME " + name);
        return name;
    }

    @Override
    public int getStartLevel()
    {
        return 1;
    }

    public boolean hasEnchant(ItemStack itemStack)
    {
        return itemStack != null && itemStack.getEnchantments() != null && itemStack.getEnchantments().containsKey(this);
    }

}
