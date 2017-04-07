package com.redmancometh.redenchants.abstraction;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface CombatEnchant
{
    public default void strikeTarget(Player attacker, LivingEntity e, int level)
    {
        if (e instanceof Player)
        {
            System.out.println("STRIKE PLAYER!");
            strikePlayer(attacker, (Player) e, level);
            System.out.println("STRUCK PLAYER!");
            return;
        }
    }

    public abstract boolean strikePlayer(Player attacker, Player attacked, int level);
}
