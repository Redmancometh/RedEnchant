package com.redmancometh.redenchants.abstraction.composites;

import com.redmancometh.redenchants.abstraction.EquipEnchant;

public abstract class EquippedArmorEnchant extends CustomArmorEnchant implements EquipEnchant
{

    public EquippedArmorEnchant(int id, String name)
    {
        super(id, name);
    }

}
