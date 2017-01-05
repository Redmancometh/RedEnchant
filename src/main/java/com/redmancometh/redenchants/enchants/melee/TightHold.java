package com.redmancometh.redenchants.enchants.melee;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.redmancometh.redenchants.abstraction.composites.MeleeWeaponEnchant;

public class TightHold extends MeleeWeaponEnchant
{

    public TightHold()
    {
        super(85, "TIGHTHOLD");
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

    @Override
    public boolean strikePlayer(Player attacker, Player attacked, int level)
    {
        int slowLevel = 1;
        double chance = .15;
        switch (level)
        {
            case 1:
                slowLevel = 1;
                chance = .15;
            case 2:
                slowLevel = 2;
                chance = .25;
            case 3:
                slowLevel = 3;
                chance = .30;
        }
        if (Math.random() <= chance)
        {
            attacked.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, slowLevel));
        }
        return false;
    }

}
