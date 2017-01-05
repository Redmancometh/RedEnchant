package com.redmancometh.redenchants.abstraction.composites;

import org.bukkit.enchantments.EnchantmentTarget;

public abstract class HeldWeaponEnchant extends HeldEnchant
{

    public HeldWeaponEnchant(int id, String name)
    {
        super(id, name);
    }

    @Override
    public EnchantmentTarget getItemTarget()
    {
        return EnchantmentTarget.WEAPON;
    }
}
