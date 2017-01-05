package com.redmancometh.redenchants.enchants.ranged;

import com.redmancometh.redenchants.abstraction.composites.RangedWeaponEnchant;

public class ColdSoul extends RangedWeaponEnchant
{

    public ColdSoul()
    {
        super(87, "COLDSOUL");
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

}
