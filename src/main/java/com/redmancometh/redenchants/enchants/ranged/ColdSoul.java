package com.redmancometh.redenchants.enchants.ranged;

import com.redmancometh.redenchants.abstraction.composites.RangedWeaponEnchant;

public class ColdSoul extends RangedWeaponEnchant
{

    public ColdSoul()
    {
        super(93, "COLDSOUL", 2);
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

}
