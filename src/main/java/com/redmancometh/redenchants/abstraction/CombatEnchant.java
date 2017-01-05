package com.redmancometh.redenchants.abstraction;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface CombatEnchant
{
    public default void strikeTarget(Player attacker, LivingEntity e, int level)
    {
        if (e instanceof Player)
        {
            strikePlayer(attacker, (Player) e, level);
            return;
        }
    }

    public abstract boolean strikePlayer(Player attacker, Player attacked, int level);
}
