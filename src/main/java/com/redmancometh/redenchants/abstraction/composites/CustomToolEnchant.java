package com.redmancometh.redenchants.abstraction.composites;

import com.redmancometh.redenchants.abstraction.CustomEnchant;
import com.redmancometh.redenchants.abstraction.ToolEnchant;

import net.minecraft.server.v1_8_R3.EnchantmentSlotType;

public abstract class CustomToolEnchant extends CustomEnchant implements ToolEnchant
{
    public CustomToolEnchant(int id, String name, int maxLevel)
    {
        super(id, name, EnchantmentSlotType.DIGGER, maxLevel);
    }

    @Override
    public EnchantmentSlotType getItemTarget()
    {
        return EnchantmentSlotType.DIGGER;
    }

}
