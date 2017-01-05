package com.redmancometh.redenchants.abstraction.composites;

import org.bukkit.enchantments.EnchantmentTarget;

public abstract class HeldToolEnchant extends HeldEnchant
{

    public HeldToolEnchant(int id, String name)
    {
        super(id, name);
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return EnchantmentTarget.TOOL;
    }
}
