package com.redmancometh.redenchants.abstraction.composites;

import com.redmancometh.redenchants.abstraction.CustomEnchant;
import com.redmancometh.redenchants.abstraction.EquipEnchant;

public abstract class EquippedBowEnchant extends CustomEnchant implements EquipEnchant
{

    public EquippedBowEnchant(int id, String name)
    {
        super(id, name);
    }

}
