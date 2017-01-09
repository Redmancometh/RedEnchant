package com.redmancometh.redenchants.enchants.melee;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.redmancometh.redenchants.abstraction.composites.MeleeWeaponEnchant;

public class Demonic extends MeleeWeaponEnchant
{

    LoadingCache<UUID, Integer> demonicCache = CacheBuilder.newBuilder().build(new CacheLoader<UUID, Integer>()
    {
        public Integer load(UUID key)
        {
            return 0;
        }
    });

    public Demonic()
    {
        super(88, "DEMONIC", 3);
    }

    @Override
    public void strikeTarget(Player attacker, LivingEntity e, int level)
    {
        try
        {
            int number = demonicCache.get(attacker.getUniqueId());
            demonicCache.put(attacker.getUniqueId(), number + 1);
        }
        catch (ExecutionException e1)
        {
            e1.printStackTrace();
        }
    }

    @Override
    public boolean strikePlayer(Player attacker, Player attacked, int level)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getMaxLevel()
    {
        return 4;
    }

}
