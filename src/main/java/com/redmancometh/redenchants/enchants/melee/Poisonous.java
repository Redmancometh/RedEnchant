package com.redmancometh.redenchants.enchants.melee;

import java.util.Random;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.redmancometh.redenchants.abstraction.composites.MeleeWeaponEnchant;

public class Poisonous extends MeleeWeaponEnchant
{
    private static Random rand = new Random();

    public Poisonous()
    {
        super(89, "POISONOUS", 3);
    }

    @Override
    public void strikeTarget(Player attacker, LivingEntity e, int level)
    {

    }

    @Override
    public boolean strikePlayer(Player attacker, Player attacked, int level)
    {
        if (Math.random() <= level * .15)
        {
            int minTime = 5;
            int maxTime = 15;
            if (level == 2)
            {
                minTime = 15;
                maxTime = 30;
            }
            else if (level == 3)
            {
                minTime = 30;
                maxTime = 45;
            }
            int time = rand.nextInt(maxTime - minTime) + minTime;
            attacked.addPotionEffect(new PotionEffect(PotionEffectType.POISON, time * 20, 1));
        }
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 2;
    }

}
