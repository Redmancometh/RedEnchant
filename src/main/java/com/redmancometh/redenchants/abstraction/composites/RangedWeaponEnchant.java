package com.redmancometh.redenchants.abstraction.composites;

import com.redmancometh.redenchants.abstraction.CustomEnchant;

import net.minecraft.server.v1_8_R3.EnchantmentSlotType;

public abstract class RangedWeaponEnchant extends CustomEnchant
{

    public RangedWeaponEnchant(int id, String name, int maxLevel)
    {
        super(id, name, EnchantmentSlotType.BOW, maxLevel);
    }

    @Override
    public EnchantmentSlotType getItemTarget()
    {
        return EnchantmentSlotType.BOW;
    }
}
