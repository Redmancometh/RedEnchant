package com.redmancometh.redenchants.enchants.melee;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.redmancometh.redenchants.abstraction.composites.MeleeWeaponEnchant;

public class WitheredBlade extends MeleeWeaponEnchant
{

    public WitheredBlade()
    {
        super(92, "Withered_Blade", 3);
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

    @Override
    public boolean strikePlayer(Player attacker, Player attacked, int level)
    {
        double chance = .15;
        switch (level)
        {
            case 1:
                chance = .15;
                break;
            case 2:
                chance = .20;
                break;
            case 3:
                chance = .25;
                break;
        }
        if (Math.random() <= /*chance*/1)
        {
            attacked.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, (level * 2) * 20, 1));
        }
        return false;
    }

}
