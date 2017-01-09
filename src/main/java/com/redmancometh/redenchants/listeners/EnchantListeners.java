package com.redmancometh.redenchants.listeners;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.redmancometh.redenchants.RedEnchants;
import com.redmancometh.redenchants.abstraction.CombatEnchant;
import com.redmancometh.redenchants.abstraction.CustomBukkitEnchantment;
import com.redmancometh.redenchants.abstraction.CustomEnchant;
import com.redmancometh.redenchants.abstraction.EquipEnchant;
import com.redmancometh.redenchants.abstraction.ToolEnchant;
import com.redmancometh.redenchants.abstraction.composites.CustomArmorEnchant;

public class EnchantListeners implements Listener
{
    private int taskId;
    {
        scheduleTickTask();
    }

    public int getTaskId()
    {
        return taskId;
    }

    @EventHandler
    public void onPrepare(EnchantItemEvent e)
    {
        e.getEnchantsToAdd().forEach((ench, level) ->
        {
            System.out.println(ench + " TO ENCH " + level);
        });
    }

    @EventHandler
    public void onStruckBy(EntityDamageByEntityEvent e)
    {
        if (e.getEntity() instanceof Player)
        {
            Player p = (Player) e.getEntity();
            Map<CustomArmorEnchant, Integer> enchantsFound = null;
            enchLoop: for (CustomEnchant ench : RedEnchants.getInstance().getManager().getNMSCustomEnchants())
            {
                if (ench instanceof CustomArmorEnchant)
                {
                    for (int x = 36; x <= 39; x++)
                    {
                        ItemStack i = p.getInventory().getItem(x);
                        if (i != null && i.getType() != Material.AIR && i.containsEnchantment(ench.getBukkitEnchantment()))
                        {
                            if (enchantsFound == null)
                            {
                                enchantsFound = new HashMap();
                            }
                            int level = i.getEnchantmentLevel(ench.getBukkitEnchantment());
                            enchantsFound.put((CustomArmorEnchant) ench, level);
                            if (level >= ench.getMaxLevel())
                            {
                                continue enchLoop;
                            }
                        }
                    }
                }
            }
            if (enchantsFound == null)
            {
                return;
            }
            if (e.getDamager() instanceof Projectile)
            {
                enchantsFound.forEach((ench, level) -> ench.onStruckBy((Projectile) e.getDamager(), (Player) e.getEntity(), level));
            }
            else if (e.getDamager() instanceof Player)
            {
                enchantsFound.forEach((ench, level) -> ench.onStruck((Player) e.getEntity(), (Player) e.getDamager(), level));
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void handleMiningEnchants(BlockBreakEvent e)
    {
        if (e.getPlayer().getItemInHand() == null || e.getPlayer().getItemInHand().getEnchantments() == null)
        {
            return;
        }
        for (Enchantment enchantment : e.getPlayer().getItemInHand().getEnchantments().keySet())
        {
            if (enchantment instanceof ToolEnchant)
            {
                ((ToolEnchant) enchantment).handleBlockBreak(e, e.getPlayer().getItemInHand().getEnchantmentLevel(enchantment));
            }
        }
    }

    private void scheduleTickTask()
    {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(RedEnchants.getInstance(), () -> tickPlayers(), 20, 20);
    }

    private int equipTicker;
    {
        equipTicker = Bukkit.getScheduler().scheduleSyncRepeatingTask(RedEnchants.getInstance(), () -> tickPlayers(), 20, 20);
    }

    public int getEquipTaskId()
    {
        return equipTicker;
    }

    @EventHandler
    public void handleCombatEnchants(EntityDamageByEntityEvent e)
    {
        if (e.getDamager() != null && (e.getDamager() instanceof Player) && e.getEntity() != null && e.getEntity() instanceof LivingEntity)
        {
            ItemStack i = ((HumanEntity) e.getDamager()).getItemInHand();
            if (i != null && i.getType() != Material.AIR)
            {
                i.getEnchantments().forEach((ench, level) ->
                {
                    if (ench instanceof CombatEnchant) ((CombatEnchant) ench).strikeTarget((Player) e.getDamager(), (LivingEntity) e.getEntity(), level);
                });
            }
        }
    }

    public void tickPlayers()
    {
        for (Player player : Bukkit.getOnlinePlayers())
        {
            //TODO: Time slicing
            tickPlayer(player);
        }
    }

    public static void tickPlayer(Player player)
    {
        Map<String, Integer> enchantsFound = null;
        enchLoop: for (CustomBukkitEnchantment ench : RedEnchants.getInstance().getManager().getBukkitCustomEnchants())
        {
            if (ench instanceof EquipEnchant)
            {
                for (int x : ((EquipEnchant) ench).getSlots())
                {
                    ItemStack i = player.getInventory().getItem(x);
                    if (i != null && i.getType() != Material.AIR && i.containsEnchantment(ench))
                    {
                        int level = i.getEnchantmentLevel(ench);
                        if (enchantsFound == null)
                        {
                            enchantsFound = new HashMap();
                        }
                        enchantsFound.put(ench.getName(), level);
                        if (level >= ench.getMaxLevel())
                        {
                            continue enchLoop;
                        }
                    }
                }
            }
        }
        if (enchantsFound == null)
        {
            return;
        }
        enchantsFound.forEach((enchName, level) ->
        {
            EquipEnchant ench = (EquipEnchant) RedEnchants.getInstance().getManager().getByName(enchName);
            if (ench.isTickApplied(player))
            {
                return;
            }
            ench.onTickApply(player, level);
            if (!ench.isTickApplied(player))
            {
                return;
            }
            ench.removeEffects(player);
        });

    }

}
