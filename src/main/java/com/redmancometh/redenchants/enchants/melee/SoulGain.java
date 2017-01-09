package com.redmancometh.redenchants.enchants.melee;

import org.bukkit.entity.Player;

import com.redmancometh.redenchants.abstraction.composites.MeleeWeaponEnchant;

public class SoulGain extends MeleeWeaponEnchant
{

    public SoulGain()
    {
        super(90, "SOULGAIN", 3);
    }

    @Override
    public boolean strikePlayer(Player attacker, Player attacked, int level)
    {
        double lifeGain = .5;
        double chance = .10;
        switch (level)
        {
            case 1:
                lifeGain = .5;
                chance = .10;
            case 2:
                lifeGain = 1;
                chance = .8;
            case 3:
                lifeGain = 1.5;
                chance = .5;
        }
        if (Math.random() <= chance)
        {
            attacker.setHealth(Math.min(20, attacker.getHealth() + lifeGain));
        }
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

}
