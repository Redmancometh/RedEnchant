package com.redmancometh.redenchants.abstraction;

import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.inventory.ItemStack;

public abstract class CustomBukkitEnchantment extends EnchantmentWrapper
{

    protected String name;

    public CustomBukkitEnchantment(int id, String name)
    {
        super(id);
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

    public abstract EnchantmentTarget getItemTarget();

    public abstract int getMaxLevel();

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
