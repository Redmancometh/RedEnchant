package com.redmancometh.redenchants.abstraction.composites;

import com.redmancometh.redenchants.abstraction.CustomEnchant;
import com.redmancometh.redenchants.abstraction.EquipEnchant;

public abstract class EquippedMeleeWeaponEnchant extends CustomEnchant implements EquipEnchant 
{

    public EquippedMeleeWeaponEnchant(int id, String name)
    {
        super(id, name);
    }
    
}
