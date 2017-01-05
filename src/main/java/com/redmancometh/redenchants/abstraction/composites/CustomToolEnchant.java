package com.redmancometh.redenchants.abstraction.composites;

import org.bukkit.enchantments.EnchantmentTarget;

import com.redmancometh.redenchants.abstraction.CustomEnchant;
import com.redmancometh.redenchants.abstraction.ToolEnchant;

public abstract class CustomToolEnchant extends CustomEnchant implements ToolEnchant
{
    public CustomToolEnchant(int id, String name)
    {
        super(id, name);
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return EnchantmentTarget.TOOL;
    }

}
