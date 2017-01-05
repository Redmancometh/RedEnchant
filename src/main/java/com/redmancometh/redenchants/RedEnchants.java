package com.redmancometh.redenchants;

import org.bukkit.plugin.java.JavaPlugin;

import com.redmancometh.redenchants.commands.AdminEnchantCommand;
import com.redmancometh.redenchants.listeners.EnchantListeners;
import com.redmancometh.redenchants.listeners.SignListeners;
import com.redmancometh.redenchants.mediator.EnchantManager;

public class RedEnchants extends JavaPlugin
{

    private EnchantManager enchantManager;
    private static RedEnchants instance;

    public void onEnable()
    {
        instance = this;
        saveDefaultConfig();
        Settings.loadConfig(getConfig());
        enchantManager = getManager();
        getServer().getPluginManager().registerEvents(new EnchantListeners(), this);
        getServer().getPluginManager().registerEvents(new SignListeners(), this);
        getCommand("cench").setExecutor(new AdminEnchantCommand());
    }

    @Override
    public void onDisable()
    {
        super.onDisable();
        enchantManager.unLoadEnchantments();
    }

    public static RedEnchants getInstance()
    {
        return instance;
    }

    public EnchantManager getManager()
    {
        if (enchantManager == null)
        {
            enchantManager = new EnchantManager();
        }
        return enchantManager;
    }
}
