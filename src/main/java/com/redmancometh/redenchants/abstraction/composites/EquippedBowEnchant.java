package com.redmancometh.redenchants.abstraction.composites;

import com.redmancometh.redenchants.abstraction.CustomEnchant;
import com.redmancometh.redenchants.abstraction.EquipEnchant;

import net.minecraft.server.v1_8_R3.EnchantmentSlotType;

public abstract class EquippedBowEnchant extends CustomEnchant implements EquipEnchant
{

    public EquippedBowEnchant(int id, String name, EnchantmentSlotType slotType, int maxLevel)
    {
        super(id, name, slotType, maxLevel);
    }

}
