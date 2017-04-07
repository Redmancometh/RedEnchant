package com.redmancometh.redenchants.enchants.melee;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.redmancometh.redenchants.abstraction.composites.MeleeWeaponEnchant;

import net.md_5.bungee.api.ChatColor;

public class Demonic extends MeleeWeaponEnchant
{

    LoadingCache<UUID, Integer> demonicCache = CacheBuilder.newBuilder().expireAfterAccess(5, TimeUnit.SECONDS).build(new CacheLoader<UUID, Integer>()
    {
        public Integer load(UUID key)
        {
            return 0;
        }
    });

    public Demonic()
    {
        super(88, "Demonic", 3);
    }

    @Override
    public void strikeTarget(Player attacker, LivingEntity e, int level)
    {
        try
        {
            int number = demonicCache.get(attacker.getUniqueId());
            demonicCache.put(attacker.getUniqueId(), number + 1);
            attacker.sendMessage(ChatColor.GOLD + "[DEBUG]: Got a demonic charge!");
        }
        catch (ExecutionException e1)
        {
            e1.printStackTrace();
        }
    }

    @Override
    public boolean strikePlayer(Player attacker, Player attacked, int level)
    {
        try
        {
            int number = demonicCache.get(attacker.getUniqueId());
            demonicCache.put(attacker.getUniqueId(), number + 1);
            attacker.sendMessage(ChatColor.GOLD + "[DEBUG]: Got a demonic charge!");
        }
        catch (ExecutionException e1)
        {
            e1.printStackTrace();
        }
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 4;
    }

}
