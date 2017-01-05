package com.redmancometh.redenchants.abstraction.composites;

import org.bukkit.enchantments.EnchantmentTarget;

import com.redmancometh.redenchants.abstraction.CustomEnchant;

public abstract class RangedWeaponEnchant extends CustomEnchant
{

    public RangedWeaponEnchant(int id, String name)
    {
        super(id, name);
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return EnchantmentTarget.BOW;
    }
}
