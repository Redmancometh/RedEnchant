package com.redmancometh.redenchants.enchants.melee;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.redmancometh.redenchants.abstraction.composites.MeleeWeaponEnchant;

public class Daze extends MeleeWeaponEnchant
{

    public Daze()
    {
        super(87, "Daze", 3);
    }

    @Override
    public int getMaxLevel()
    {
        return 3;
    }

    @Override
    public boolean strikePlayer(Player attacker, Player attacked, int level)
    {
        System.out.println("STRIKE DAZE!");
        int nauseaLevel = 1;
        double chance = .15;
        switch (level)
        {
            case 1:
                nauseaLevel = 1;
                chance = .15;
            case 2:
                nauseaLevel = 2;
                chance = .25;
            case 3:
                nauseaLevel = 3;
                chance = .35;
        }
        if (Math.random() <= /*chance*/1)
        {
            attacked.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 7 * 20, nauseaLevel));
        }
        return false;
    }

}
